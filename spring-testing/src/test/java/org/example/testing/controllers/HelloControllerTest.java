package org.example.testing.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void hello() {
        HelloController helloController = new HelloController();
        String result = helloController.hello("Java");
        assertEquals("Hello, Java", result);
    }
}
