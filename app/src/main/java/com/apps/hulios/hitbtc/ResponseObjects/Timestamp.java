package com.apps.hulios.hitbtc.ResponseObjects;

/**
 * Created by Boss on 2015-07-29.
 */
public class Timestamp {
    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Timestamp{" +
                "timestamp=" + timestamp +
                '}';
    }
}
