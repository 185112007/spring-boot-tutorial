## Dockerize Spring Boot Application

Package it with Maven.
```shell
$ cd project
$ mvn clean package
```

Run the Spring Boot.
```shell
$ cd project
$ java -jar target/spring-boot-web.jar
```

sudo docker build -t name:tag .
```shell
$ cd project
$ sudo docker build -t spring-boot:1.0 .
```

Start the docker container spring-boot:1.0
```shell
$ sudo docker run -d -p 8080:8080 -t spring-boot:1.0
$ sudo docker run -d -p 80:8080 -t spring-boot:1.0
$ sudo docker run -d -p 443:8443 -t spring-boot:1.0
$ sudo docker run -d -p 80:8080 -p 443:8443 -t spring-boot:1.0
```
