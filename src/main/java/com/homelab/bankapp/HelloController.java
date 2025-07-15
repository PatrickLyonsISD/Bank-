package com.homelab.bankapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "welcome to my bank";
    }
}
