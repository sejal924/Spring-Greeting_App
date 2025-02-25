package com.bridgeLabz.service;

import com.bridgeLabz.model.Greeting;
import com.bridgeLabz.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    public String getGreeting(){
        return "Hello world";
    }

    @Autowired
    private GreetingRepository greetingRepository;

    public String getGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            message = "Hello " + firstName;
        } else if (lastName != null) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }
        saveGreeting(message);
        return message;
    }

    public void saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);
    }

    public Optional<Greeting> findGreetingById(long id){
        return greetingRepository.findById(id);
    }
    public List<Greeting> getAllGreeting(){
        return greetingRepository.findAll();
    }
}