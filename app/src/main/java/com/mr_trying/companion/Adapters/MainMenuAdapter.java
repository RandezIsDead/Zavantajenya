package com.mr_trying.companion.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mr_trying.companion.R;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder> {

    private final Context context;

    public MainMenuAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_vertical_pt1, parent, false));
        else return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_vertical_pt2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0) {

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 0;
        else return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView journal;
        public ImageView translator;
        public ImageView bonus;
        public ImageView bank;
        public ImageView fromWindow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            journal = itemView.findViewById(R.id.journal);
            translator = itemView.findViewById(R.id.translator);
            bonus = itemView.findViewById(R.id.rjd_bonus);
            bank = itemView.findViewById(R.id.pricing);
            fromWindow = itemView.findViewById(R.id.russia_from_window);
        }
    }
}
