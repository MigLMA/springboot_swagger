# Requirements
#### ==========================================================================================
## Software
* Java 1.8+
* Maven 3.5.2+

## Required ENV vars
* JAVA_HOME - location of a JDK home dir

## Optional ENV vars
* M2_HOME - location of maven2's installed home dir

#### ==========================================================================================


# Bayer iRODS service project

* Set Server Port on application.yml
* Set Active profile in application.yml: spring.profiles.active
* To run the server: clone repository & execute: **mvn spring-boot:run**
* API help: access <http://localhost:4444/swagger-ui.html> (using "dev" active-profile) 


#### ==========================================================================================


# SonnarQube & coverage

* Start SonarQube server: **docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube**
* Make the report: **mvn sonar:sonar**
* Access the report at <http://localhost:9000/projects?sort=-analysis_date>


#### ==========================================================================================