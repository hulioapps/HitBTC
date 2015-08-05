package com.apps.hulios.hitbtc.ResponseObjects;

import java.util.List;

/**
 * Created by Boss on 2015-07-29.
 */
public class SymbolsResponse {
    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    List<Symbol> symbols;
}
