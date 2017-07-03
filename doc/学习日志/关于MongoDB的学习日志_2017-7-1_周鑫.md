## 前言
根据助教的建议，图片的存储使用MongoDB会比较好一些。虽然这个东西在web课里介绍过，但是我一直没有好好去学过，于是今天一边试着用一下一边学习顺便做一下笔记。

## 安装与配置
- 安装  
    - 在[MongoDB下载中心](https://www.mongodb.com/download-center#community)可以获得最新的社区版MongoDB Server。  
- 配置  
    - 之前在另一台笔记本上装mongodb时在网上找到了一份比较详细的配置教程[《学习MongoDB 一：MongoDB 入门（安装与配置）》](http://blog.csdn.net/congcong68/article/details/44277469)，当时是直接按照这个过程走一遍就顺利配置完成了，不过今天在这台笔记本上配置时，似乎因为版本更新了所以有些过程不太一样。  
    - 因为下载的是msi安装包而不是压缩包，就装在了一个有点蠢的路径：“d:\program files\mongodb\server\3.4\”，后来直接把里面全部文件复制粘贴到了另一个路径里：“d:\MongoDB”。
    - 另外，按照教程配置的时候也不是很顺利，例如执行命令“mongod.exe  --config d:\mongodb\mongodb.config”的时候返回了一个特别蠢的异常，大意是说不能打开mongodb.config文件，一看错误原因竟然是执行这条命令的时候找config的路径并不是"d:\mongodb\mongodb.config"，而是"d:\mongodb\bin\d\mongodb\mongodb.config"。
    - 没办法，只能把mongodb.config直接放到bin文件夹下面，再把config里的路径也改成bin下的目录了，这才把教程里的配置流程走完。
    - 然后到了教程的第三部分，“添加MongoDB到Windows Service”。这里主要用到的一个命令是mongod.exe--dbpath=d:\mongodb\data\db --logpath=d:\mongodb\data\log\log.txt  --install --serviceName "MongoDB"。然后我才发现，似乎之前的工作其实可以不用做，因为配置文件里也只设置了dbpath和logpath两个属性，而这两个属性在这条命令里也设置了，所以实际上可以跳过教程中之前的配置过程，直接到第三部分来进行配置的。这样配置之后，就可以通过"net start mongodb"和"net stop mongodb"启动和停止MongoDB服务了。

## 使用
- MongoDB Shell
    - 在命令行切换到bin目录执行mongo命令，可以进入mongodb的shell
    - 可用的命令在[菜鸟教程](http://www.runoob.com/mongodb/mongodb-tutorial.html)里都有，不过因为不是这次项目的重点，所以我也只看了几个基础命令。
- GUI管理工具
    - 在[《MongoDB 生态 - 可视化管理工具》](https://yq.aliyun.com/articles/65161) 里有各种GUI工具的介绍
    - 在其中随便挑了一个来用，[NoSQL Manager for MongoDB](https://www.mongodbmanager.com/)，使用上还是很方便的。

## 应用于Java项目中

### Spring Data MongoDB
- 根据chp的建议，可以使用Spring框架中对MongoDB的支持包：[Spring Data MongoDB](http://projects.spring.io/spring-data-mongodb/)
- 对于使用Maven的项目，可以直接在pom.xml中添加依赖，目前最新版依赖代码如下：  
```
    <dependencies>
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-mongodb</artifactId>
            <version>1.10.4.RELEASE</version>
        </dependency>
    </dependencies>
 ```
- Spring对MongoDB的支持使得我们可以很方便地进行增删改查操作。之前使用Spring + Hibernate时，Dao层实现一般会是扩展一个Spring提供的HibernateDaoSupport类，然后通过getHibernateTemplate()方法获取HibernateTemplate类进行数据持久化。类似地，当我们使用Spring + MongoDB时也是通过获取MongoTemplate类来进行数据持久化操作。
- MongoTemplate的获取一般有两种方式：
    1. 通过java类进行初始化获得MongoTemplate，代码如下：  
    ```
    @Configuration
    public class AppConfig {

        public @Bean Mongo mongo() throws Exception {
            return new Mongo("localhost");
        }

        public @Bean MongoTemplate mongoTemplate() throws Exception {
            return new MongoTemplate(mongo(), "mydatabase");
        }
    }
    ```
    2. 通过xml文件进行初始化并注入到dao的实现类中，具体做法如下：
        - 找到Spring的配置文件(applicationContext.xml)，在其中的"beans"节点中加入与mongodb相关的属性，如下列代码中用'*'包住的部分。
        ```
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:context="http://www.springframework.org/schema/context"
                *xmlns:mongo="http://www.springframework.org/schema/data/mongo"*
                xsi:schemaLocation=
                "http://www.springframework.org/schema/context
                http://www.springframework.org/schema/context/spring-context-3.0.xsd
                *http://www.springframework.org/schema/data/mongo 
                http://www.springframework.org/schema/data/mongo/spring-mongo-1.0.xsd*
                http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

                ...
        </beans>
        ```
        - 在配置文件中加入下面的bean声明：
        ```
        <mongo:mongo host="localhost" port="27017"/>

        <bean id="mongoTemplate" class="org.springframework.data.mongodb.core.MongoTemplate">
        <constructor-arg ref="mongo"/>
        <constructor-arg name="databaseName" value="db"/>
        </bean>
        ```
        - 之后，在要获取MongoTemplate的dao的实现类中声明私有变量并提供setter方法，代码如下：
        ```
        private MongoTemplate mongoTemplate;

        public void setMongoTemplate(MongoTemplate mongoTemplate) {
            this.mongoTemplate = mongoTemplate;
        }
        ```
        - 另外还需要在配置文件中加入对该dao的实现类的bean声明，代码如下：
        ```
        <bean id="bookDao" class="dao.impl.BookDaoImpl">
            <property name="mongoTemplate" ref="mongoTemplate" />
        </bean>
        ```
        - 通过这些配置，就可以让Spring做MongoTemplate的注入工作了。
- 从上面对两种获取MongoTemplate的方式介绍所花费的篇幅的差距就可以看出来，我是偏爱后一种的。虽然后一种方式配置起来可能略微麻烦一点（我之前在另一台电脑上尝试过并且失败了，今天又试一次才成功了），但是用前一种方式获得MongoTemplate一点也不Spring，一旦修改数据库的名字就得去修改源码，感觉有点蠢。因此在web的作业中和这次项目中，我应该会采用后一种方式。
- 获取MongoTemplate之后，就可以通过它对数据库进行增删改查操作了。这里的操作与通过HibernateTemplate对MySQL进行增删改查类似，可以直接insert一个自定义类对象（例如Book），而不需要像使用MongoDB Shell那样建立Collection然后insert一个json格式的数据，可以说是很方便了。具体的操作可以参考[《Spring Data MongoDB 一：入门篇（环境搭建、简单的CRUD操作）》](http://blog.csdn.net/congcong68/article/details/44545253)
- 需要注意的是，上面获取MongoTemplate对象时我们只告诉了它连接地址和选择的数据库的名字，还没有建立数据库中的Collection（MongoDB中的Collection类似于MySQL中的Table），于是每次insert一个自定义类的对象时，实际上会先在指定的数据库中创建Collection再插入数据，Collection的名字就是字母全为小写的类名（例如Book类对应的Collection就是book）。
- 写到这里，离使用MongoDB存储图片还有一大段距离。百度过用MongoDB存储图片，得出的最佳结论是使用MongoDB提供的GridFS规范，似乎Spring对此也有相应支持的GridFsTemplate类，不过今天大概也只能写到这里了。