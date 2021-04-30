package org.example.springdatajdbc.repository;

import org.example.springdatajdbc.entity.Audit;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends PagingAndSortingRepository<Audit, Long> {
}
