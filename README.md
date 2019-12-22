# MybaitsDemo
Mybaits + Oracle 入门案例
(1) 简单的入门案例，帮助初学者学习 Mybaits 框架
(2) 能实现一般的 "增，删，改，差，数据库" 功能

# 1 Oracle 依赖 jar 包说明
(1) oracle是要收费的，不能通过远程的方式来引入，只能通过配置本地库来加载到工程里，所以得我们手动安装.
(2) 在安装 Oracle 时,也能找到 ojdbc6.jar (参考: D:\app\YoYo\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar)
(3) 注意 D:/ojdbc6.jar 表示在 D 盘，Dversion 表示 Oracle 的版本，我的是 11g 的, 
    可通过 SQL 语句查询 SELECT t.version FROM v$instance t;
	
mvn install:install-file -Dfile=D:/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar -DgeneratePom=true

再在 POM.xml 文件中添加以下依赖
<dependency>
	<groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
	<version>11.2.0.1.0</version>
</dependency>

# 2 安装步骤简述
