package com.igrayuvminecraftkakbozhenka.superapp.ui.history;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.igrayuvminecraftkakbozhenka.superapp.R;
import com.igrayuvminecraftkakbozhenka.superapp.data.ImtRepository;
import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.ArrayList;
import java.util.List;

public final class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    CustomRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final Button backButton = findViewById(R.id.activity_table_back_button);
        backButton.setOnClickListener(this);

        final Button clearButton = findViewById(R.id.activity_table_clear_button);
        clearButton.setOnClickListener(this);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ImtRepository imtRepository = new ImtRepository(getApplicationContext());
        adapter = new CustomRecyclerAdapter(imtRepository.getAllResults());
        recyclerView.setAdapter(adapter);

        ImtModel imtModel = new ImtModel("xyi", "120", "50", "23");
        imtRepository.saveResult(imtModel);
        adapter.notifyItemInserted(3);
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
