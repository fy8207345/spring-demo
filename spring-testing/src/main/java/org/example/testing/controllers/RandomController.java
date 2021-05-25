package org.example.testing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

    @GetMapping("/random")
    public String random(){
        return "random";
    }
}
