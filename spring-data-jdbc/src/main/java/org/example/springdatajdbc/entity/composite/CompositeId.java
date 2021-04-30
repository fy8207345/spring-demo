package org.example.springdatajdbc.entity.composite;

import lombok.Data;
import org.example.springdatajdbc.entity.GeneratedId;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("T_COMPOSITE_ID")
public class CompositeId implements GeneratedId<Long> {

    @Id
    private Long id;

    @MappedCollection(idColumn = "ID")
    private CompositeEntity entity;
}
