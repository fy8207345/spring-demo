package org.example.springdatajdbc.entity.onetoone;

import lombok.Data;
import org.example.springdatajdbc.entity.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("USER_ONE_TO_ONE")
public class UserOneToOne {

    @Id
    private Long id;
    private Date createdTime;
    private Date updatedTime;
    @Column("DOB")
    private Date dateofBirth;
    private UserType userType;
    @MappedCollection(idColumn = "CREDS_ID")
    private CredentialsOneToOne credentials;
}
