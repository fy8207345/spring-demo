package org.example.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.rsocket.messaging.RSocketStrategiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.codec.StringDecoder;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.retrosocket.EnableRSocketClients;
import org.springframework.retrosocket.RSocketClient;
import org.springframework.util.MimeType;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.lang.annotation.*;

@Slf4j
@EnableRSocketClients
@SpringBootApplication
public class RSocketClientApp {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RSocketClientApp.class, args);
        System.in.read();
    }

    @Bean
    RSocketRequester requester(RSocketRequester.Builder builder){
        return builder.tcp("localhost", 8181);
    }

    @GreetingRSocket
    @Bean
    RSocketRequester requester2(RSocketRequester.Builder builder){
        return builder.tcp("localhost", 8181);
    }

//    @Bean
//    public ApplicationRunner basic(RSocketRequester requester){
//        return event -> {
//            requester.route("hello")
//                    .retrieveMono(String.class)
//                    .subscribe(s -> {
//                        log.info("requester response: {}", s);
//                    });
//        };
//    }

//    @Bean
//    ApplicationRunner client(HelloClient helloClient){
//        return event -> {
//          helloClient.greeting("rsocketclientApp")
//          .subscribe(s -> {
//              log.info("client response: {}", s);
//          });
//        };
//    }

    @Bean
    ApplicationRunner client(GreetingClient greetingClient){
        return event -> {
            greetingClient.greet("hhahah")
                    .subscribe(s -> {
                        log.info("custom: {}", s);
                    });
        };
    }
}

@GreetingRSocket
@RSocketClient
interface HelloClient{

    @MessageMapping("hello.{name}")
    Mono<String> greeting(@DestinationVariable String name);
}

@GreetingRSocket
@RSocketClient
interface GreetingClient{

    @MessageMapping("hello")
    Mono<String> greet(@Header("messaging/x.fy.client-id") String clientId);
}

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("two")
@interface GreetingRSocket {
}
