package com.kjoshi.basicms.helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("${app.env.baseurl}")
@RestController
public class HelloWorldController {

    @Value("${app.env.name}")
    private String envName;

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/hello")
    public String sayHello(){
        logger.info("Hello called");
        return "Hello "+envName;
    }

}
