package br.com.ciceroednilson.rabbitmq.service;

import br.com.ciceroednilson.rabbitmq.model.Person;
import br.com.ciceroednilson.rabbitmq.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void save(final Person person) {
        personRepository.save(person);
    }
}
