package org.example.boot;

import org.example.boot.config.MyEnvironmentPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.core.ResolvableType;

@SpringBootApplication
@EnableLoadTimeWeaving
public class BootApp {

    @Autowired
    @Qualifier("bean1")
    private ResourceLoaderAware resourceLoaderAware;

    public static void main(String[] args) {
        ClassLoader classLoader = BootApp.class.getClassLoader();
        System.out.println(classLoader);
        ConfigurableApplicationContext context =
                new SpringApplication(null, new Class[]{BootApp.class})
                .run(args);
        BootApp bean = context.getBean(BootApp.class);
        System.out.println(bean.resourceLoaderAware);
    }
}
