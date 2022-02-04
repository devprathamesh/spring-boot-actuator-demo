FROM openjdk:8-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/spring-boot-actuator.jar spring-boot-actuator.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-actuator.jar"]