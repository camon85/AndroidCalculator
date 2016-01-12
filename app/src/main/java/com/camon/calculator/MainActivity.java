package com.camon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTarget;
    private static int clickCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);

        tvTarget = (TextView) findViewById(R.id.targetExchange);
    }

    @Override
    public void onClick(View v) {
        tvTarget.setText("count: " + clickCount++);
    }
}
