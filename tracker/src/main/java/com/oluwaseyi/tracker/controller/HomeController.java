package com.oluwaseyi.tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {


    @GetMapping
    public String home() {
        return "Welcome to the Tracker Application!";
    }


    @GetMapping("/message")
    public String getHomeMessage() {
        return "This is the home message from HomeController.";
    }

}
