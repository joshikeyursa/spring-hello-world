package com.kjoshi.basicms.helloworld.service;

import com.kjoshi.basicms.helloworld.bean.CryptoPrice;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface CryptoService {
    Mono<List<CryptoPrice>> fetchListOfCoins();
}
