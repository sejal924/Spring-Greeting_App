package com.example.demo.extend;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting-service")
public class GreetingServiceController {

    private final GreetingService greetingService;

    public GreetingServiceController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting(greetingService.getGreetingMessage());
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
