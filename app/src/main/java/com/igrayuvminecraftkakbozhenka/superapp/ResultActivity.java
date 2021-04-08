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
        recomendation.setText(getEvaluation(getImt(high, weigh)));


    }

    private double getImt(double high, double weigh) {
        high = high / 100;
        double result = weigh / (high * high);
        return result;
    }

    private String getEvaluation(double imt) {
        String recomend;
        if (imt < 16) {
            recomend = "Сильный дефицит массы тела";
            return recomend;
        } else if (imt > 16.0 && imt < 18.5) {
            recomend = "Сильный дефицит массы тела";
            return recomend;
        } else if (imt > 18.5 && imt < 24.99) {
            recomend = "Нормальная масса тела";
            return recomend;
        } else if (imt > 25 && imt < 30) {
            recomend = "Предожирение";
            return recomend;
        } else if (imt > 30 && imt < 35) {
            recomend = "Ожирение первой степени";
            return recomend;
        } else if (imt > 35 && imt < 40) {
            recomend = "Ожирение второй степени";
            return recomend;
        } else if (imt > 40) {
            recomend = "Ожирение третьей степени";
            return recomend;
        }
        return "";
    }

}
