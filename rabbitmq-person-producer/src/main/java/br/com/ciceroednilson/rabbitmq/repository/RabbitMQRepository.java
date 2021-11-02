package br.com.ciceroednilson.rabbitmq.repository;

import br.com.ciceroednilson.rabbitmq.config.RabbitMQParameters;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RabbitMQRepository {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQParameters rabbitMQParameters;

    public <T> void sender(T t) {
        rabbitTemplate.convertAndSend(rabbitMQParameters.getExchange(), rabbitMQParameters.getRoutingKey(), t);
    }
}
