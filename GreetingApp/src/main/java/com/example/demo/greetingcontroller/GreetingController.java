package com.example.demo.greetingcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello, GET request received!");
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello, POST request received!");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello, PUT request received!");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello, DELETE request received!");
    }

    // Inner class for response model
    static class Greeting {
        private String message;

        public Greeting(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
