package br.com.ciceroednilson.rabbitmq.controller;

import br.com.ciceroednilson.rabbitmq.model.Person;
import br.com.ciceroednilson.rabbitmq.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private static final String ROUTE_PRODUCER = "/producer";

    @Autowired
    private PersonService personService;

    @PostMapping(path = ROUTE_PRODUCER)
    public HttpStatus producer(@RequestBody final Person person) {
        personService.save(person);
        return HttpStatus.OK;
    }
}
