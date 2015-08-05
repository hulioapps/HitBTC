package com.apps.hulios.hitbtc.ResponseObjects;

/**
 * Created by Boss on 2015-07-29.
 */
public class Symbol {

    String symbol;
    float step;
    float lot;
    String currency;
    String comodity;
    float takeLiquidityRate;
    float provideLiquidityRate;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getStep() {
        return step;
    }

    public void setStep(float step) {
        this.step = step;
    }

    public float getLot() {
        return lot;
    }

    public void setLot(float lot) {
        this.lot = lot;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComodity() {
        return comodity;
    }

    public void setComodity(String comodity) {
        this.comodity = comodity;
    }

    public float getTakeLiquidityRate() {
        return takeLiquidityRate;
    }

    public void setTakeLiquidityRate(float takeLiquidityRate) {
        this.takeLiquidityRate = takeLiquidityRate;
    }

    public float getProvideLiquidityRate() {
        return provideLiquidityRate;
    }

    public void setProvideLiquidityRate(float provideLiquidityRate) {
        this.provideLiquidityRate = provideLiquidityRate;
    }
    @Override
    public String toString() {
        return "Symbol{" +
                "symbol='" + symbol + '\'' +
                ", step=" + step +
                ", lot=" + lot +
                ", currency='" + currency + '\'' +
                ", comodity='" + comodity + '\'' +
                ", takeLiquidityRate=" + takeLiquidityRate +
                ", provideLiquidityRate=" + provideLiquidityRate +
                '}';
    }


}
