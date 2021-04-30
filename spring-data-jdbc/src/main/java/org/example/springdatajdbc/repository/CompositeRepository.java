package org.example.springdatajdbc.repository;

import org.example.springdatajdbc.entity.composite.CompositeEntity;
import org.example.springdatajdbc.entity.composite.CompositeId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositeRepository extends PagingAndSortingRepository<CompositeEntity, Long> {
}
