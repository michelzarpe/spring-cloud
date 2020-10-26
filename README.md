# SpringCloudVideoCourse
![Screenshot](Architecture_0.png)
![Screenshot](Architecture_1.png)
## Visão Geral
![Screenshot](visaogeral.png)
# Sample Microservices
![Screenshot](sample_microservices_architecture.png)
## PhotoAppApiDiscoveryService
![Screenshot](eurekaDiscoveryService.png)
## PhotoAppApiUsers
![Screenshot](user_microservice.png)
## PhotoAppApiAccountManagement
![Screenshot](AccoutManagement.png)
## PhotoAppApiZuulAPIGateway
![Screenshot](ZuulApiGateway.png)
## PhotoAppApiConfigServer
![Screenshot](configServer.png)

## Exec new instance
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.application.instance_id=nameService

## Spring Cloud Bus Rabbit 
http://localhost:8888/actuator/bus-refresh

![Screenshot](springcloudbus.png)
### Comands Installation on Ubuntu
1. sudo apt-get update
2. sudo apt-get install erlang
3. sudo apt-get install rabbitmq-server
4. sudo systemctl enable rabbitmq-server
5. sudo systemctl start rabbitmq-server
6. sudo systemctl status rabbitmq-server
7. sudo rabbitmq-plugins enable rabbitmq_management
8. sudo rabbitmqctl add_user usuario senha
9. sudo rabbitmqctl set_user_tags usuario usuario_name
10. sudo rabbitmqctl set_permissions -p / usuario "." "." "."


### Conectando Mensageria de configuracoes
-> Users, AccountManagement, ConfigServer, ZuulAPI

spring.rabbitmq.host=localhost 

spring.rabbitmq.port=5672 

spring.rabbitmq.username=guest 

spring.rabbitmq.password=guest 

https://www.nexsoftsys.com/articles/implement-spring-cloud-bus-with-examples.html
https://medium.com/dev-cave/spring-cloud-config-48e423446ed8

## Spring Boot Actuator
1. /health - Health check
2. /beans - Display a complete list of beans in your Microservice
3.  diplays http trace information (by default, the last 100 http request-response exchanges)

https://medium.com/@gcbrandao/monitore-sua-api-com-spring-boot-admin-e-actuator-40e73a5e50b0

#### Vizualizando:

1. http://localhost:8011/actuator/health
2. http://localhost:8011/actuator/routes
3. http://localhost:8011/users-ws/actuator/mappings

## Hystrix Circuit Breaker & Feign
![Screenshot](Hystrix_Circuit_Breaker.png)

## Distributed tracing with sleuth and zipkin
![Screenshot](Distributed_tracing_with_sleuth_and_zipkin.png)
