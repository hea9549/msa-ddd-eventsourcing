#!/bin/bash

# Setup mongodb, rabbitmq
docker-compose up -d

# build & run application
./gradle build && java -jar build/libs/sample-msa-0.0.1.jar
