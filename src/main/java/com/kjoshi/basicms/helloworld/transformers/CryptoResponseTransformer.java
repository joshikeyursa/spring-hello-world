package com.kjoshi.basicms.helloworld.transformers;

import com.kjoshi.basicms.helloworld.bean.CryptoPrice;

@FunctionalInterface
public interface CryptoResponseTransformer<T,CryptoPrice> {
    CryptoPrice transform(String key, T parameter);
}
