package org.example.springdatajdbc;

import lombok.extern.slf4j.Slf4j;
import org.example.springdatajdbc.config.TestAuditConfig;
import org.example.springdatajdbc.entity.Audit;
import org.example.springdatajdbc.repository.AuditRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

@Slf4j
@DataJdbcTest
@Import(TestAuditConfig.class)
public class AuditTests {

    @Autowired
    private AuditRepository auditRepository;

    @Rollback(value = false)
    @Test
    @Sql("/audit.sql")
    void test() {
        Audit audit = new Audit();
        Audit save = auditRepository.save(audit);
        log.info("save : {}", save);
    }
}
