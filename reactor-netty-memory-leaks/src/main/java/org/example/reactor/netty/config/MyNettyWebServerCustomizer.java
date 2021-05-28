package org.example.reactor.netty.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MyNettyWebServerCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
        factory.addServerCustomizers(httpServer -> httpServer.wiretap(true));
    }

    @Bean
    public WebClient webClient(){
        WebClient.Builder builder = WebClient.builder();
        return builder.build();
    }
}
