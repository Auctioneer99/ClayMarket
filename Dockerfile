FROM openjdk:17-alpine
EXPOSE 8080
ARG JAR_FILE=server/target/*.jar
WORKDIR /app/
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]