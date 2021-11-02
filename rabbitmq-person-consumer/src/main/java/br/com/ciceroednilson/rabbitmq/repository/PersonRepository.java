package br.com.ciceroednilson.rabbitmq.repository;

import br.com.ciceroednilson.rabbitmq.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(final Person person) {
        final String sql = "INSERT INTO tb_person (id, name, gender, register) VALUES(?, ?, ?, ?); ";
        jdbcTemplate.update(sql, person.getId(), person.getName(), person.getGender(), person.getRegister());
    }
}
