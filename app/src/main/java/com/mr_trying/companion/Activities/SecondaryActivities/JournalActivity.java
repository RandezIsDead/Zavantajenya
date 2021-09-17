package com.mr_trying.companion.Activities.SecondaryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.mr_trying.companion.R;

public class JournalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(0, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}