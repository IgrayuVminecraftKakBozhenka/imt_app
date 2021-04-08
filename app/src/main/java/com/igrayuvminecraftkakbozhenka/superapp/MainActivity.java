package com.igrayuvminecraftkakbozhenka.superapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText highInput;
    private EditText weightInput;
    public final static String INTENT_KEY_HIGH = "intent_key_high";
    public final static String INTENT_KEY_WEIGHT = "intent_key_weight";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highInput = findViewById(R.id.main_activity_enter_ur_high);
        weightInput = findViewById(R.id.main_activity_enter_ur_weight);

        final Button okButton = findViewById(R.id.main_activity_ok_button);
        okButton.setOnClickListener(this);
        highInput.requestFocus();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.main_activity_ok_button):
                okClick();
                break;
        }

    }

    private void okClick() {
        final String userHigh = highInput.getText().toString();
        final String userWeight = weightInput.getText().toString();
        if (userHigh.isEmpty() | userWeight.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.exception_empty_input, Toast.LENGTH_SHORT).show();
        } else {
            final Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(INTENT_KEY_HIGH, userHigh);
            intent.putExtra(INTENT_KEY_WEIGHT, userWeight);
            startActivity(intent);
        }
    }
}