package org.example.springdatajdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("T_AUDIT")
public class Audit implements GeneratedId<Long>, Persistable<Long> {

    @Id
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private Long id;

    @CreatedDate
    private LocalDateTime createDate;

    @Override
    public boolean isNew() {
        return true;
    }
}
