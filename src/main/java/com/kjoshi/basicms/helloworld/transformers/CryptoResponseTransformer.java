package com.kjoshi.basicms.helloworld.transformers;

@FunctionalInterface
public interface CryptoResponseTransformer<T,CryptoPrice> {
    CryptoPrice transform(String key, T parameter);
}
