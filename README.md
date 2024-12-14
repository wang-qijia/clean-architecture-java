# Clean Architecture - Java

[简体中文](README.zh-CN.md) | [English](README.md)

This project is a simple demonstration of how to implement **Clean Architecture** in a Java application. It follows the principles proposed by Robert C. Martin (Uncle Bob) in his book *"Clean Architecture: A Craftsman's Guide to Software Structure and Design"*. The goal is to separate business logic from technical details, making the code more flexible, testable, and maintainable.


## Project Introduction

This project demonstrates how to use Java to implement **Clean Architecture**. By implementing a simple use case (e.g., user management), it shows how to separate core business logic from external technical details, ensuring that the application remains flexible and maintainable while delivering business functionality.

The project adheres to the four primary layers of **Clean Architecture**:

- **Entities**: Core business logic that represents the domain model.
- **Use Cases**: Application-specific business rules that coordinate operations.
- **Interface Adapters**: Adapts data formats between external systems and the internal domain model.
- **Frameworks and Drivers**: Implementation details of external frameworks, databases, and third-party services.

### Dependency Rules

- The core layers (Entities and Use Cases) should not depend on external layers (Interface Adapters and Frameworks).
- All dependencies should flow inward, ensuring that technical details do not affect core business logic.

## Architecture Design

The project adopts a layered approach and includes the following components:

1. **Entities (Core Domain)**  
   Represents the application's core business logic and domain models.

2. **Use Cases (Application Layer)**  
   Contains application-specific business rules, coordinates operations, and manages workflows.

3. **Interface Adapters (Adapter Layer)**  
   Converts data between external systems and internal business logic. Includes web controllers, API services, and database interfaces.

4. **Frameworks and Drivers (Infrastructure Layer)**  
   Contains implementation details for external systems like databases, UI frameworks, and third-party services.

### Dependency Rules

- The core layers (Entities and Use Cases) must never depend on external layers (Adapters and Frameworks).
- Dependencies should always flow inward: from external systems toward core business logic.

## Features

- **Separation of Concerns**: Decouples business logic from external technologies (e.g., frameworks, databases), enhancing flexibility and scalability.
- **Testability**: Core business logic is isolated, enabling easier unit and integration testing.
- **Maintainability**: Clear separation of layers makes it easier to extend and modify functionality without affecting core logic.
- **Scalability**: Adding new features or modifying existing ones has minimal impact on other parts of the system.

## Getting Started

### Prerequisites

Before starting, make sure you have the following tools installed:

- **JDK 11 or higher** (or another compatible Java version)
- **Maven**: For building and managing project dependencies

### Installation Steps

1. Clone this repository to your local machine:

    ```bash
    git clone https://github.com/wang-qijia/clean-architecture-java.git
    ```

2. Navigate to the project directory:

    ```bash
    cd clean-architecture-java
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

### Running the Application

You can run the application using the following Maven command:

   ```bash
   ./start.sh
   ```


## Running Tests
   ```bash
   mvn test
   ```

## Contributing
We welcome contributions! To contribute to this project:

1. Fork the repository.
2. Create a new feature branch (git checkout -b feature/your-feature).
3. Commit your changes (git commit -am 'Add new feature').
4. Push to the branch (git push origin feature/your-feature).
5. Submit a Pull Request.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.