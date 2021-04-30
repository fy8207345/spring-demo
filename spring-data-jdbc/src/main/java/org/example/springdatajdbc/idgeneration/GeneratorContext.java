package org.example.springdatajdbc.idgeneration;

import java.lang.reflect.Field;

public interface GeneratorContext<ENTITY> {

    ENTITY getInstance();

    Field idField();
}
