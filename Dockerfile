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
ENV OWL_PATH="./ADS.owl"
ENV OWL_QUERY="Algorithm(?alg) ^ dealsWithHeavyProcessingEvaluationFunctions(?alg,true) ^ minObjectivesAlgorithmIsAbleToDealWith(?alg,?min) ^ swrlb:lessThanOrEqual(?min,%%NOBJECTIVES%%) ^ maxObjectivesAlgorithmIsAbleToDealWith(?alg,?max) ^ swrlb:greaterThanOrEqual(?max, %%NOBJECTIVES%%) -> sqwrl:select(?alg)"
ENV MAX_TRIES=3
ENV RESULTSPATH="resources"
ENV RESULTSEXTENSION=".csv"
ENV INTEGER_DEFAULT_PARAM="30"
ENV DOUBLE_DEFAULT_PARAM="30.00"
ENV FLOAT_DEFAULT_PARAM="30.00"
ENV MUTATION_RATE="0.8"
ENV CROSSOVER_RATE="1.0"
COPY --from=build /home/app/ADS.owl ADS.owl
COPY --from=build /home/app/target/systemoptimizer-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
RUN mkdir -p $RESULTSPATH

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
