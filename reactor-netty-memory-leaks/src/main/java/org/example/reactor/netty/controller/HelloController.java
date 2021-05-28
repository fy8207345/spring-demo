package org.example.reactor.netty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/")
    public Mono<String> home(){
        return Mono.just("home")
                .delayElement(Duration.ofMillis(5500));
    }

    @GetMapping("/hello/{delay}")
    public Mono<String> hello(@PathVariable("delay") long delay, ServerWebExchange exchange){
        String logPrefix = exchange.getLogPrefix();
        log.info("{}: received request", logPrefix);
        return Mono.just("hello")
                .delayElement(Duration.ofMillis(delay));
    }

    @GetMapping("/remote")
    public Mono<String> remote(){
        return webClient.get()
                .uri("http://localhost:8080/")
                .exchange()
                .flatMap(response -> Mono.just(response.statusCode().toString()))
                .timeout(Duration.ofSeconds(5));
    }
}
