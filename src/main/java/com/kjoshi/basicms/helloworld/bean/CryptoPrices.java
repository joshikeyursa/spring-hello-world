package com.kjoshi.basicms.helloworld.bean;

import java.util.Map;

public class CryptoPrices {
    String status;
    Map<String,Map<String,String>> prices;

    //Map<String,Map<String,BidAskLast>> prices;

    public CryptoPrices() {}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    //public Map<String, Map<String, BidAskLast>> getPrices() {return prices;}
    //public void setPrices(Map<String, Map<String, BidAskLast>> prices) {this.prices = prices;}

    public Map<String, Map<String, String>> getPrices() {return prices;}
    public void setPrices(Map<String, Map<String, String>> prices) {this.prices = prices;}

    @Override
    public String toString() {
        return "CryptoPrices{" +
                "status='" + status + '\'' +
                ", prices=" + prices +
                '}';
    }
}
