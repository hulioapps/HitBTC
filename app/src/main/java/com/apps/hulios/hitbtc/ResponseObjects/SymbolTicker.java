package com.apps.hulios.hitbtc.ResponseObjects;

/**
 * Created by Boss on 2015-07-29.
 */
public class SymbolTicker {
    float last;
    float bid;
    float ask;
    float high;
    float low;
    float volume;
    float open;
    float volume_quote;
    long timestamp;

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getVolume_quote() {
        return volume_quote;
    }

    public void setVolume_quote(float volume_quote) {
        this.volume_quote = volume_quote;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SymbolTicker{" +
                "last=" + last +
                ", bid=" + bid +
                ", ask=" + ask +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                ", open=" + open +
                ", volume_quote=" + volume_quote +
                ", timestamp=" + timestamp +
                '}';
    }
}
