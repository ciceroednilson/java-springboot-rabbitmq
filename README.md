# Arquitetura usando Java e RabbitMQ.

Exemplo simples de como produzir e consumir mensagens usando RabbitMQ.

### Desenho da arquitetura.

![arquitetura](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/rabbitmq-project.drawio.png)

### Stack Utilizada.

* Java 17
* SpringBoot
* Intellij
* Docker
* RabbitMQ
* MySQL 

### Micro serviço que produz as mensagens.

* rabbitmq-person-producer

### Micro serviço que consome as mensagens.

* rabbitmq-person-consumer

### Containers necessários para termos o RabbitMQ e MySQL.

RabbitMQ
* docker run -d --hostname rabbitmq --name rabbitmq -p 9000:15672 -p 5673:5672 rabbitmq:3-management
user: guess
password: guess

MySQL
* docker run --name server-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.6

### Acessando RabbitMQ.

* http://localhost:9000/

Tela de login.

![login](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/rabbit-login.png)

### Criando uma Queue no RabbitMQ.

Tela para criação da Queue.

![queue](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/create-queue.png)

### Criando Exchange no RabbitMQ.

Tela para criação do Exchange.

![exchange](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/create-exchange-broker.png)


### Adicionando Routing Key no Exchange criado.

Criando Routing key para enviar a mensagem para a fila.

![routingkey](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/routingkey.png)

### Publicando uma mensagem.

Api rest que envia uma mensagem para o RabbitMQ.

![postman](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/postman.png)

### Visualizando mensagem no RabbitMQ.

Mensagens no formato JSON.

![mensagem](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/mensagem.png)


### Visualizando os dados inseridos no MySQL.

Dados inseridos através do consumer.

![mysql](https://github.com/ciceroednilson/java-springboot-rabbitmq/blob/master/images/mysql.png)



