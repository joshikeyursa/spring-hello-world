package com.kjoshi.basicms.helloworld.controller;

import com.kjoshi.basicms.helloworld.bean.CryptoPrice;
import com.kjoshi.basicms.helloworld.service.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("${app.env.baseurl}")
public class CoinController {

    @Autowired
    CryptoService service;

    private static final Logger logger = LoggerFactory.getLogger(CoinController.class);

    @RequestMapping("/crypto-coin")
    public Mono<List<CryptoPrice>> getCoinsList(){
        logger.info("Will list all coins");
        return service.fetchListOfCoins();
    }
}
