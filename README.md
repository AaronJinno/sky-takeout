## 苍穹外卖项目
### 简介
该项目来自于黑马程序员的 [苍穹外卖](https://www.bilibili.com/video/BV1TP411v7v6)

该项目是瑞吉外卖的进阶版。

### 项目目标
该项目用来练习：基于 **Spring Boot** 的标准项目开发。

开发过程中会用到MVC前后的分离结构，和众多常用开发技术。

### 目录结构
- `/sky-takeout/`：后端-Java服务端
- `/sky-takeout-admin/`：前端-admin管理端
- `/sky-takeout-client/`：前端-小程序客户端
- `/db/`：数据库内容
- `/files/`：一些其他可能有用的文件文件
- `README.md`：项目介绍

### 技术选型
#### 用户层：前端
包括：管理后台和微信小程序客户端。

涉及：H5、Vue.js、ElementUI、apache echarts(展示图表)、微信开发等技术

#### 网关层
Nginx是一个服务器，主要用来作为Http服务器，部署静态资源，访问性能高。

在Nginx中还有两个比较重要的作用：反向代理和负载均衡，在进行项目部署时，要实现Tomcat的负载均衡，就可以通过Nginx来实现。

#### 应用层
- SpringBoot： 快速构建Spring项目, 采用 "约定优于配置" 的思想, 简化Spring项目的配置开发。
- SpringMVC：SpringMVC是spring框架的一个模块，springmvc和spring无需通过中间整合层进行整合，可以无缝集成。
- Spring Task:  由Spring提供的定时任务框架。
- httpclient:  主要实现了对http请求的发送。
- Spring Cache:  由Spring提供的数据缓存框架
- JWT:  用于对应用程序上的用户进行身份验证的标记。
- 阿里云OSS:  对象存储服务，在项目中主要存储文件，如图片等。
- Swagger： 可以自动的帮助开发人员生成接口文档，并对接口进行测试。
- POI:  封装了对Excel表格的常用操作。
- WebSocket: 一种通信网络协议，使客户端和服务器之间的数据交换更加简单，用于项目的来单、催单功能实现。


#### 数据层
- MySQL： 关系型数据库, 本项目的核心业务数据都会采用MySQL进行存储。
- Redis： 基于key-value格式存储的内存数据库, 访问速度快, 经常使用它做缓存。
- Mybatis： 本项目持久层将会使用Mybatis开发。
- pagehelper:  分页插件。
- spring data redis:  简化java代码操作Redis的API。


#### 工具
- git: 版本控制工具, 在团队协作中, 使用该工具对项目中的代码进行管理。
- maven: 项目构建工具。
- junit：单元测试工具，开发人员功能实现完毕后，需要通过junit对功能进行单元测试。
- postman:  接口测试工具，模拟用户发起的各类HTTP请求，获取对应的响应结果。
