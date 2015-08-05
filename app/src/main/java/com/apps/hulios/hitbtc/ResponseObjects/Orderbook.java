package com.apps.hulios.hitbtc.ResponseObjects;

import java.util.List;

/**
 * Created by Boss on 2015-07-30.
 */
public class Orderbook {
    List<float[]> asks; //[0] - price [1] - volume
    List<float[]> bids;

    public List<float[]> getAsks() {
        return asks;
    }

    public void setAsks(List<float[]> asks) {
        this.asks = asks;
    }

    public List<float[]> getBids() {
        return bids;
    }

    public void setBids(List<float[]> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Orderbook{" +
                "asks=" + asks +
                ", bids=" + bids +
                '}';
    }
}
