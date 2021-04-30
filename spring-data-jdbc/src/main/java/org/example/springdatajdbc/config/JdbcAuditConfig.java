package org.example.springdatajdbc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

@Slf4j
@Configuration
@EnableJdbcAuditing
public class JdbcAuditConfig {

    @Bean
    public ApplicationListener<BeforeSaveEvent<?>> beforeSaveEventApplicationListener(){
        return event -> {
            Object entity = event.getEntity();
            log.info("before save : {}", entity);
        };
    }
}
