# MybaitsDemo
IDEA + Maven + Mybaits + Oracle 入门案例

 -  简单的入门案例，帮助初学者快速熟悉 Mybaits 框架
 -  能实现一般的 `"增，删，改，查，数据过程" `

# 安装简述
 1. 用 IDEA 工具，创建 Maven 项目
 2. 设置主配置文件 mybaits-config.xml（项目启动时，第一个要读取的文件）
  	- 主配置文件中 引入的其他配置文件，如：`db.properties`
 3. 创建实体类(数据库中的表，如 Person)，及实体类对应的配置文件 `PersonMapper.xml`（java 操作实体类就相当于操作 数据库） 
 4. 测试

# 特别说明
## 1.1 ojdbc6.jar 依赖包
 - oracle是要收费的，不能通过远程的方式来引入，只能通过配置本地库来加载到工程里，所以得我们手动安装。
 - 在安装 Oracle 时,也能找到 ojdbc6.jar (参考: `D:\app\YoYo\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar`)
 - 注意 D:/ojdbc6.jar 表示在 D 盘，Dversion 表示 Oracle 的版本，我的是 11g 的, 
    可通过 SQL 语句查询下列
 ```sql
 SELECT t.version FROM v$instance t;
 ```

```sql	
mvn install:install-file -Dfile=D:/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar -DgeneratePom=true
```

 - 再在 POM.xml 文件中添加以下依赖
 ```xml
<dependency>
	<groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
	<version>11.2.0.1.0</version>
</dependency>
```

## 1.2 要做的修改
> 项目下载下来后，需做如下改动，才能 `跑起来`
 - 修改 `db.properties` 配置文件为你自己的 `数据库连接信息`
 - 在数据库中创建 `表 person 和 Demo 中用到的存储过程`
