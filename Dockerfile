FROM openjdk:8

WORKDIR /app

COPY ./target/*.jar /app/app.jar

CMD ["java","-jar","app.jar"]