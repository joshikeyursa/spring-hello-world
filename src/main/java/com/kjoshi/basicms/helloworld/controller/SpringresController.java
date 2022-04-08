package com.kjoshi.basicms.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("${app.env.baseurl}")
public class SpringresController {

    @GetMapping("/springres-hello")
    public String sayHelloToSpringres(){
        return "SUCCESS";
    }
}
