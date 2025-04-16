FROM maven:3.8.5-openjdk-11 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY --from=build /app/target/vacationcalculator-0.0.1-SNAPSHOT.jar vacationcalculator.jar

ENTRYPOINT ["java", "-jar", "vacationcalculator.jar"]

EXPOSE 8080
