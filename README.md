========================================================================================


Bayer iRODS service project


* Server Port is set on application.yml
* Set Active profile in application.yml: spring.profiles.active
* API help: access http://localhost:4444/swagger-ui.html (using "dev" active-profile)
* To run the server: clone repository & execute: 
```mvn spring-boot:run```


========================================================================================


# To build the Docker image, run the following command:


$ docker build -t irods/midtier:latest .


# Running the ```docker history irods/midtier:latest``` command on created Docker image will let you see all layers that make up this image:

$ docker history irods/midtier:latest
IMAGE               CREATED             CREATED BY                                      SIZE                COMMENT
a9338ae3f3ed        2 minutes ago       /bin/sh -c #(nop)  CMD ["/usr/bin/java" "-...   0B                  
8a78e40d58ad        2 minutes ago       /bin/sh -c #(nop) COPY file:030955a33ab51f...   22.2MB              
b36ec9de53a8        2 weeks ago         /bin/sh -c set -x  && apk add --no-cache  ...   77.5MB              
<missing>           2 weeks ago         /bin/sh -c #(nop)  ENV JAVA_ALPINE_VERSION...   0B                  
<missing>           2 weeks ago         /bin/sh -c #(nop)  ENV JAVA_VERSION=8u131       0B                  
<missing>           2 weeks ago         /bin/sh -c #(nop)  ENV PATH=/usr/local/sbi...   0B                  
<missing>           2 weeks ago         /bin/sh -c #(nop)  ENV JAVA_HOME=/usr/lib/...   0B                  
<missing>           2 weeks ago         /bin/sh -c {   echo '#!/bin/sh';   echo 's...   87B                 
<missing>           2 weeks ago         /bin/sh -c #(nop)  ENV LANG=C.UTF-8             0B                  
<missing>           2 weeks ago         /bin/sh -c #(nop)  CMD ["/bin/sh"]              0B                  
<missing>           2 weeks ago         /bin/sh -c #(nop) ADD file:1e87ff33d1b6765...   3.97MB   


3.97MB Alpine Linux Layer
77.5MB OpenJDK JRE Layer
22.2MB Application JAR file


========================================================================================


# Running the Java Application Docker container

In order to run the demo application, run following command:

```docker run -d --name demo-irods -p 4444:8090 -p 8091:8091 irods/midtier:latest```

========================================================================================


Then, to test the application is deployed: just use curl or http (from httpie) to get to /ip endpoint:

```$ curl http://localhost:8090/iRODS-api/ip
Running from IP address: 172.17.0.3
```
```$ http http://localhost:8090/iRODS-api/ip
HTTP/1.1 200 
Content-Length: 36
Content-Type: text/plain;charset=UTF-8
Date: Tue, 21 Nov 2017 22:29:25 GMT
X-Application-Context: metadatatool-service:test:4444

Running from IP address: 172.17.0.3

```
# Resident Set Size (RSS): RSS = Heap size + MetaSpace + OffHeap size

========================================================================================


