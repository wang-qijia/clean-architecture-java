#!/bin/bash

# Define the directory of the project (adjust if necessary)
PROJECT_DIR=$(pwd)

# Define the target JAR file and Maven goals
JAR_FILE="$PROJECT_DIR/main/target/clean-architecture-java-1.0.0.jar"

mvn clean install  &&  java -jar "$JAR_FILE"

