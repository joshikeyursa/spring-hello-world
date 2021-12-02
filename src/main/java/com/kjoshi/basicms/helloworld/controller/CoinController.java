package com.kjoshi.basicms.helloworld.controller;

import com.kjoshi.basicms.helloworld.bean.CryptoPrice;
import com.kjoshi.basicms.helloworld.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/crypto")
public class CoinController {

    @Autowired
    CryptoService service;

    @RequestMapping("/coins")
    public Mono<List<CryptoPrice>> getCoinsList(){
        return service.fetchListOfCoins();
    }
}
