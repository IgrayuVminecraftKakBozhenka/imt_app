package com.igrayuvminecraftkakbozhenka.superapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.igrayuvminecraftkakbozhenka.superapp.data.ImtRepository;

import java.util.Map;

public final class TableActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_result);

        final Button backButton = findViewById(R.id.activity_table_back_button);
        backButton.setOnClickListener(this);

        final Button clearButton = findViewById(R.id.activity_table_clear_button);
        clearButton.setOnClickListener(this);

        ImtRepository imtRepository = new ImtRepository(getApplicationContext());
        final Map<String, ?> result = imtRepository.getResult();

        String resultString = (String) result.get("name");
        String[] resultToTable = resultString.split(",");

        TextView firstCell = findViewById(R.id.activity_table_one_cell);
        TextView secondCell = findViewById(R.id.activity_table_two_cell);
        TextView thirdCell = findViewById(R.id.activity_table_three_cell);
        TextView fourCell = findViewById(R.id.activity_table_four_cell);

        firstCell.setText(resultToTable[0]);
        secondCell.setText(resultToTable[1]);
        thirdCell.setText(resultToTable[2]);
        fourCell.setText(resultToTable[3]);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_table_back_button:
                finish();
                break;
            case R.id.activity_table_clear_button:
                ImtRepository imtRepository = new ImtRepository(getApplicationContext());
                imtRepository.clearRepository();
        }
    }
}
