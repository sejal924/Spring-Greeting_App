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
        return "GET : " + greetingService.getGreeting();
    }

    @PostMapping("/greeting")
    public String postGreeting(){
        return "POST : " + greetingService.getGreeting();
    }

    @PutMapping("/greeting")
    public String putGreeting(){
        return "PUT : " + greetingService.getGreeting();
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting(){
        return "DELETE : " + greetingService.getGreeting();
    }

    //UseCase: 3
    @GetMapping("/greeting/params")
    public String getGreetingParams(@RequestParam(value = "firstName",required = false) String firstName,
                                    @RequestParam(value = "lastName",required = false) String lastName){
        return greetingService.displayingGreeting(firstName,lastName);
    }
}