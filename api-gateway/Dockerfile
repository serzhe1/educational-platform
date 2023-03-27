FROM maven:latest AS build
COPY src /home/app/src
ADD pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests

FROM openjdk:17-jdk-alpine
CMD mkdir /usr/local/lib/app
WORKDIR /usr/local/lib/app
COPY --from=build /home/app/target/api-gateway-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/app/app.jar"]