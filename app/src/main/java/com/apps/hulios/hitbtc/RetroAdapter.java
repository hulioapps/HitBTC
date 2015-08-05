package com.apps.hulios.hitbtc;

import com.apps.hulios.hitbtc.ResponseObjects.Orderbook;
import com.apps.hulios.hitbtc.ResponseObjects.SymbolTicker;
import com.apps.hulios.hitbtc.ResponseObjects.SymbolsResponse;
import com.apps.hulios.hitbtc.ResponseObjects.Timestamp;
import com.apps.hulios.hitbtc.ResponseObjects.Trade;
import com.apps.hulios.hitbtc.ResponseObjects.TradeResponse;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by Boss on 2015-07-29.
 */
public interface RetroAdapter  {
    @GET("/api/1/public/time")
    void getTimestamp(Callback<Timestamp> timestampCallback);

    @GET("/api/1/public/symbols")
    void getSymbols(Callback<SymbolsResponse> symbolsResponseCallback);

    @GET("/api/1/public/{symbol}/ticker")
    void getSymbolTicker(@Path("symbol") String currencySymbol, Callback<SymbolTicker> symbolTickerCallback);

    @GET("/api/1/public/ticker")
    void getAllSymbolsTicker(Callback<Response> responseCallback);

    @GET("/api/1/public/{symbol}/orderbook")
    void getOrderbook (@Path("symbol") String currencySymbol, @QueryMap Map<String,String> params, Callback<Orderbook> orderbookCallback);

    @GET("/api/1/public/{symbol}/trades")
    void getTrades (@Path("symbol") String currencySymbol, @QueryMap Map<String,String> params, Callback<TradeResponse> tradesListCallback);

    @GET("/api/1/public/{symbol}/trades/recent")
    void getRecentTrades (@Path("symbol") String currencySymbol, @QueryMap Map<String,String> params, Callback<TradeResponse> tradesListCallback);
}
