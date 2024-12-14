#!/bin/bash

# Define the directory of the project (adjust if necessary)
PROJECT_DIR=$(pwd)
echo "Work dir: $PROJECT_DIR"

# Define the target JAR file and Maven goals
JAR_FILE="$PROJECT_DIR/main/target/clean-architecture-java-example-1.0-SNAPSHOT.jar"

# Check the operating system and execute commands accordingly
OS_NAME=$(uname -s)
echo "Using JAR file: $JAR_FILE"
echo  "OS: $OS_NAME"

./mvnw clean install && java -jar "$JAR_FILE"


