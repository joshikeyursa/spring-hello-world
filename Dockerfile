FROM openjdk:16-alpine3.12

WORKDIR /app

COPY ./target/*.jar /app/app.jar

CMD ["java","-jar","app.jar"]