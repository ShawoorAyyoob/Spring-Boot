package com.shawoor.topsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/greetings")
    public String greetUser(){
        return "Hello World";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Line is Secured";
    }

    @GetMapping("/admin-logs")
    public String adminLogs(){
        return "Welcome Admin";
    }
}
