package org.example.springdatajdbc;

import lombok.extern.slf4j.Slf4j;
import org.example.springdatajdbc.config.TestAuditConfig;
import org.example.springdatajdbc.entity.composite.CompositeEntity;
import org.example.springdatajdbc.entity.composite.CompositeId;
import org.example.springdatajdbc.repository.CompositeIdRepository;
import org.example.springdatajdbc.repository.CompositeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

@Slf4j
@DataJdbcTest
@Import(TestAuditConfig.class)
public class CompositeTests {

    @Autowired
    private CompositeIdRepository compositeIdRepository;
    @Autowired
    private CompositeRepository compositeRepository;

    @Rollback(value = false)
    @Test
    @Sql("/composite.sql")
    void test() {
        CompositeId compositeId = new CompositeId();
        CompositeEntity entity = new CompositeEntity();
        entity.setDetail("detail");
        compositeId.setEntity(entity);
        CompositeId save = compositeIdRepository.save(compositeId);
        log.info("save : {}", save);
    }
}
