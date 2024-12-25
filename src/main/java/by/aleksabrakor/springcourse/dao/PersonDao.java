package by.aleksabrakor.springcourse.dao;

import by.aleksabrakor.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query(
                "SELECT *FROM person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getById(int personId) {
//        SELECT *FROM PERSON where id= personId;
       return  jdbcTemplate.query(
               "SELECT *FROM person WHERE id=?",
               new Object[]{personId},
               new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update(
                "INSERT INTO Person (name, age, email, address) VALUES(?,?,?,?)",
                person.getName(),
                person.getAge(),
                person.getEmail(),
                person.getAddress()
        );
    }

    public void update(Person personUpdate, int id) {
        jdbcTemplate.update(
                "UPDATE Person SET name=?, age=?, email=?, address=? WHERE id=?",
                personUpdate.getName(),
                personUpdate.getAge(),
                personUpdate.getEmail(),
                personUpdate.getAddress(),
                id );
    }

    public void deleteById(int id) {
        jdbcTemplate.update(
                "DELETE FROM Person WHERE id = ?",
                id);
    }

    public Optional<Person> findByEmail(String email, int id) {
        return jdbcTemplate.query(
                "SELECT *FROM Person WHERE email = ? and id !=?",
                new Object[]{email,id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
}
