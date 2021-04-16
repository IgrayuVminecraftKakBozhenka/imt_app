package com.igrayuvminecraftkakbozhenka.superapp.ui.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.igrayuvminecraftkakbozhenka.superapp.R;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter {

    private final List<String> names;

    public CustomRecyclerAdapter(List<String> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    //----------------------------------------------------------------------------------------------
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView high;
        TextView weigh;
        TextView imt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recycler_view_text_view_name);
            high = itemView.findViewById(R.id.recycler_view_text_view_high);
            weigh = itemView.findViewById(R.id.recycler_view_text_view_weigh);
            imt = itemView.findViewById(R.id.recycler_view_text_view_imt);
        }
    }
}
