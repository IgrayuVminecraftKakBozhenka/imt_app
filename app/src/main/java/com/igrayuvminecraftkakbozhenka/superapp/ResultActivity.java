package com.igrayuvminecraftkakbozhenka.superapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView recomendation;
    private TextView imt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        double high = Double.parseDouble(getIntent().getStringExtra(MainActivity.INTENT_KEY_HIGH));
        double weigh = Double.parseDouble(getIntent().getStringExtra(MainActivity.INTENT_KEY_WEIGHT));

        recomendation = findViewById(R.id.result_activity_recomendation);
        imt = findViewById(R.id.result_activity_imt);



        imt.setText(Double.toString(getImt(high, weigh)));

    }

    private double getImt(double high, double weigh) {
        high = high / 100;
        double result = weigh / (high * high);
        return result;
    }
}
