# 整洁架构 - Java

[English](README.md) | [简体中文](README.zh-CN.md)

本项目是一个展示如何在 Java 应用中实现 **整洁架构** 的简单示例。它遵循 Robert C. Martin（Uncle Bob）在《**整洁架构：软件结构与设计的工匠之路**》一书中提出的原则，旨在展示如何将业务逻辑与技术细节分离，从而使代码更具灵活性、可测试性和可维护性。



## 项目介绍

本项目旨在展示如何使用 Java 实现 **整洁架构**。我们通过实现一个简单的业务用例（例如：用户管理），展示了如何将核心业务逻辑与外部技术细节分离，确保应用在实现业务功能的同时保持灵活性和可维护性。

该项目遵循了 **整洁架构** 的四个主要层次：

- **实体（Entities）**：核心业务逻辑，代表应用的核心领域模型。
- **用例（Use Cases）**：应用特定的业务规则，协调不同的操作流程。
- **接口适配器（Interface Adapters）**：将外部系统的数据格式转换为内部领域模型。
- **框架和驱动程序（Frameworks and Drivers）**：涉及外部框架、数据库和第三方服务的实现细节。

### 依赖规则

- 核心层（实体和用例）不应依赖外部层（接口适配器和框架）。
- 所有的依赖都应该从外部向内流动，确保技术细节不影响核心业务逻辑。

## 架构设计

项目的架构采用分层方式，主要包括以下几个组件：

1. **实体（核心领域）**  
   业务逻辑的核心模型，表示应用的业务实体。

2. **用例（应用层）**  
   应用特定的业务规则，负责协调应用中的业务操作，调用实体对象并管理其流程。

3. **接口适配器（适配器层）**  
   将外部系统与应用内部的业务逻辑进行适配和转换。包括 Web 控制器、API 服务、数据库接口等。

4. **框架与驱动程序（基础设施层）**  
   实现外部系统（如数据库、UI 框架、第三方服务等）的具体细节。

### 依赖规则

- 核心层（实体和用例）永远不应依赖外部层（适配器和框架）。
- 依赖关系应该始终向内流动：从外部系统流向核心业务逻辑。

## 功能特点

- **关注点分离**：将业务逻辑与外部技术栈（框架、数据库等）解耦，提高系统的灵活性和可扩展性。
- **可测试性**：核心业务逻辑被独立出来，可以更容易地进行单元测试和集成测试。
- **可维护性**：层次清晰，便于扩展和修改，不会影响核心业务逻辑。
- **可扩展性**：增加新功能或修改现有功能时，对其他系统部分的影响最小。

## 快速开始

### 前提条件

在开始之前，请确保你已经安装了以下工具：

- **JDK 11 或更高版本**（或其他兼容的 Java 版本）
- **Maven**：用于构建和管理项目依赖

### 安装步骤

1. 克隆本仓库到本地：

    ```bash
    git clone https://github.com/wang-qijia/clean-architecture-java.git
    ```

2. 进入项目目录：

    ```bash
    cd clean-architecture-java
    ```

3. 使用 Maven 构建项目：

    ```bash
    mvn clean install
    ```

### 运行应用

你可以使用以下命令来运行应用：

```bash
chmod +x start.sh 

./start.sh
```

```java

```



##  目录结构
```java
    {{业务领域}}-Service
    ├── pom.xml (父模块 POM，管理公共依赖和子模块)
    ├── main (启动模块，包含应用启动类)
    │   ├── src
    │   │   ├── main
    │   │   │   ├── java
    │   │   │   │   ├── configaction
    │   │   │   │   ├── Main.java
    ├── core (核心业务逻辑模块)
    │   ├── src
    │   │   ├── main
    │   │   │   ├── java
    │   │   │   │   ├── entity
    │   │   │   │   │   ├── Customer.java
    │   │   │   │   │   ├── CustomerFactory.java
    │   │   │   │   ├── usecase
    │   │   │   │   │   ├── model
    │   │   │   │   │   │   ├── CreateCustomerInput.java
    │   │   │   │   │   │   ├── CreateCustomerOutput.java
    │   │   │   │   │   ├── exception
    │   │   │   │   │   ├── repository
    │   │   │   │   │   │   ├── CustomerRepository.java
    │   │   │   │   │   ├── CreateCustomerUseCase.java
    ├── infrastructure (基础设施模块)
    │   ├── src
    │   │   ├── main
    │   │   │   ├── java
    │   │   │   │   ├── store
    │   │   │   │   │   ├── mysql
    │   │   │   │   │   │   ├── MysqlCustomerRepository.java
    │   │   │   │   ├── client
    │   │   │   │   │   ├── CustomerClient.java
    │   │   │   │   ├── http
    │   │   │   │   │   ├── CustomerRestResource.java
    │   │   │   │   │   ├── model
    │   │   │   │   │   │   ├── CreateCustomerReq.java
    │   │   │   │   │   │   ├── CreateCustomerResp.java
    │   │   │   │   │   ├── exception
    │   │   │   │   │   ├── mapper
    │   │   │   │   ├── dubbo
    │   │   │   │   │   ├── CustomerRpcResource.java

```

## 测试
```bash
mvn test
```

## 贡献指南
欢迎贡献！如果你想改善本项目或增加新功能，请遵循以下步骤：
1. Fork 本仓库
2. 创建新特性分支（git checkout -b feature/你的特性）
3. 提交修改（git commit -am '增加新特性'）
4. 推送到远程分支（git push origin feature/你的特性）
5. 提交 Pull Request

## 许可协议
本项目采用 MIT 许可协议 - 请参阅 LICENSE 文件了解更多内容。






