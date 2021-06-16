package com.kjoshi.basicms.helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @RequestMapping("/")
    public String groot(){
        logger.info("Root called");
        return "SUCCESS";
    }
}
