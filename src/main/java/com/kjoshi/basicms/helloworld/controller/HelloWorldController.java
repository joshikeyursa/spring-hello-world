package com.kjoshi.basicms.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello-world")
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "SUCCESS";
    }

}
