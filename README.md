# API MICROSERVICE TEST STRATEGY
## SPRING BOOT MICROSERVICE WITH MYSQL BACKEND

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

API Microservice is a microservice for adding customer entity and displaying customer information.
Purpose of repository is to demonstrate use of right test cases for right purpose instead of using it from compliance perspective. 
- ✨ Showcase use of unit test cases for validation and corner case checking
- ✨ Use of integration testing and integration with Jenkins
- ✨ Jenkin Job to run all  commands for testing unit and integreation testing 
- ✨ Run  Java code coverage to know test converage 


## Installation

Code requires java 1.8,maven  and Mysql installation to run

## Clean and build the entire code

```
mvn clean install
```

## To run all unit tests
```
mvn test -Dtest=*,!*integration*/**/* test
```

## To run all integration tests
```
mvn test -Dtest=*,*integration*/**/* test
```
## To Deploy app using Jenkin
Import job on jenkins using Pipeline jobs -> provide [CreateDeployment.groovy](CreateDeployment.groovy)  in dsl scripts from the git repo

## To See JaCoCo Reports. 
```
mvn clean verify
```
Once you run the command it gets generated at  target\site\jacoco\index.html

## Contribute Development ?

If you want to contribute to this project and make it better, your help is very welcome. Contributing is also a great way to learn ,Please send a good, clean pull request.
