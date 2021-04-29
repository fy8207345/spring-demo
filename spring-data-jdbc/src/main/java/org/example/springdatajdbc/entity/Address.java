package org.example.springdatajdbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("t_address")
public class Address {

    private String detail;
}
