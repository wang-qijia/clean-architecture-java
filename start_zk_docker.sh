#!/bin/bash

# Define Zookeeper version
ZK_VERSION="3.8.0"

# Define Docker container name
CONTAINER_NAME="zookeeper-container"

# Define Zookeeper data and log directories on the host
ZK_DATA_DIR="$PWD/other/zookeeper_data"
ZK_LOG_DIR="$PWD/other/zookeeper_logs"

# Create directories if they don't exist
mkdir -p $ZK_DATA_DIR
mkdir -p $ZK_LOG_DIR

# Pull the Zookeeper Docker image (if not already available)
echo "Pulling Zookeeper Docker image (version $ZK_VERSION)..."
docker pull wurstmeister/zookeeper:$ZK_VERSION

# Run Zookeeper in Docker
echo "Starting Zookeeper container..."
docker run -d \
  --name $CONTAINER_NAME \
  -p 2181:2181 \
  -v $ZK_DATA_DIR:/data \
  -v $ZK_LOG_DIR:/datalog \
  wurstmeister/zookeeper:$ZK_VERSION

# Check if Zookeeper container is running
docker ps -f name=$CONTAINER_NAME
