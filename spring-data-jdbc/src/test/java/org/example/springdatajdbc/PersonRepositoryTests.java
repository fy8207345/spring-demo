package org.example.springdatajdbc;

import lombok.extern.slf4j.Slf4j;
import org.example.springdatajdbc.entity.Address;
import org.example.springdatajdbc.entity.Person;
import org.example.springdatajdbc.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;
import java.util.Date;

@Slf4j
@DataJdbcTest(excludeAutoConfiguration = {TestDatabaseAutoConfiguration.class})
public class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Rollback(value = false)
    void insert() {
        Person person = new Person();
        person.setId(2L);
        person.setName("test-1");
        person.setAddresses(Collections.singletonList(new Address("detail")));
        person.setBirthday(new Date());
        personRepository.save(person);

//        Iterable<Person> all = personRepository.findAll();
//        System.out.println(all);
    }

    @Test
    void find() {
        Iterable<Person> all = personRepository.findAll();
        log.info("findall : {}", all);
    }

    @Test
    @Rollback(value = false)
    void update() {
        Person person = new Person();
        person.setId(1L);
        person.setName("test-update-name");
        person.setAddresses(Collections.singletonList(new Address("detail")));
        person.setBirthday(new Date());
        person.setVersion(0L);

        personRepository.save(person);
    }

    @Test
    void findById() {
        personRepository.findById(1L)
                .ifPresent(person -> {
                    log.info("find person : {}", person);
                });
    }

    @Test
    @Rollback(value = false)
    public void partialUpdate1(){
        personRepository.findById(2L).ifPresent(person -> {
            person.setName("partial-updated-1");
            personRepository.save(person);
        });
    }
}
