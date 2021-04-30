package org.example.springdatajdbc.idgeneration;

import java.lang.reflect.Field;

public class DefaultGeneratorContext implements GeneratorContext<Object> {

    private Object object;
    private Field field;

    public DefaultGeneratorContext(Object object, Field field) {
        this.object = object;
        this.field = field;
    }

    @Override
    public Object getInstance() {
        return object;
    }

    @Override
    public Field idField() {
        return field;
    }
}
