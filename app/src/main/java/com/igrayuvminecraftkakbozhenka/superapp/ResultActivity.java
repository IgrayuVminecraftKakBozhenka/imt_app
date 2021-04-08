package com.igrayuvminecraftkakbozhenka.superapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView recomendation;
    private TextView imt;
    private Button backButton;

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
        backButton = findViewById(R.id.result_activity_back_button);
        backButton.setOnClickListener(this);


    }

    private double getImt(double high, double weigh) {
        high = high / 100;
        double result = weigh / (high * high);
        return result;
    }

    private String getEvaluation(double imt) {
        String recomend;
        if (imt < 16) {
            recomend = "Сильный дефицит массы тела, срочно обратитесь к врачу";
            return recomend;
        } else if (imt > 16.0 && imt < 18.5) {
            recomend = "Сильный дефицит массы тела, рекомендуется диета";
            return recomend;
        } else if (imt > 18.5 && imt < 24.99) {
            recomend = "Нормальная масса тела, рекомендуется регулярные занятия спортом";
            return recomend;
        } else if (imt > 25 && imt < 30) {
            recomend = "Предожирение, рекомендуется диета и занятия спортом";
            return recomend;
        } else if (imt > 30 && imt < 35) {
            recomend = "Ожирение первой степени, обратитесь к врачу, рекомендуется диета и занятия спортом";
            return recomend;
        } else if (imt > 35 && imt < 40) {
            recomend = "Ожирение второй степени, обратитесь к врачу, рекомендуется диета и занятия спортом";
            return recomend;
        } else if (imt > 40) {
            recomend = "Ожирение третьей степени, вы вообще передвигаетесь?";
            return recomend;
        }
        return "";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.result_activity_back_button:
                finish();
                break;
        }
    }
}
