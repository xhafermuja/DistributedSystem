package com.unipz.xhm.fshk.backendsystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from authorized API request!";
    }
}
