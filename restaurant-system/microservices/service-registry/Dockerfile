FROM openjdk:17
ADD /target/service-registry-1.0.0.jar service-registry-1.0.0.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "service-registry-1.0.0.jar"]