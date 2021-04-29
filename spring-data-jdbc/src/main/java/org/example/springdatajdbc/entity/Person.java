package org.example.springdatajdbc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table("t_person")
public class Person {

    @Id
    private Long id;
    private String name;
    private Date birthday;
    @Version
    private Long version;

    /**
     * PERSON_ID列不能出现在Address的实体声明中
     * DETAIL必须出现在Address的实体声明中
     */
    @MappedCollection(idColumn = "PERSON_ID", keyColumn = "DETAIL")
    private List<Address> addresses;
}
