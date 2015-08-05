package com.apps.hulios.hitbtc.ResponseObjects;

/**
 * Created by Boss on 2015-07-31.
 */
public class Trade{
    long date;
    float price;
    float amount;
    int tid;
    String side;

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "date=" + date +
                ", price=" + price +
                ", amount=" + amount +
                ", tid=" + tid +
                ", side='" + side + '\'' +
                '}';
    }
}
