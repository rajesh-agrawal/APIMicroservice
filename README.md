# IntegrationTesting

# To Run all Tests
mvn clean install


# To Run Unit Tests Only
# To Run Unit Tests Only
mvn test -Dtest=*,!*integration*/**/* test


# To Run Integration Tests Only
mvn test -Dtest=*integration*/**/* test


# To Deploy app using Jenking
Use Pipeline jobs -> provide CreateDeployment.groovy in dsl scripts from the git repo

# To See JaCoCo Reports. Once you run the command it gets generated at  target\site\jacoco\index.html
mvn clean verify


# Jenkin job has been deployed to following jenkin server
https://ci-itmtraining.sharedservices-prod-vpn.us.i29.c01.johndeerecloud.com/job/IntegrationTesting_vuucfp6/
