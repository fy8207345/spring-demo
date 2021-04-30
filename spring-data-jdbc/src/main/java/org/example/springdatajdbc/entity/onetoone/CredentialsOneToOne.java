package org.example.springdatajdbc.entity.onetoone;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("USER_CREDENTIALS_ONE_TO_ONE")
public class CredentialsOneToOne {

    @Id
    private Long credsId;
    private String userName;
    private String password;
}
