package org.example.boot;

import org.example.boot.config.MyEnvironmentPostProcessor;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.ResolvableType;

public class Main {
    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(MyEnvironmentPostProcessor.class);
        ResolvableType as = resolvableType.as(EnvironmentPostProcessor.class);
        ResolvableType[] generics = as.getGenerics();
        System.out.println(generics);
    }
}
