FROM openjdk:8
ADD target/testset.jar testset.jar
EXPOSE 8097
ENTRYPOINT ["java", "-jar", "testset.jar"]