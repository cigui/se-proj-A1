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
- 对框架的使用方面我还没有弄清楚，下次再更新吧。