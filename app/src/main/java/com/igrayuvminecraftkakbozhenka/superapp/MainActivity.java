package com.igrayuvminecraftkakbozhenka.superapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button okButton = findViewById(R.id.main_activity_ok_button);
        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.main_activity_ok_button):
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
        }

    }
}