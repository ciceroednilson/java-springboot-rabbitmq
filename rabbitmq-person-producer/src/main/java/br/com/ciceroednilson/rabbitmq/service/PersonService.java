package br.com.ciceroednilson.rabbitmq.service;

import br.com.ciceroednilson.rabbitmq.model.Person;
import br.com.ciceroednilson.rabbitmq.repository.RabbitMQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PersonService {

    @Autowired
    private RabbitMQRepository rabbitMQRepository;

    public void save(final Person person) {
        final ZonedDateTime now = ZonedDateTime.now();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        final String date = now.format(formatter);
        person.setRegister(date);
        rabbitMQRepository.sender(person);
    }
}
