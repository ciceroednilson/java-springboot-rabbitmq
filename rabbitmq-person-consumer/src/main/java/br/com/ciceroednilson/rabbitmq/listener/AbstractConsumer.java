package br.com.ciceroednilson.rabbitmq.listener;

import br.com.ciceroednilson.rabbitmq.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractConsumer implements MessageListener {

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        final String bodyJson = new String(message.getBody());
        final ObjectMapper mapper = new ObjectMapper();
        final Person person = mapper.readValue(bodyJson, Person.class);
        onMessagePerson(person);
    }

    public abstract void onMessagePerson(final Person person);
}
