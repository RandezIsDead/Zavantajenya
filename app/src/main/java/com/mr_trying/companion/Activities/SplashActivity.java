package com.mr_trying.companion.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mr_trying.companion.Data.Prefs;
import com.mr_trying.companion.R;

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
        System.out.println(Prefs.read(getApplicationContext(), "loggedIn"));
        if (Prefs.read(getApplicationContext(), "loggedIn") == null) {
            startActivity(new Intent(getApplicationContext(), AuthActivity.class));
        } else {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        overridePendingTransition(0,0);
    }
}