#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY ADS.owl /home/app

RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim

ENV INTEGER_DEFAULT_PARAM="30"
ENV DOUBLE_DEFAULT_PARAM="30.00"
ENV FLOAT_DEFAULT_PARAM="30.00"
ENV MUTATION_RATE="0.8"
ENV CROSSOVER_RATE="0.9"

COPY --from=build /home/app/target/schedulingoptimizer-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
