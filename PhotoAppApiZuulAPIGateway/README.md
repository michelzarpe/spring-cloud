
## Zuul API Gateway
#### Características
1. port:8011
2. name:zuul

#### Passos
1. Add Eureka cliente, spring web, devtools and zuul
2. No main anotação para habilitar eureka cliente e zuul proxy
3. arquivo properties

#### Rota
1. http://localhost:8011/users-ws/users/status/check
2. http://localhost:8011/account-ws/users/status/check

### O que é um Proxy Zuul
O cerne do padrão de microsserviços é criar um serviço independente que possa ser 
dimensionado e implantado de forma independente. Assim, em um domínio de negócios 
complexo, mais de 50-100 microsserviços é muito comum. Vamos imaginar um sistema 
onde temos cinquenta microsserviços agora temos que implementar uma interface do 
usuário que é uma espécie de painel, por isso ele chama vários serviços para buscar 
e mostrar as informações importantes na Interface do Usuário.
Do ponto de vista do desenvolvedor de interface do usuário, para coletar informações 
de cinquenta microsserviços subjacentes, ele tem que chamar cinquenta APIs REST, pois 
cada microsserviço expõe uma API REST para comunicação. Assim, o cliente tem que saber 
os detalhes de todos os padrões/portas de API e URL REST para chamá-los. Certamente, 
não soa como um bom design. É uma espécie de quebra de encapsulamento; a interface do 
usuário precisa conhecer todos os detalhes do servidor/porta de microsserviços para consultar os serviços.
Além disso, pense nos aspectos comuns de um programa web, como CORS, autenticação, 
segurança e monitoramento em termos desse projeto- cada equipe de microsserviço tem que desenvolver 
todos esses aspectos em seu próprio serviço, de modo que o mesmo código foi replicado em mais de cinquenta microsserviços. 
Mudanças nos requisitos de autenticação ou política CORS irão repercutir em todos os serviços. 
É contra o princípio DRY, por isso este tipo de design é muito propenso a erros e rígido. 
Para torná-lo robusto, ele tem que ser alterado dessa forma para que tenhamos apenas um ponto de 
entrada onde todos os aspectos comuns do código são escritos e o cliente se comunica com esse serviço comum. 
Aqui, o conceito Zuul (The Gatekeeper/Demigod) aparece.
Fonte: https://dzone.com/articles/microservices-communication-zuul-api-gateway-1
