package com.camon.calculator.exchange;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by camon on 2016-01-13.
 */
public class Exchange {

    private static Document doc;

    public Exchange() {
    }

    public Exchange(String html) {
        doc = Jsoup.parse(html);
    }

    public String getRegDate() throws IOException {
        Element body = doc.body();
        return body.select("#regdt").text();
    }

    public Map<String, BigDecimal> makeCurrencyMap() throws IOException {
        Element body = doc.body();
        Elements table = body.select("#printArea");
        System.out.println(body.select("#regdt").text()); // 기준일
        Elements tbody = table.select("tbody");
        Elements tr = tbody.select("tr");
        tr.remove(0); // 테이블 헤더 제거1
        tr.remove(0); // 테이블 헤더 제거2

        Map<String, BigDecimal> currencyMap = new HashMap<>();

        for (Element element : tr) {
            String nationName = element.select("a").text(); // 유럽연합 EUR
            String price = element.child(9).text(); // 매매기준율 -> "100" 으로 끝나는지 구분
            currencyMap.put(nationName, new BigDecimal(price));
        }

        for (String key : currencyMap.keySet()) {
            Log.d("Exchange", key + "-> " + currencyMap.get(key) + " KRW");
            System.out.println();
        }

        return currencyMap;
    }
}
