package com.camon.calculator.exchange;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by camon on 2016-01-17.
 */
public class ExchangeDataReceiver extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        String response = "";

        try {
            // TODO 여기서 통신 실패면 어떻게 되지?
            Document doc = Jsoup.connect("http://fx.keb.co.kr/FER1101C.web?schID=fex&mID=FER1101C").get();
            response = doc.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
