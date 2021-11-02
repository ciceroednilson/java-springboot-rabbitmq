package br.com.ciceroednilson.rabbitmq.listener;

import br.com.ciceroednilson.rabbitmq.model.Person;

import br.com.ciceroednilson.rabbitmq.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQPersonConsumer extends AbstractConsumer {

    @Autowired
    private PersonService personService;

    @Override
    public void onMessagePerson(final Person person) {
        personService.save(person);
    }
}