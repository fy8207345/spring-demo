package org.example.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.rsocket.messaging.RSocketStrategiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.codec.StringDecoder;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import reactor.core.publisher.Mono;

import java.util.Map;

@SpringBootApplication
public class ServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class, args);
    }

    private final String headerId = "client-id";
    private final MimeType mimeType = MimeType.valueOf("messaging/x.fy.client-id");

    @Bean
    RSocketStrategiesCustomizer rSocketStrategiesCustomizer(){
        return strategies -> strategies
                .metadataExtractorRegistry(registry -> registry.metadataToExtract(mimeType, String.class, headerId))
                .decoders(decoders -> decoders.add(StringDecoder.allMimeTypes()));
    }
}

@Controller
class MessageController{
    @MessageMapping("hello")
    Mono<String> hello(@Header("client-id") String clientId, @Headers Map<String, Object> headers){
        headers.forEach((s, o) -> System.out.println(s + "=" + o));
        return Mono.just("hello, " + clientId);
    }
}
