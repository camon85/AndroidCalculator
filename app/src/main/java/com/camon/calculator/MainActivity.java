package com.camon.calculator;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.camon.calculator.exchange.Exchange;
import com.camon.calculator.exchange.ExchangeDataReceiver;
import com.camon.calculator.exchange.ExchangeParser;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSource;
    private TextView tvTarget;
    private TextView tvCurrencyInfo;
    private TextView tvCurrencyDate;
    private Button btnSourceExchangeText;
    private static Exchange exchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        ExchangeDataReceiver exchangeDataReceiver = new ExchangeDataReceiver();
        AsyncTask<String, Void, String> htmlResponse = exchangeDataReceiver.execute();

        try {
            // TODO null  처리 ??
            String html = htmlResponse.get();
            ExchangeParser exchangeParser = new ExchangeParser(html);
            tvCurrencyDate.setText("기준일: " + exchangeParser.getRegDate());
            Map<String, BigDecimal> currencyMap = exchangeParser.makeCurrencyMap();

            // TODO 국가 list 볼수있게 만들기
            String nationName = "미국 USD";
            BigDecimal currency = currencyMap.get(nationName);
            tvCurrencyInfo.setText(nationName + ": " + currency + " KRW");
            btnSourceExchangeText.setText(nationName);
            Log.d("htmlResponse", html);

            // 선택된 국가 환율 생성
            exchange = new Exchange(nationName, currency);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_1:
                tvSource.append("1");
                break;
            case R.id.btn_2:
                tvSource.append("2");
                break;
            case R.id.btn_3:
                tvSource.append("3");
                break;
            case R.id.btn_4:
                tvSource.append("4");
                break;
            case R.id.btn_5:
                tvSource.append("5");
                break;
            case R.id.btn_6:
                tvSource.append("6");
                break;
            case R.id.btn_7:
                tvSource.append("7");
                break;
            case R.id.btn_8:
                tvSource.append("8");
                break;
            case R.id.btn_9:
                tvSource.append("9");
                break;
            case R.id.btn_0:
                tvSource.append("0");
                break;
            case R.id.btn_00:
                tvSource.append("00");
                break;
            case R.id.btn_000:
                tvSource.append("000");
                break;
            case R.id.btn_backspace:
                CharSequence text = tvSource.getText();
                int length = text.length();
                if (length > 0) {
                    String substring = text.toString().substring(0, length - 1);
                    tvSource.setText(substring);
                }
                break;
            case R.id.btn_clear:
                tvSource.setText("");
                break;
            case R.id.btn_calculate:
                BigDecimal source = new BigDecimal(tvSource.getText().toString());
                // TODO ### 포매팅
                tvTarget.setText(exchange.convertKRW(source).toString());
                break;
            default:

        }
    }

    private void initComponents() {
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_00).setOnClickListener(this);
        findViewById(R.id.btn_000).setOnClickListener(this);
        findViewById(R.id.btn_backspace).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_calculate).setOnClickListener(this);

        tvSource = (TextView) findViewById(R.id.sourceExchange);
        tvTarget = (TextView) findViewById(R.id.targetExchange);
        tvCurrencyInfo = (TextView) findViewById(R.id.currencyInfo);
        tvCurrencyDate = (TextView) findViewById(R.id.currencyDate);
        btnSourceExchangeText = (Button) findViewById(R.id.sourceExchangeText);
    }
}
