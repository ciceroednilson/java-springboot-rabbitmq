package br.com.ciceroednilson.rabbitmq.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private Integer id;
    private String name;
    private String gender;
    private String register;
}
