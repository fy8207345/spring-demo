package org.example.testing;

import org.example.testing.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class TestingAppTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private HelloService helloService;


    @Test
    void name() {
        System.out.println(helloService.service());
    }
}
