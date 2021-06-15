# Scheduling Optimizer API
### Backend for scheduling optimizer

*R&D funding agencies around the world, and especially in Europe, have highlighted the difficulty in achieving innovation and industrial productivity from research results. The difficulty of organizing, discovering and using the knowledge produced is felt not only by industry, but also by researchers and students, even in very focused areas of knowledge, such as multiobjective optimization.*

*With this in mind we developed a web application that enables the use of previously acquired knowledge in an easy and simple way. In our app the user can for example optimize industrial planning by putting the required data into a form and getting the results in a very visually pleasing way.*

## Architecture Flow

***SchedulingController*** is the main entrypoint of our project, it receives the POST request with all data from the UI invoking the ***AlgorithmService***.

***AlgorithmService***, this class is the core of our project, it connects all components in just one place and performs the business logic.
We start by finding the algorithm in the jMetal Framework using refletion. Then, a single iteration is ran in order to determine the process time so we can calculate the number of iterations for the user's given time in the problem request. Finally, we run the algortithm the number of iterations calculated and return the output.

***SchedulingProblemFactory***, we use Factory pattern in order to instantiate a problem depending on the type that the user selected via browser. We chose this pattern because it's easy to implement and also to expand in the future if we need to add a new type of problem without any effort. With this tactic we can abstract our implementation independently of the problem type.

***AlgorithmGenericBuilder***, is used to build a generic algorithm on jMetal through reflection. Different algorithms can have different specifications this way we can change the methods easily.

***Simulator***, one of the most important classes and module on this project. We implemented a simple version of a Discrete Event Simulator. For that we have a class Event, Event Queue and some problem specific classes (Station. Machine). Additionally we have a SimulatorEventHandler.


## Simulator Flow
![simulator flow](https://github.com/Montserrat-14/scheduling-optimizer-api/blob/main/documentation/simulator_flow.png)


##  Examples

### Three examples of scheduling problems - job shop
- Simple precedence problem
- Recirculation problem
- Station concept


## Process Flow (without simulator)
![process_flow](https://github.com/Montserrat-14/scheduling-optimizer-api/blob/main/documentation/process_flow.jpg)


## How to pull and run Docker image

### Pull and run backend Docker Image from Dockerhub
#### Pull
```batch
docker pull henriquepcabral/scheduling-optimizer-api
```
#### Run
```batch
docker run --name backend -dit -p 3080:8080 henriquepcabral/scheduling-optimizer-api:latest
```

### Pull and run both images from Dockerhub
#### Pull
```batch
docker-compose pull
```
#### Run
```batch
docker-compose up -d
```

### Pull and run backend local image
#### Pull
```batch
docker build -t scheduling-optimizer-api .
```
#### Run
```batch
docker run --name backend -dit -p 3080:8080 scheduling-optimizer-api
```

## How to access to the app after both docker images were running

[http://localhost:3000](http://localhost:3000)


## Environment variables

Docker Enviroment variables were used to facilitate possible modifications without the need to search and alter the code and build again.

| Name |  Description  |
| ------------------- | ------------------- |
|  INTEGER_DEFAULT_PARAM |  default parameter to integer |
|  DOUBLE_DEFAULT_PARAM |  default parameter to double |
|  FLOAT_DEFAULT_PARAM |  default parameter to float |



## Used Frameworks
- Spring Boot
- JMetal
- Relfections

## Authors
- [Diogo Fernandes](https://github.com/diogormsf)
- [Francisco Cordeiro](https://github.com/c0rdeiro)
- [Henrique Cabral](https://github.com/henriquecabral)
- [Sebastian Cheregi](https://github.com/Seeebas)
