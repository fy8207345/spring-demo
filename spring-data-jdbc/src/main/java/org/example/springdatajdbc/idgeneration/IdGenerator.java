package org.example.springdatajdbc.idgeneration;

public interface IdGenerator<ENTITY, ID> {

    ID generate(GeneratorContext<ENTITY> context);
}
