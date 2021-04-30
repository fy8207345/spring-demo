package org.example.springdatajdbc.idgeneration;

import java.util.concurrent.atomic.AtomicLong;

public class LongGenerator extends BaseGenerator<Long>{

    AtomicLong atomicLong = new AtomicLong(0);

    @Override
    public Long generate(GeneratorContext<Object> context) {
        return atomicLong.getAndIncrement();
    }
}
