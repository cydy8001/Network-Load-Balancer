# Network Load Balancer
Demo link: https://youtu.be/mysKYVQbRAI


For this project, I made a network load balancer using different network loading algorithm. The supported network
loading algorithm are: Retry Rule, Round Robin Rule, Random Rule, Weighted Response Time Rule, and Best Available Rule.

The repository contains the three modules. They are consumer module, provider module, and server module. Server module
is used to start the Eureka server using Spring Boot. The consumer module contains the various mapping that contains the 
different network loading algorithm and different routing url logic. The provider module contains the service that is 
used by the consumer module. 

When we send the http request to GET information from the server, the server will handle
the destination and which service will handle the request. The logic is completely determined by the network loading 
balancer algorithm.

# How to run the project

## Download the project

1. `git clone https://github.com/cydy8001/Network-Load-Balancer.git`
2. `cd spring-cloud-parent`

## Basic setup
Java version is JDK1.8 and
Maven version is 3.6.3
Make sure the 3 modules are using the same JDK 1.8.
Otherwise, there will be conflict.

## Run Maven
Maven contains many dependencies. So, it is important to download all dependencies required. 
If you are using Intellij, you can right click the 4 pom.xml files and load the dependencies.
In your Run Edit configuration: Allow multiple instances in Provider.

## Config
You can modify the application.yml file under the resources folder.
```agsl
server:
  port: 8000

eureka:
  instance:
    hostname: localhost
    prefer-ip-address: true
    ip-address: 127.0.0.1
    instance-id: ${eureka.instance.ip-address}:${spring.application.name}:${server.port}
    lease-renewal-interval-in-seconds: 3
    lease-expiration-duration-in-seconds: 9
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
spring:
  application:
    name: eureka-provider

```
All of the consumer ,provider and server have the application.yml file. So, you can modify all of them but I suggest 
keeping them default.



### Test
1. Round Robin Rule
    - GET: localhost:9000/oder/goods2/1
    - title: Iphone13pro: 8002
    - title: Iphone13pro: 8001
    - title: Iphone13pro: 8000
    - The port numbers are 8002, 8001, and 8000 will follow the Round Robin Rule
2. Random Rule
    - GET: localhost:9000/oder/goods2/1
    - title: Iphone13pro: 8002
    - title: Iphone13pro: 8002
    - title: Iphone13pro: 8000
    - The port numbers will be completely random


