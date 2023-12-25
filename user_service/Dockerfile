FROM openjdk
ADD target/user_service.jar user_service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/user_service.jar"]