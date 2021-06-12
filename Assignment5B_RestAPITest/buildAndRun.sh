#!/bin/sh
mvn clean package && docker build -t com.43141/RestAPITest .
docker rm -f RestAPITest || true && docker run -d -p 9080:9080 -p 9443:9443 --name RestAPITest com.43141/RestAPITest