package org.example.springdatajdbc.config;

import lombok.extern.slf4j.Slf4j;
import org.example.springdatajdbc.entity.GeneratedId;
import org.example.springdatajdbc.idgeneration.DefaultGeneratorContext;
import org.example.springdatajdbc.idgeneration.IdGenerationFactory;
import org.example.springdatajdbc.idgeneration.IdGenerator;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.util.ReflectionUtils;

import java.lang.reflect.Field;

@Slf4j
@TestConfiguration
@EnableJdbcAuditing
public class TestAuditConfig {

    @Bean
    public ApplicationListener<BeforeSaveEvent<?>> beforeSaveEventApplicationListener(){
        return event -> {
            log.info("beforeSave : {}", event);
            Object object = event.getEntity();
            if(object instanceof GeneratedId){
                GeneratedId generatedId = (GeneratedId) object;
                Field idField = ReflectionUtils.findField(object.getClass(), new org.springframework.util.ReflectionUtils.FieldFilter() {
                    @Override
                    public boolean matches(Field field) {
                        return field.getAnnotation(Id.class) != null;
                    }
                });
                if(idField != null){
                    Class<?> type = idField.getType();
                    IdGenerator<Object, ?> generator = IdGenerationFactory.getGenerator(type);
                    Object generate = generator.generate(new DefaultGeneratorContext(object, idField));
                    generatedId.setId(generate);
                    log.info("id type : {}", type);
                }
//                generatedId.setId();
            }
        };
    }
}
