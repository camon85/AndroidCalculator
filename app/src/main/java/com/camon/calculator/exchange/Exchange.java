package com.camon.calculator.exchange;

import java.math.BigDecimal;

/**
 * Created by camon on 2016-01-13.
 */
public class Exchange {
    private static String nationName;
    private static BigDecimal currency;

    public Exchange() {
    }

    public Exchange(String nationName, BigDecimal currency) {
        this.nationName = nationName;
        this.currency = currency;
    }

    public BigDecimal convertKRW(BigDecimal source) {
        return source.multiply(currency);
    }

}
