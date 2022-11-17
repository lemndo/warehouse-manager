# warehouse-manager


#### 介绍
本项目是为衡阳运转车间定制的仓库管理系统，提供了货物的快速出入库，以及记录货物的数量和摆放位置、出库记录等功能。

- 快速上手可看
- 详细使用可看
- 请勿忽略更新日志, 会有详细的版本更新说明！
- 劳保用品：鞋子，衣服
- 车务段劳保用品、工会采购、车间采购


品名、数量、入库时间、出库时间、借出人、经手人、是否归还


货物存放位置（编号）

类型



#### 功能完善记录

货物列表

excel表格导出

货物上架

出库货物：支持按照货物名或者货物类型搜索然后出库货物

出库记录

#### 软件截图

- 在线API接口文档

- 登录
![登录](https://images.gitee.com/uploads/images/2020/0728/220039_eac21a26_1865362.png "login.png")
  

- 启动Banner

![启动Banner](https://images.gitee.com/uploads/images/2020/0807/113718_a4ea899d_1865362.png "banner.png")


#### 软件架构
软件架构说明:

##### 后端：
- 基础框架： SpringBoot
- 简单数据操作： Spring Data Jpa
- 复杂数据操作： Mybatis
- 安全框架： SpringSecurity
- 模板引擎： Thymeleaf
- API文档&测试： Swagger2
- API文档加强&美化： Swagger-Bootstrap-UI, 这个很好看, 而且功能强大,支持生成离线MD文档,但是版本兼容性会有问题, 我试了很多版本, 最终1.9.3可以正常使用
- hutool工具箱： Java各种工具封装, 爽的雅痞

##### 前端：
- javaEx, 其实就是对html,css,js的封装, 很简单, 10分钟就能上手。比较接近原生
修改起来比较方便, 所以就用了。想了解的, 百度JavaEx即可。

- jQuery , 讲真的jQuery用着还是很舒服, 突破各种前端框架的限制

- 这里真的要吹一波jQuery插件库,强大,耦合性低,加入即用, 非常适合本项目

#### 安装教程

建议看wiki
1.  本地搭建好java8环境,数据库MySQL5.5+, 克隆项目
2.  导入sql文件至数据库中
3.  配置maven, 等待依赖下载完成
4.  IDE安装好lombok插件
5.  启动访问http://localhost:8080 即可
6.  账号：【学生： stu/123】【教师： tea/123】【其他：other/123】【管理员：admin/123】
7.  swagger API在线文档, 启动访问：http://localhost:8080/doc.html
#### 使用说明

#### 作者介绍
木之本(lemndo),个人开发者

#### GitHub地址

#### 更新日志


#### 后续

