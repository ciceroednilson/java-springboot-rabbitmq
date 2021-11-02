package br.com.ciceroednilson.rabbitmq.config;

import br.com.ciceroednilson.rabbitmq.listener.RabbitMQPersonConsumer;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Autowired
    private RabbitMQPersonConsumer rabbitMQPersonConsumer;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Bean
    public Queue buildQueue() {
        return new Queue(queue, true);
    }

    @Bean
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueues(buildQueue());
        simpleMessageListenerContainer.setMessageListener(rabbitMQPersonConsumer);
        return simpleMessageListenerContainer;

    }
}
