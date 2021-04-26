package com.igrayuvminecraftkakbozhenka.superapp.ui.history;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.igrayuvminecraftkakbozhenka.superapp.R;
import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.List;

public final class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    private List<ImtModel> names;

    public void CustomRecyclerAdapter(List<ImtModel> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(itemView);
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.MyViewHolder holder, final int position) {
        ImtModel imtModel = names.get(position);
        holder.bind(imtModel);
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public int getItemCount() {
        return names.size();
    }

    //----------------------------------------------------------------------------------------------
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView high;
        private final TextView weigh;
        private final TextView imt;
        private final CardView background;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recycler_item_name);
            high = itemView.findViewById(R.id.recycler_item_high);
            weigh = itemView.findViewById(R.id.recycler_item_weigh);
            imt = itemView.findViewById(R.id.recycler_item_imt);
            background = itemView.findViewById(R.id.card_view);

        }

        void bind(final ImtModel imtModel) {
            name.setText(imtModel.getName());
            high.setText(imtModel.getHigh());
            weigh.setText(imtModel.getWeigh());
            imt.setText(imtModel.getImt());
            final int color = Color.rgb(0, 153, 0);
            final double doubleImt = Double.parseDouble(imtModel.getImt());
            if (doubleImt > 18.5 && doubleImt < 24.99) {
                background.setCardBackgroundColor(color);
            }
        }
    }
}
