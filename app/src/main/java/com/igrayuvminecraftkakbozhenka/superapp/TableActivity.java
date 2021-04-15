package com.igrayuvminecraftkakbozhenka.superapp;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.igrayuvminecraftkakbozhenka.superapp.data.ImtRepository;

import java.util.ArrayList;
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

        int columns = 4;
        int rows = resultToTable.length / 4;
        int iterator = 0;
        TableLayout table = findViewById(R.id.activity_table_table_layout);

        for (int i = 0; i < rows; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < columns; j++) {
                TextView cell = new TextView(this);
                cell.setText(resultToTable[iterator]);
                tableRow.addView(cell, j);
                iterator++;
            }
            table.addView(tableRow, i);
        }


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
