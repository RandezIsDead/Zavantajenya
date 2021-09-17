package com.mr_trying.companion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mr_trying.companion.R;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHoder> {

    private final Context context;

    public MainMenuAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) return new ViewHoder(LayoutInflater.from(context).inflate(R.layout.menu_vertical_pt1, parent, false));
        else return new ViewHoder(LayoutInflater.from(context).inflate(R.layout.menu_vertical_pt2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

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

    public static class ViewHoder extends RecyclerView.ViewHolder {

        public ImageView journal;
        public ImageView translator;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
