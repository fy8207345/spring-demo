package org.example.testing.annotations.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.support.AbstractTestContextBootstrapper;

@BootstrapWith(value = BootstrapWithTests.MyBootstrapper.class)
public class BootstrapWithTests {

    @Test
    void name() {
        System.out.println(this);
    }

    public static class MyBootstrapper extends AbstractTestContextBootstrapper{

        @Override
        protected Class<? extends ContextLoader> getDefaultContextLoaderClass(Class<?> testClass) {
            return SpringBootContextLoader.class;
        }
    }
}
