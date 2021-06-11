package com.fy.liquibase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Table(name = "TEST_ENTITY")
@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private Set<SubEntity> subEntities;

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", subEntities=" + subEntities +
                '}';
    }
}
