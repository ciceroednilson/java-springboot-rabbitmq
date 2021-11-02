package br.com.ciceroednilson.rabbitmq.config;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RabbitMQParameters {
    private String exchange;
    private String routingKey;
}
