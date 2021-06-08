FROM openjdk:16
ADD target/abaccAdelaide.jar app.jar
EXPOSE 4040
ENTRYPOINT ["java","-jar","app.jar"]
