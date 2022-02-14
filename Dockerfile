FROM node:lts-alpine AS client-base
RUN npm install -g http-server
COPY /client .
RUN npm install
RUN npm run build

FROM openjdk:17-alpine AS server-base
COPY /server .
COPY --from=client-base /dist /src/main/resources/static
RUN ./mvnw package

FROM openjdk:17-alpine AS app
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY --from=server-base ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]