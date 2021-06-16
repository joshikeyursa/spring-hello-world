docker login
docker run -w "/app" -v "${PWD}:/app" maven:3.8.1-jdk-8 mvn clean test verify
docker build -t joshikeyur/spring-hello-world .
docker push joshikeyur/spring-hello-world