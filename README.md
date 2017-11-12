Bayer iRODS service project


* Server Port is set on application.yml
* Set Active profile in application.yml: spring.profiles.active
* API help: access http://localhost:4444/swagger-ui.html (using "dev" active-profile)
* To run the server: clone repository & execute: <  > 


https://github.com/spotify/dockerfile-maven

Actual plugin configured to build your image with mvn package 
and push it with mvn deploy. 

Of course you can also say mvn dockerfile:build explicitly.

 >>> mvn clean package
 
 >> después de realizar el empaquetado se construye la imagen. 
 
 Comprobamos si se han generado la imagen:
 >>> docker images
 
 Podemos observar que en nuestro registro local, están disponibles tanto la imagen base de la que hemos partido frolvlad/alpine-oraclejdk8:slim, como nuestra imagen con los tags 0.0.1-SNAPSHOT y latest. El siguiente paso es arrancar un contenedor a partir de nuestra imagen
 
 >>> docker run -d -p 8080:8080 --name microservicio iRODS-api/micro-service-spring-boot:0.0.1-SNAPSHOT
 
 Con esto arrancamos nuestro contenedor, podemos comprobarlo ejecutando
 
 >>> docker ps
 
 Una vez levantado el contenedor accedemos a nuestro servicio de manera análoga a la anterior sustituyendo ‘localhost’ por la IP de nuestro docker-machine
 
  curl http://192.168.99.100:8080/micro-service
  
  Podemos observar que la IP que devuelve es la IP interna del contenedor 172.17.0.2.

El último paso que nos quedaría para completar el ciclo seria realizar el ‘push’ de nuestra imagen a nuestro docker registry (es este ejemplo usaremos docker-hub, como hemos definido en el pom.xml con los parámetros: serverId, registryUrl), nos faltaría añadir nuestras credenciales de docker-hub en el settins.xml de maven:

    <server>
      <id>docker-hub</id>
      <username>myuser</username>
      <password>mypassword</password>
      <configuration>
        <email>user@company.com</email>
      </configuration>
    </server>
    
Listos para realizar un ‘push’ de nuestra imagen. Recordar que hemos vinculado el push a la tarea maven ‘install’

>>> mvn install


@link : https://www.adictosaltrabajo.com/tutoriales/desarrollo-de-microservicios-con-spring-boot-y-docker/

@link : https://github.com/spotify/dockerfile-maven 