Tech stack:

Java 17, Spring Boot 3.1.1, Flyway, Lombok, TestContainers


[Swagger UI](http://localhost:8080/swagger-ui/index.html)


In this application brand new spring boot module is used: [spring-docker-compose](https://docs.spring.io/spring-boot/docs/3.1.0-SNAPSHOT/reference/html/features.html#features.docker-compose).
Handful feature to have for local development. It allows to start up seamlessly with database declared in docker-compose file, 
depending on properties db can be started adn stopped with application or continue be up and running. 

