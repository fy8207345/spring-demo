package org.example.springdatajdbc.idgeneration;

import java.util.UUID;

public class StringGenerator extends BaseGenerator<String>{

    @Override
    public String generate(GeneratorContext<Object> context) {
        return UUID.randomUUID().toString();
    }
}
