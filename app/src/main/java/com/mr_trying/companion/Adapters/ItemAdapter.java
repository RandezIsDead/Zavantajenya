package com.mr_trying.companion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mr_trying.companion.Data.Prefs;
import com.mr_trying.companion.Models.Item;
import com.mr_trying.companion.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final Context context;
    private final List<Item> items;
    private final boolean isCart;

    public ItemAdapter(Context context, List<Item> items, boolean isCart) {
        this.context = context;
        this.items = items;
        this.isCart = isCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.goods_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);

        if (!item.getImageUrl().equals("default"))
            Glide.with(context).load(item.getImageUrl()).into(holder.image);
        holder.name.setText(item.getName());
        holder.cost.setText(item.getCost());

        if (isCart) holder.addToCart.setVisibility(View.GONE);

        holder.addToCart.setOnClickListener(v -> {
            List<Item> itemsList = Prefs.getItems(context);
            itemsList.add(item);
            Prefs.saveItems(context, itemsList);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name;
        public TextView cost;
        public RelativeLayout addToCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            cost = itemView.findViewById(R.id.item_cost);
            addToCart = itemView.findViewById(R.id.add_to_cart);
        }
    }
}
