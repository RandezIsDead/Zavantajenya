package com.mr_trying.companion.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.mr_trying.companion.Adapters.LuxAdapter;
import com.mr_trying.companion.R;

public class LuxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new LuxAdapter(getApplicationContext()));
        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }
}