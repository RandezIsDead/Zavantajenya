package com.mr_trying.companion.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mr_trying.companion.Adapters.MainMenuAdapter;
import com.mr_trying.companion.R;

public class MainActivity extends AppCompatActivity {

    boolean isMoreOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MainMenuAdapter(getApplicationContext()));

        ImageView more = findViewById(R.id.more);
        RelativeLayout moreRel = findViewById(R.id.more_lay);
        more.setOnClickListener(v -> {
            if (isMoreOpened) {
                isMoreOpened = false;
                moreRel.setVisibility(View.GONE);
            } else {
                isMoreOpened = true;
                moreRel.setVisibility(View.VISIBLE);
            }
        });

        RelativeLayout toVip = findViewById(R.id.r1);
        RelativeLayout feedback = findViewById(R.id.r2);

        toVip.setOnClickListener(v -> {
            moreRel.setVisibility(View.GONE);
            startActivity(new Intent(getApplicationContext(), LuxActivity.class));
            overridePendingTransition(0, 0);
        });
    }
}