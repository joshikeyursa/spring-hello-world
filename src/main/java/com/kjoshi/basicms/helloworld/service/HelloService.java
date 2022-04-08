package com.kjoshi.basicms.helloworld.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @RateLimiter(name="serviceOne",fallbackMethod = "degradeHello")
    public String sayHello(String envName){
        logger.info("Hello called from Service");
        return "Hello "+envName;
    }

    public String degradeHello(String envName,Throwable e){
        logger.info("Degraded Hello due to {}",e.getMessage());
        return "Hello there";
    }
}
