package org.example.testing.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = {HelloController.class})
class HelloControllerIntegretionTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/hello")).andReturn();
        assertEquals("Hello, Java", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void helloWithName() throws Exception {
        mvc.perform(get("/hello?name=World"))
                .andExpect(content().string("Hello, World"));
    }
}
