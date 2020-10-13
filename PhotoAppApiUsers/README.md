![Screenshot](fluxo_user.png.png)

## API USERS
#### Características
1. port:8020 or port:0 (ai ele busca automaticamente uma porta, importate para podermos executar varias instancia)
2. name:users-ws 
3. id: eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}

#### Passos
1. Add Eureka cliente, spring web e devtools
2. No main anotação para habilitar eureka cliente
3. arquivo properties
