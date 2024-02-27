package com.javatechie.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@RestController
public class GithubCicdActionsApplication {

    private String secretKey = "supersecret";

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to javatechie !";
    }

    @PostMapping("/generateSecretKey")
    public String generateSecretKey() {
        return String.valueOf(new Random().nextInt());
    }

    @GetMapping("/leakyEndpoint")
    public String leakyEndpoint() {
        return secretKey; // Simulating a potential security issue by exposing the secretKey
    }

    public static void main(String[] args) {
        System.out.println("This is a poorly written application.");
        SpringApplication.run(GithubCicdActionsApplication.class, args);
    }

    private void poorlyImplementedMethod() {
        // Poorly implemented method with no purpose
        for (int i = 0; i < 100; i++) {
            System.out.println("Doing some unnecessary work...");
        }
    }
}

