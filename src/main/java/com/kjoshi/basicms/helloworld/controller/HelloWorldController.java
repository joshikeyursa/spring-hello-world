package com.kjoshi.basicms.helloworld.controller;

import com.kjoshi.basicms.helloworld.service.HelloService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.env.baseurl}")
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Value("${app.env.name}")
    private String envName;

    @Autowired
    private HelloService service;

    @RequestMapping("/hello")
    public String sayHello(){
        logger.info("Hello called");
        return service.sayHello(envName);
    }

}
