package org.example.springdatajdbc;

import lombok.extern.slf4j.Slf4j;
import org.example.springdatajdbc.entity.UserType;
import org.example.springdatajdbc.entity.onetoone.CredentialsOneToOne;
import org.example.springdatajdbc.entity.onetoone.UserOneToOne;
import org.example.springdatajdbc.repository.UserOneToOneRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;

@Slf4j
@DataJdbcTest
public class OneToOneTests {

    @Autowired
    private UserOneToOneRepository userOneToOneRepository;

    @Test
    @DisplayName("One-To-One Mapping Test")
    @Sql(scripts = "/one-to-one-mapping.sql")
    void onetoonetest() {
        UserOneToOne userOneToOne = new UserOneToOne();
        CredentialsOneToOne credentialsOneToOne = new CredentialsOneToOne();
        credentialsOneToOne.setUserName("test");
        credentialsOneToOne.setPassword("test");
        userOneToOne.setCredentials(credentialsOneToOne);
        userOneToOne.setUserType(UserType.EMPLOYEE);
        userOneToOne.setDateofBirth(new Date());
        userOneToOne.setCreatedTime(new Date());
        UserOneToOne save = userOneToOneRepository.save(userOneToOne);
        log.info("save : {}", save);
        Iterable<UserOneToOne> all = userOneToOneRepository.findAll();
        log.info("onetoonetest : {}", all);
    }
}
