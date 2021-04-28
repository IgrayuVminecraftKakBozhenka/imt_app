package com.igrayuvminecraftkakbozhenka.superapp.ui.history;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.igrayuvminecraftkakbozhenka.superapp.R;
import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.List;

public final class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    private List<ImtModel> names;

    public void customRecyclerAdapter(List<ImtModel> names) {
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

    @Override
    public void onViewRecycled(@NonNull MyViewHolder holder) {
        super.onViewRecycled(holder);

        Log.d("Logd", "onViewRecycled");
        holder.printInfo();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        Log.d("Logd", "onViewDetachedFromWindow");
        holder.printInfo();
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

        void printInfo() {
            Log.d("Logd", "Card " + name.getText());
        }

        void bind(final ImtModel imtModel) {
            final String strHigh = Double.toString(imtModel.getHigh());
            final String strWeigh = Double.toString(imtModel.getWeigh());
            final String strImt = Double.toString(imtModel.getImt());
            name.setText(imtModel.getName());
            high.setText(strHigh);
            weigh.setText(strWeigh);
            imt.setText(strImt);
            final int color = Color.rgb(0, 153, 0);
            final double doubleImt = imtModel.getImt();
            if (doubleImt > 18.5 && doubleImt < 24.99) {
                background.setCardBackgroundColor(color);
            } else {
                final int colour = Color.rgb(255, 0, 0);
                background.setCardBackgroundColor(colour);
            }
        }
    }
}
