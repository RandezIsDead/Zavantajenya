package com.mr_trying.companion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mr_trying.companion.Models.Item;
import com.mr_trying.companion.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final Context context;
    public final List<Item> items;

    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.goods_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);

        if (!item.getImageUrl().equals("default")) {
            Glide.with(context).load(item.getImageUrl()).into(holder.image);
        }
        holder.name.setText(item.getName());
        holder.cost.setText(item.getCost());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name;
        public TextView cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            cost = itemView.findViewById(R.id.item_cost);
        }
    }
}
