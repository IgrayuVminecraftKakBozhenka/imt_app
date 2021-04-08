package com.igrayuvminecraftkakbozhenka.superapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final EditText highInput = findViewById(R.id.main_activity_enter_ur_high);
    final EditText weightInput = findViewById(R.id.main_activity_enter_ur_weight);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button okButton = findViewById(R.id.main_activity_ok_button);
        okButton.setOnClickListener(this);
        final EditText highInput = findViewById(R.id.main_activity_enter_ur_high);
        final EditText weightInput = findViewById(R.id.main_activity_enter_ur_weight);
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
    }
}