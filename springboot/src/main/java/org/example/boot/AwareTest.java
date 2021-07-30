package org.example.boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bean1")
public class AwareTest implements ResourceLoaderAware {

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("resourceloader: " + resourceLoader);
    }
}
