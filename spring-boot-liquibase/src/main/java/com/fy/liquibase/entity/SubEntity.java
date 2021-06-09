package com.fy.liquibase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "SUB_ENTITY")
@Entity
public class SubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String toString() {
        return "SubEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
