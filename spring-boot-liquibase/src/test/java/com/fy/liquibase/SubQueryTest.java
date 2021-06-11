package com.fy.liquibase;

import com.fy.liquibase.entity.SubEntity;
import com.fy.liquibase.entity.TestEntity;
import com.fy.liquibase.repository.TestEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@DataJpaTest
public class SubQueryTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    //测试未通过
    @Test
    void name() {
        SubEntity subEntity1 = new SubEntity();
        subEntity1.setName("test1");

        SubEntity subEntity2 = new SubEntity();
        subEntity2.setName("test2");

        Set<SubEntity> set1 = new HashSet<>();
        set1.add(subEntity1);
        set1.add(subEntity2);
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setSubEntities(set1);

        SubEntity subEntity3 = new SubEntity();
        subEntity3.setName("测试1");

        SubEntity subEntity4 = new SubEntity();
        subEntity4.setName("测试2");

        Set<SubEntity> set2 = new HashSet<>();
        set2.add(subEntity3);
        set2.add(subEntity4);
        TestEntity testEntity2 = new TestEntity();
        testEntity2.setSubEntities(set2);

        testEntityRepository.save(testEntity1);
        testEntityRepository.save(testEntity2);

        List<TestEntity> result = testEntityRepository.findBySubEntitiesNameLike("%测试%");
        log.info("result: {}", result);
        log.info("all: {}", testEntityRepository.findAll());
    }
}
