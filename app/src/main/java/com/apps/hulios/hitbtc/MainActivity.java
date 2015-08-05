package com.apps.hulios.hitbtc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.apps.hulios.hitbtc.ResponseObjects.AllSymbolsTicker;
import com.apps.hulios.hitbtc.ResponseObjects.Orderbook;
import com.apps.hulios.hitbtc.ResponseObjects.Symbol;
import com.apps.hulios.hitbtc.ResponseObjects.SymbolTicker;
import com.apps.hulios.hitbtc.ResponseObjects.SymbolsResponse;
import com.apps.hulios.hitbtc.ResponseObjects.Timestamp;
import com.apps.hulios.hitbtc.ResponseObjects.Trade;
import com.apps.hulios.hitbtc.ResponseObjects.TradeResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;


/*
    Uses https://hitbtc.com/api
 */

public class MainActivity extends Activity {
    public static final String ENDPOINT ="http://api.hitbtc.com";
    public static final String DEBUG = "maskopatol";
    RetroAdapter mRetroAdapter;
    RestAdapter mAdapter;
    List<Symbol> mSymbols;
    Timestamp mTimestamp;
    Map<String, String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();

        mRetroAdapter = adapter.create(RetroAdapter.class);

        params = new HashMap<String, String>();
        params.clear();
        params.put("max_results", "10");
        params.put("format_item", "object");
        params.put("side", "true");
        getRecentTradesList("BTCUSD", params);

        getCurrentTimestamp();
        getCurrencySymbols();
        getCurrentSymbolTicker("BTCUSD");
        Map<String, String> params = new HashMap<String,String>();
        params.put("format_price", "number");
        params.put("format_amount", "number");
        getCurrentSymbolOrderbook("BCNBTC", params);

        params.clear();
        params.put("from", "0");
        params.put("by", "ts");
        params.put("start_index", "0");
        params.put("max_results", "10");
        params.put("format_item", "object");
        params.put("side","true");
        getTradesList("BTCUSD", params);




    }
    public String responseToString(Response response){
        return new String(((TypedByteArray) response.getBody()).getBytes());
    }

    public void getCurrentTimestamp(){
        mRetroAdapter.getTimestamp(new Callback<Timestamp>() {
            @Override
            public void success(Timestamp timestamp, Response response) {
                Log.d(DEBUG, "" + timestamp.toString());
                mTimestamp = timestamp;
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    public void getCurrencySymbols(){
        mRetroAdapter.getSymbols(new Callback<SymbolsResponse>() {
            @Override
            public void success(SymbolsResponse symbolsResponse, Response response) {
                mSymbols = symbolsResponse.getSymbols();
                for (Symbol s : mSymbols) {
                    Log.d(DEBUG, "" + s.toString());
                }
                getCurrentAllSymbolsTicker();
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    public void getCurrentSymbolTicker(String symbol){
        mRetroAdapter.getSymbolTicker(symbol, new Callback<SymbolTicker>() {
            @Override
            public void success(SymbolTicker symbolTicker, Response response) {
                Log.d(DEBUG, "" + symbolTicker.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    public void getCurrentAllSymbolsTicker(){
        mRetroAdapter.getAllSymbolsTicker(new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                String responseText = responseToString(response);
                JsonElement jsonElement = new JsonParser().parse(responseText);
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                Gson gson = new GsonBuilder().create();
                List<AllSymbolsTicker> allSymbolsTickerList = new ArrayList<>();
                for (Symbol s : mSymbols) {
                    String symbol = s.getSymbol();
                    JsonObject singleTicker = jsonObject.getAsJsonObject(symbol);
                    AllSymbolsTicker allSymbolsTicker = gson.fromJson(singleTicker, AllSymbolsTicker.class);
                    allSymbolsTicker.setSymbol(symbol);
                    allSymbolsTickerList.add(allSymbolsTicker);
                }
                for (AllSymbolsTicker r : allSymbolsTickerList) {
                    Log.d(DEBUG, "" + r.toString());
                }

            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }

    public void getCurrentSymbolOrderbook(String symbol, Map<String,String> params){
        mRetroAdapter.getOrderbook(symbol, params, new Callback<Orderbook>() {
            @Override
            public void success(Orderbook orderbook, Response response) {
                Log.d(DEBUG, orderbook.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });

    }

    public void getTradesList(String symbol, Map<String,String> params){
        mRetroAdapter.getTrades(symbol, params, new Callback<TradeResponse>() {
            @Override
            public void success(TradeResponse trades, Response response) {
                for (Trade t : trades.getTrades()) {
                    Log.d(DEBUG, t.toString());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(DEBUG,responseToString(error.getResponse()));
                error.printStackTrace();
            }
        });
    }

    public void getRecentTradesList(String symbol, Map<String,String> params){
        mRetroAdapter.getRecentTrades(symbol, params, new Callback<TradeResponse>() {
            @Override
            public void success(TradeResponse trades, Response response) {
                for(Trade t:trades.getTrades()){
                    Log.d(DEBUG,"recent "+t.toString());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }



    }



