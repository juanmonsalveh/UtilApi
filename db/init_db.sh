#!/bin/bash

# Sopping and deleting container if it is running
docker stop c-bank-db
docker rm c-bank-db

# Deleting  image
docker rmi bank-db

# Building image
docker build -t bank-db .

# Running container
docker run --name c-bank-db -p 3333:3306 -d bank-db