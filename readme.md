# ReadMe

>安装intellij idea，用校园邮箱注册可以有一年免费试用。

### 1. 运行的步骤：

- 找到pom.xml文件右键maven下的reimport

- 建立好mysql数据库

- 然后再将根目录中的all.sql（通过mysqldump生成的）文件，如果是mysql shell在根目录登录进去source all.sql 就可以了，如果是其他的数据库软件请参照其他数据库软件的提示进行导入数据文件进行恢复

- 在applicantion.properties中填好数据库的账号密码，

- demoapplication文件右键运行或右上角运行。

- 有问题查看java编译环境是否设置好，或pom.xml是否import完成（其他问题自行百度）

### 2. 文件构成：

- config文件夹是一些组件的配置文件，相当于spring中的applicationcontext.xml文件。

- DAO文件夹中是数据库相关的操作，动作类，如select * from data等。

- entity文件夹中是数据库的相应的表实体类，user表，apply表，country表等等。

- enums文件夹中用来存储枚举类型，男女，在线下线离线等。

- service 文件夹中存储的是服务类，供controller类来调用的接口，里边的impl文件夹用来存储相应接口的实现类。

- web存储的就是controller类，路由的类。

### 3. 主要的操作步骤：

1. 在entity文件夹中创建相应的数据库 表的实体类，如 user。

2. 在controller中创建相应的路由函数，如实现用户搜索功能，需要调用service中的接口类。

3. 在service文件夹中创建搜索功能的接口类。

4. 在Dao文件中创建与此类相关的Dao数据库操作类，如 userDao，需要调用数据库的实体类user。

5. 在service的impl文件夹中创建创建接口的实现类（一个接口可以有多个实现类）需要调用Dao数据库操作类。

### 4. 注意事项

1. 一些详细备注了的文件以供参考: admincontroller, userServiceImpl,UserInfo，userDao

2. 已经添加了shiro的验证模块。除了/admin/**，即adminController下是开放的，其他都是要验证的。账号admin密码123456

3.需要自建mysql数据库，账号密码填写，在/resource/application.properties里填写。需要提前写入的测试数据，mysql语句在/resource/database/import.sql文件里填写。



