package com.kjoshi.basicms.helloworld.transformers;

import com.kjoshi.basicms.helloworld.bean.CryptoPrice;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CoinspotCryptoResponseTransformer implements
        CryptoResponseTransformer<Map<String,String>,CryptoPrice>{

    @Override
    public CryptoPrice transform(String coinKey,Map<String, String> parameter) {
        CryptoPrice cryptoPrice = new CryptoPrice(coinKey,
                Double.valueOf(parameter.get("bid")),
                Double.valueOf(parameter.get("ask")),
                Double.valueOf(parameter.get("last")));
        return cryptoPrice;
    }
}
