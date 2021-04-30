package org.example.springdatajdbc.repository;

import org.example.springdatajdbc.entity.onetoone.UserOneToOne;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOneToOneRepository extends PagingAndSortingRepository<UserOneToOne, Long> {
}
