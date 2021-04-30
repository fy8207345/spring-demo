package org.example.springdatajdbc.entity.composite;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("T_COMPOSITE")
public class CompositeEntity implements Persistable<Long> {

    @Id
    private Long id;

    private String detail;

    @Override
    public boolean isNew() {
        return true;
    }
}
