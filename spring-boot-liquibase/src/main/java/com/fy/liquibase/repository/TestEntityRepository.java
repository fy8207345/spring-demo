package com.fy.liquibase.repository;

import com.fy.liquibase.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long>,
        JpaSpecificationExecutor<TestEntity> {

    @Query("select t from TestEntity t where t.id = ?1")
    TestEntity findFirstById(Long id);
}
