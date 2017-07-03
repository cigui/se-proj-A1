## 前言
昨天做好了MongoDB的安装、配置以及Spring Data MongoDB中关于MongoTemplate的配置，今天尝试着使用Struts + MongoDB实现图片的存储与获取功能，并且做一下笔记。
## GridFS
- GridFS是MongoDB提供的一种存储文件的方式。
- MongoDB中BSON对象最大不能超过16MB，但GridFS可以将一个大文件分割为多个较小的文档，允许我们保存大的文件对象。
- 1.10.3.RELEASE版的Spring Data MongoDB中对GridFS也提供了支持。
## GridFsTemplate基本介绍
- 类似于MongoTemplate，GridFsTemplate是Spring Data MongoDB提供的一个用于进行GridFS相关操作的类。
- 它的获取也类似于MongoTemplate，有两种方式。
    1. 通过java类进行初始化，代码如下：
    ```
    class GridFsConfiguration extends AbstractMongoConfiguration {

        // … further configuration omitted

        @Bean
        public GridFsTemplate gridFsTemplate() {
            return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
        }
    }
    ```
    - 这段代码来自[Spring Data MongoDB官方文档](http://docs.spring.io/spring-data/data-mongo/docs/1.10.3.RELEASE/reference/html/#gridfs)，不过我自己没有试过这么配置。  
    2. 通过xml文件进行初始化并注入到类中，具体做法如下：
    - 在昨天进行过基础配置的xml文件中再添加以下代码：
    ```
    <mongo:db-factory id="mongoDbFactory" dbname="db" />
	<mongo:mapping-converter id="converter" />

	<bean id="gridFsTemplate" class="org.springframework.data.mongodb.gridfs.GridFsTemplate">
		<constructor-arg ref="mongoDbFactory" />
		<constructor-arg ref="converter" />
	</bean>
    ```
    其中，db-factory中的dbname属性定义了数据库名称，至于mapping-converter我也不清楚是什么，反正是GridFsTemplate需要用到的一个东西。
    - 另外还要在需要使用GridFsTemplate的自定义类中声明私有变量并提供setter，以及在xml文件中定义相应的bean和属性，类似于昨天写的MongoTemplate的获取，这里就不重复了。
## 尝试使用Struts + GridFsTemplate进行图片的上传
### 前端
- 十分简单的一段代码：
```
    <form action="test" method="post" enctype="multipart/form-data">
		<input type="file" name="file" />
		<button type="submit">submit</button>
	</form>
```
- 需要注意的是
    - form的action属性需要和struts.xml中定义的action的name属性相同，method需要是"post"，以及enctype需要是"multipart/form-data"
    - input的name属性需要和action类中定义的私有变量相对应
### 后端
- Action类
    - 首先需要定义GridFsTemplate的私有变量，并提供setter方法。`private GridFsTemplate gridFsTemplate;`
    - 另外关于文件的属性需要定义**三个**（否则struts会判断输入异常，返回result input而不执行action），并且每个都要提供setter方法。代码如下：
    ```
        private File file; 
	    private String fileContentType;// 文件的类型  
	    private String fileFileName;// 文件的名称  
    ```
    - 在execute方法中，我只写了一句uploadFile()然后就return SUCCESS了。
    - 在uploadFile方法中进行文件上传，主要代码如下：
    ```
    	FileInputStream fileInputStream=new FileInputStream(file);
		DBObject metadata = new BasicDBObject("testId", "000");
		fileFileName = "test.png";
		GridFSFile gridFSFile = gridFsTemplate.store(fileInputStream, fileFileName, fileContentType, metadata);
		String fileId = gridFSFile.getId().toString();  
            System.out.println(fileId);
    ```
    - 其中gridFsTemplate.store()进行文件的存储，这个方法需要的参数包括文件的输入流fileInputStream，文件的名字fileFileName，文件类型fileContentType，以及文件的元数据metadata。
    - 元数据中允许我们存储自定义的属性，例如"testId"，这样之后获取文件时我们可以根据元数据中的自定义属性而不是文件名或文件ID进行查找。
    - 之后两句获取fileId和在控制台输出只是做测试用，没有什么实际意义。
- struts.xml配置
    - 这里只做一个简单的配置，结果返回success后重定向到result（后面会定义result的action，它返回上传的图片。）代码如下：
    ```
        <!-- test -->
		<action name="test" class="action.TestAction">
			<result name="success" type="redirect">result</result>
		</action>
    ```
## 尝试使用Struts + GridFsTemplate进行图片的获取
### 前端
- 十分简单的一行代码：`<img src="result?testId=000" />`
- img的src属性写一个action名，并且在'?'后面写需要提供给action的参数
### 后端
- struts.xml的配置
    - struts提供了一种用于向浏览器输出流的result type，官方文档对它的解释是  
    `Used to stream an InputStream back to the browser (usually for file downloads)`
    - 在xml文件中写法如下：
    ```
        <action name="result" class="action.ResultAction">
			<result type="stream">
				<param name="contentType">image/png</param>
				<param name="inputName">inputStream</param>
				<param name="bufferSize">4096</param>
			</result>
		</action>
    ```
    - 需要定义的内容包括contentType（内容的类型）, inputName（输入流的名字）和bufferSize（缓冲区大小）
    - 注意定义了inputName为inputStream之后，struts返回结果时会需要从action中定义的getInputStream()方法中获取输入流
- Action类
    - 和之前类似，需要定义私有变量并提供setter方法。`private GridFsTemplate gridFsTemplate;`
    - 根据struts.xml的配置，这个Action只需要提供核心的方法getInputStream()。
    - 核心代码如下：
    ```
    public InputStream getInputStream() {
	/*  GridFSDBFile result = gridFsTemplate.findOne(new Query(Criteria.where("filename").is("test.png")));*/
		GridFSDBFile result = gridFsTemplate.findOne(new Query(Criteria.where("metadata.testId").is(testId)));
		return result.getInputStream();
	}
    ```
    - 注意GridFSDBFile, Query, Criteria都是需要import的类，把代码直接写出来Eclipse的验证会发现未定义的类并且提供可能的解决方案，里面就有导入的选项。
    - 这里写了两种获取方式，分别是根据文件名和metadata中的自定义属性testId查询文件。
    - 本来的话大概是要在action类里定义私有变量inputStream，提供getter方法然后在execute方法中设置好inputStream的，不过我这里没定义inputStream也没写execute方法，测试过也能正常运行。
    - 不过这么写的话一旦查询语句有错，就会报错说struts没有找到action类中定义的inputStream变量。
