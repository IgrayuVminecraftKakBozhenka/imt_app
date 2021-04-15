package com.igrayuvminecraftkakbozhenka.superapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.igrayuvminecraftkakbozhenka.superapp.data.ImtRepository;

import java.util.Map;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_result);

        ImtRepository imtRepository = new ImtRepository(getApplicationContext());
        final Map<String, ?> result = imtRepository.getResult();
        String resultString = "";
        resultString += result.get("name");

        TextView textViewResult = findViewById(R.id.activity_table_result_string);
        textViewResult.setText(resultString);
    }
}
