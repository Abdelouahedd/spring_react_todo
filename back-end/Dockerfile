FROM maven:3-openjdk-8 as build
WORKDIR /app
COPY . /app
RUN mvn package 

FROM openjdk:8
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
