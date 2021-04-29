package org.example.springdatajdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("CONTACTS")
@Data
@AllArgsConstructor
public class Contact {

    private String contactNo;
}
