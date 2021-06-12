@echo off
call mvn clean package
call docker build -t com.43141/RestAPITest .
call docker rm -f RestAPITest
call docker run -d -p 9080:9080 -p 9443:9443 --name RestAPITest com.43141/RestAPITest