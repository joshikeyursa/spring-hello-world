package com.kjoshi.basicms.helloworld.service.impl;

import com.kjoshi.basicms.helloworld.bean.CryptoPrice;
import com.kjoshi.basicms.helloworld.bean.CryptoPrices;
import com.kjoshi.basicms.helloworld.service.CryptoService;
import com.kjoshi.basicms.helloworld.transformers.CryptoResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CoinSpotCryptoService implements CryptoService {

    @Value("${crypto.price.url.coinspot}")
    private String cryptoURL;

    @Autowired
    CryptoResponseTransformer<Map<String,String>,CryptoPrice> transformer;

    @Override
    public Mono<List<CryptoPrice>> fetchListOfCoins() {
        try{
            WebClient client = WebClient.create(cryptoURL);
            List<CryptoPrice> priceList = new ArrayList<>();
            Mono<List<CryptoPrice>> cryptoPricesMono = client.get().retrieve().bodyToMono(CryptoPrices.class).map(cryptoPrices -> {
               cryptoPrices.getPrices().
                       forEach((coinSymbol,coinPrice)-> priceList.add(transformer.transform(coinSymbol,coinPrice)));
               return priceList;
            });
            cryptoPricesMono.subscribe(System.out::println);
            return cryptoPricesMono;
        }catch (Exception e){
            return Mono.just(new ArrayList<>());
        }
    }
}
