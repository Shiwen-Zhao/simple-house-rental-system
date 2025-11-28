# Simple House Rental System

## 项目简介
Simple House Rental System 是一个基于 Java 控制台的房屋出租管理示例程序。项目以最简依赖的方式演示了如何使用分层架构（`domain` / `service` / `view`）来完成房源信息的增删改查，在课堂示例、Java 初学者练手或 Maven 打包演示中都十分适用。

## 功能特性
- 房屋列表：查看当前所有房源的编号、房主、联系方式、地址、租金与出租状态。
- 新增房屋：通过交互式输入添加新的房源信息（姓名、电话、地址、月租、状态）。
- 查找房屋：按编号定位房源并展示详情。
- 修改房屋：基于编号批量修改房屋的所有字段。
- 删除房屋：按编号删除房源，并带有二次确认提示。
- 退出系统：支持安全退出，防止误触。

## 代码结构
```
src/main/java/org
├── HouseApp.java         // 程序入口，启动主菜单
├── domain/House.java     // 实体层，描述单个房屋对象
├── service/HouseService  // 业务层，负责房源数组的 CRUD 操作
└── view/HouseView.java   // 界面层，处理交互并调用业务逻辑
```

## 运行环境
- Java 8+
- Maven 3.6+
- 支持的操作系统：Windows / macOS / Linux（只要具备 JDK 与 Maven 环境即可）

## 快速开始
```bash
# 1. 编译与打包
mvn clean package

# 2. 运行（默认生成 SNAPSHOT 版本）
java -jar target/simple-house-rental-system-1.0-SNAPSHOT.jar
```

首次启动后即可看到中文主菜单，按照提示输入数字完成各项功能操作。若在 IDE 中运行，可直接执行 `org.HouseApp` 的 `main` 方法。

## 注意事项
- 当前示例使用内存数组保存房屋信息，程序退出后数据不会持久化。
- 默认容量为 5，可在 `HouseService` 的构造函数中调整。
- 输入流程大量依赖命令行交互，建议使用支持中文的终端以避免乱码。

## 后续拓展方向
- 接入持久化（JDBC / MyBatis / JPA）以保存房源数据。
- 增加租户信息、订单、到期提醒等业务模块。
- 封装更友好的命令行 UI 或迁移到 Web / 桌面界面。

