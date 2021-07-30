package org.example.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    private final Log logger;

    public MyEnvironmentPostProcessor(Log logger) {
        this.logger = logger;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        logger.info("environment: " + environment);
        log.info("environment: " + environment);

//        System.out.println(environment);
    }
}
