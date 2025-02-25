package com.bridgeLabz.controller;

import com.bridgeLabz.model.Greeting;
import com.bridgeLabz.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public String getGreeting() {
        return "GET : " + greetingService.getGreeting();
    }

    @PostMapping("/greeting")
    public String postGreeting() {
        return "POST : " + greetingService.getGreeting();
    }

    @PutMapping("/greeting")
    public String putGreeting() {
        return "PUT : " + greetingService.getGreeting();
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting() {
        return "DELETE : " + greetingService.getGreeting();
    }

    //UseCase: 4
    @GetMapping("/greeting/params")
    public String getGreetingParams(@RequestParam(value = "firstName", required = false) String firstName,
                                    @RequestParam(value = "lastName", required = false) String lastName) {
        return greetingService.getGreeting(firstName, lastName);
    }

    //UseCase: 5
    @GetMapping("/greeting/{id}")
    public String getGreetingById(@PathVariable long id) {
        Optional<Greeting> greeting = greetingService.findGreetingById(id);
        if (greeting.isPresent()) {
            return greeting.get().getMessage();
        } else {
            return "Greeting not found";
        }
    }
  //UseCase: 6
    @GetMapping("/greeting/all")
    public List<Greeting> getAllGreetings(){
        return greetingService.getAllGreeting();
    }
  //UseCase: 7
    @PutMapping("/greeting/{id}")
    public String updatingGreetingById(@PathVariable long id, @RequestParam String message){
        Optional<Greeting> greeting=greetingService.updatingGreeting(id,message);
        if(greeting.isPresent()){
            return "Greeting updated";
        }else{
            return "Greeting not found";
        }
    }
  //UseCase: 8
    @DeleteMapping("/greeting/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreeting(id);
        if(deleted){
            return "Greeting deleted successfully";
        }else{
            return "Greeting not found";
        }
    }
}