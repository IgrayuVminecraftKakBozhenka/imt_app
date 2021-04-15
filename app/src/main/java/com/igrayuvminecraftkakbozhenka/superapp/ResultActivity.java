package com.igrayuvminecraftkakbozhenka.superapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public final class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final double high = getInitialValue(MainActivity.INTENT_KEY_HIGH);
        final double weigh = getInitialValue(MainActivity.INTENT_KEY_WEIGHT);
        final String name = getIntent().getStringExtra(MainActivity.INTENT_KEY_NAME);
        final double imt = getImt(high, weigh);
        final String imtString = Double.toString(imt);

        final TextView recomendation = findViewById(R.id.result_activity_recomendation);
        recomendation.setText(getEvaluation(imt));

        final TextView tvImt = findViewById(R.id.result_activity_imt);
        tvImt.setText(imtString);

        final Button backButton = findViewById(R.id.result_activity_back_button);
        backButton.setOnClickListener(this);

        final Button resultTableButton = findViewById(R.id.activity_result_table_result_button);
        resultTableButton.setOnClickListener(this);

        resultImage = findViewById(R.id.activity_result_image);
        setImageAfterResult(imt);

        //ImtRepository save = new ImtRepository(name, Double.toString(high), Double.toString(weigh), imtString, getApplicationContext());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.result_activity_back_button:
                finish();
                break;
            case R.id.activity_result_table_result_button:
                Intent intent = new Intent(this, TableActivity.class);
                //intent.putExtra(MainActivity.INTENT_KEY_STORAGE, );
                //intent.put
                startActivity(intent);
                break;
        }
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

    private int getEvaluation(double imt) {
        int recomend = 0;
        if (imt < 16) {
            recomend = R.string.strong_deficite;
        } else if (imt >= 16.0 && imt <= 18.5) {
            recomend = R.string.deficite;
        } else if (imt > 18.5 && imt <= 24.99) {
            recomend = R.string.normal;
        } else if (imt >= 25 && imt <= 30) {
            recomend = R.string.oversize;
        } else if (imt > 30 && imt <= 35) {
            recomend = R.string.fat;
        } else if (imt > 35 && imt <= 40) {
            recomend = R.string.too_fat;
        } else if (imt > 40) {
            recomend = R.string.super_fat;
        }
        return recomend;
    }

    private void setImageAfterResult(final double imt) {
        if (imt < 16) {
            resultImage.setImageResource(R.drawable.darkholm);
        } else if (imt >= 16.0 && imt <= 18.5) {
            resultImage.setImageResource(R.drawable.doge);
        } else if (imt > 18.5 && imt <= 24.99) {
            resultImage.setImageResource(R.drawable.chims);
        } else if (imt >= 25 && imt <= 30) {
            resultImage.setImageResource(R.drawable.thor);
        } else if (imt > 30 && imt <= 35) {
            resultImage.setImageResource(R.drawable.thor);
        } else if (imt > 35 && imt <= 40) {
            resultImage.setImageResource(R.drawable.thor);
        } else if (imt > 40) {
            resultImage.setImageResource(R.drawable.thor);
        }
    }


}
