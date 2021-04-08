package com.igrayuvminecraftkakbozhenka.superapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public final class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView recomendation;
    private TextView tvImt;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        final double high = getInitialValue(MainActivity.INTENT_KEY_HIGH);
        final double weigh = getInitialValue(MainActivity.INTENT_KEY_WEIGHT);
        final double imt = getImt(high, weigh);
        final String imtString = Double.toString(imt);
        recomendation = findViewById(R.id.result_activity_recomendation);
        tvImt = findViewById(R.id.result_activity_imt);
        tvImt.setText(imtString);
        recomendation.setText(getEvaluation(imt));
        backButton = findViewById(R.id.result_activity_back_button);
        backButton.setOnClickListener(this);
    }

    private double getInitialValue(final String key) {
        final Intent intent = getIntent();
        if (intent == null) {
            return 0.0;
        }
        final String value = intent.getStringExtra(key);
        if (value == null) {
            return 0.0;
        }
        double doubleValue = 0.0;
        try {
            doubleValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return doubleValue;
    }

    private double getImt(final double high, final double weigh) {
        final double highMeter = high / 100;
        return weigh / (highMeter * highMeter);
    }

    private String getEvaluation(double imt) {
        String recomend = "";
        if (imt < 16) {
            recomend = "Сильный дефицит массы тела, срочно обратитесь к врачу";
        } else if (imt >= 16.0 && imt <= 18.5) {
            recomend = "Сильный дефицит массы тела, рекомендуется диета";
        } else if (imt > 18.5 && imt <= 24.99) {
            recomend = "Нормальная масса тела, рекомендуется регулярные занятия спортом";
        } else if (imt >= 25 && imt <= 30) {
            recomend = "Предожирение, рекомендуется диета и занятия спортом";
        } else if (imt > 30 && imt <= 35) {
            recomend = "Ожирение первой степени, обратитесь к врачу, рекомендуется диета и занятия спортом";
        } else if (imt > 35 && imt <= 40) {
            recomend = "Ожирение второй степени, обратитесь к врачу, рекомендуется диета и занятия спортом";
        } else if (imt > 40) {
            recomend = "Ожирение третьей степени, вы вообще передвигаетесь?";
        }
        return recomend;
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
