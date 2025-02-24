package com.bridgeLabz.controller;

import com.bridgeLabz.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public String getGreeting(){
        return "GET : " + message ;
    }

    @PostMapping("/greeting")
    public String postGreeting(){
        return "POST : " + message;
    }

    @PutMapping("/greeting")
    public String putGreeting(){
        return "PUT : " + message;
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting(){
        return "DELETE : " + message;
    }
}
