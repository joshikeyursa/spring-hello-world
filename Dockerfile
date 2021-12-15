FROM openjdk:16-alpine3.12

WORKDIR /app

EXPOSE 9090

COPY ./target/*.jar /app/app.jar

CMD ["java","-jar","app.jar"]