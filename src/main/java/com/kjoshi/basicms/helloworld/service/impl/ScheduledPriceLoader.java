package com.kjoshi.basicms.helloworld.service.impl;

import com.kjoshi.basicms.helloworld.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPriceLoader {

    @Autowired
    private final CryptoService cryptoService;

    public ScheduledPriceLoader(CryptoService cryptoService){
        this.cryptoService = cryptoService;
    }

    @Scheduled(cron = "*/300 * * * * *")
    public void loadCryptoPrices(){
        cryptoService.fetchListOfCoins();
    }
}
