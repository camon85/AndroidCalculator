package com.camon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tvSource;
    private EditText tvTarget;

    private static int clickCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
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
                tvTarget.setText("count: " + clickCount++);
                break;
            default:

        }

        int textLength = tvSource.getText().length();
        tvSource.setSelection(textLength);
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

        tvSource = (EditText) findViewById(R.id.sourceExchange);
        tvTarget = (EditText) findViewById(R.id.targetExchange);
    }
}
