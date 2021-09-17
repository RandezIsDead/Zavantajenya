package com.mr_trying.companion.Adapters;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mr_trying.companion.Activities.SecondaryActivities.AudiobooksActivity;
import com.mr_trying.companion.Activities.SecondaryActivities.WebActivity;
import com.mr_trying.companion.R;

public class LuxAdapter extends RecyclerView.Adapter<LuxAdapter.ViewHolder> {

    private final Context context;

    public LuxAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_lux, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.audiobook.setOnClickListener(v -> {
            Intent intent = new Intent(context, AudiobooksActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
        });
        holder.cinema.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
        });
        holder.books.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
        });
        holder.music.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
        });
        holder.net.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout audiobook;
        public RelativeLayout cinema;
        public RelativeLayout books;
        public RelativeLayout music;
        public RelativeLayout net;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            audiobook = itemView.findViewById(R.id.audiobook_rel);
            cinema = itemView.findViewById(R.id.cinema_rel);
            books = itemView.findViewById(R.id.books_rel);
            music = itemView.findViewById(R.id.music_rel);
            net = itemView.findViewById(R.id.net_rel);
        }
    }
}
