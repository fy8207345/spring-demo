package org.example.testing.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class HelloServiceTest {

    @MockBean
    private HelloService helloService;

    @BeforeEach
    public void init(){
        given(helloService.service())
                .willReturn("service");
    }

    @Test
    void service() {
        String service = helloService.service();
        assertEquals("service", service);
    }
}
