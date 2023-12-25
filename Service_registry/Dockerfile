FROM openjdk
ADD target/service-registry.jar service-registry.jar
EXPOSE 8082
ENTRYPOINT [ "java", "-jar", "/service-registry.jar" ]