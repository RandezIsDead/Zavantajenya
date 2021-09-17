package com.mr_trying.companion.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
        else if (viewType == 1) return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_vertical_pt2, parent, false));
        else return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_vertical_pt3, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0) {

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 0;
        else if (position == 1) return 1;
        else return 2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout journal;
        public RelativeLayout translator;

        public RelativeLayout timing;
        public RelativeLayout map;
        public RelativeLayout shop;
        public RelativeLayout rest;

        public RelativeLayout bonus;
        public RelativeLayout bank;
        public RelativeLayout fromWindow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            journal = itemView.findViewById(R.id.journal_rel);
            translator = itemView.findViewById(R.id.translator_rel);

            timing = itemView.findViewById(R.id.timings_rel);
            map = itemView.findViewById(R.id.map_rel);
            shop = itemView.findViewById(R.id.shop_rel);
            rest = itemView.findViewById(R.id.rest_rel);

            bonus = itemView.findViewById(R.id.bonus_rel);
            bank = itemView.findViewById(R.id.bank_rel);
            fromWindow = itemView.findViewById(R.id.russia_from_window_rel);
        }
    }
}
