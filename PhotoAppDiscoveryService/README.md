
## Spring Cloud NetFlix Eureka
Spring Cloud NetFlix fornece integrações do Netflix OSS para aplicativos Spring através de configurações automática. 
#### Os padrões fornecidos incluem:
1. Service Discovery (Eureka)
2. Circuit Breaker (Hystrix)
3. Intelligent Routing (Zuul)
4. Client Side Load Balanceing (Ribbon)..


#### Características Conceituais
Recursos da Spring Cloud Netflix:
1. Descoberta de serviço: as instâncias de Eureka podem ser registradas e os clientes podem descobrir as instâncias usando Beans gerenciados pela Spring.
2. Service Discovery: um servidor Eureka incorporado pode ser criado com configuração Java declarativa
3. Circuit Breaker: Os clientes da Hystrix podem ser construídos com um simples decorador de métodos orientados para anotações
4. Circuit Breaker: painel Hystrix incorporado com configuração Java declarativa
5. Declarative REST Client: A Feign cria uma implementação dinâmica de uma interface decorada com anotações de JAX-RS ou Spring MVC
6. Client Side Load Balancer: fita
7. Configuração Externa: uma ponte do Ambiente de Primavera para o Archaius (permite a configuração nativa dos componentes netflix usando convenções de inicialização de mola)
8. Router and Filter: registro automático de filtros Zuul e uma simples convenção sobre abordagem de configuração para criação reversa de proxy

#### Características Aplicação:
1. port=8010
2. name=discoveryservice
3. register.with.eureka=false
4. fetch-registry=false

#### Passos
1. Add Eureka cliente e server
2. No main anotação para habilitar eureka
3. arquivo propertie
