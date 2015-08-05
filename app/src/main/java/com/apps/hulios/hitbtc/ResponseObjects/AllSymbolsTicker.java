package com.apps.hulios.hitbtc.ResponseObjects;

/**
 * Created by Boss on 2015-07-29.
 */
public class AllSymbolsTicker extends SymbolTicker {
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "AllSymbolsTicker{" +
                "symbol='" + symbol + '\'' +
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
