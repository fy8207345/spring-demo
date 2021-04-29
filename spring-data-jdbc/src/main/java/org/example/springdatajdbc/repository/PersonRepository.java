package org.example.springdatajdbc.repository;

import org.example.springdatajdbc.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByName(String name);

}
