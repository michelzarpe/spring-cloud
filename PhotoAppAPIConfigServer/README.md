## PhotoAppApiConfigServer
### application.properties
server.port=8888
spring.application.name=PhotoAppAPIConfigServer
spring.cloud.config.server.git.uri=https://github.com/michelzarpe/PhotoAppAPIConfigServer
spring.cloud.config.server.git.username=
spring.cloud.config.server.git.password=
spring.cloud.config.server.git.clone-on-start=true

## PhotoAppApiUsers
### application.properties
server.port=${PORT:0}
spring.application.name=users-ws
eureka.client.serviceUrl.defaultZone = http://localhost:8010/eureka
spring.devtools.restart.enabled=true
eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
spring.datasource.url=jdbc:postgresql://localhost:5432/photoUser
spring.datasource.username=postgres
spring.datasource.password=senior
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.type=trace
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false
gateway.ip=127.0.0.1
token.secret=8sd7fa9s8df44fasff55
token.expiration_time=864000000
login.url.path=/users/login

### bootstrap.properties
spring.cloud.config.uri=http://localhost:8888/
spring.cloud.config.name=PhotoAppAPIConfigServer

## Spring cloud Bus
Adicionado dependencia bus e actuator

### JCE - Java Cryptography Extension
0. Add bootstrap: encrypt.key=8psu8as8ua8su8us3293je23e29j11
1. POST Text http://localhost:8888/enrypt
2. POST Text http://localhost:8888/decrypt
3. No git ou native adicionar no arquivo properties: spring.datasource.password={cipher}541aeb706e4d070f9a1ea74ba4bdae3df77dec84c258e8d505c2b4b7ccd41dd0

