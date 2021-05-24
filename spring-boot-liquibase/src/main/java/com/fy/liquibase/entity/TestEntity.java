package com.fy.liquibase.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TEST_ENTITY")
@Entity
public class TestEntity {

    @Id
    private Long id;
}
