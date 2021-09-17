package com.mr_trying.companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        Runnable runnable = this::changeScreen;
        handler.postDelayed(runnable, 2000);
    }

    private void changeScreen() {
        startActivity(new Intent(getApplicationContext(), AuthActivity.class));
        overridePendingTransition(0,0);
    }
}