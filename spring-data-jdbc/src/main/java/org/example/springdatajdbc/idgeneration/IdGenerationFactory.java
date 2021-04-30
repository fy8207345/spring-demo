package org.example.springdatajdbc.idgeneration;

import java.util.HashMap;
import java.util.Map;

public class IdGenerationFactory {
    private static Map<Class<?>, IdGenerator<?, ?>> map = new HashMap<>();

    static {
        map.put(String.class, new StringGenerator());
        map.put(Long.class, new LongGenerator());
    }

    public static  <ENTITY, ID> IdGenerator<ENTITY, ID> getGenerator(Class<ID> id){
        IdGenerator<?, ?> idGenerator = map.get(id);
        return (IdGenerator<ENTITY, ID>) idGenerator;
    }
}
