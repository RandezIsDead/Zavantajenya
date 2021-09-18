package com.mr_trying.companion.Activities.SecondaryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.mr_trying.companion.R;

public class JournalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        TextView flight_number = findViewById(R.id.flight_number);
        TextView car_number = findViewById(R.id. car_number);
        TextView seat_number = findViewById(R.id.seat_number);
        TextView from_station = findViewById(R.id.from_station);
        TextView to_station = findViewById(R.id.to_station);
        TextView arrival_time = findViewById(R.id.arrival_time);
        TextView sending_time = findViewById(R.id.sending_time);
        TextView passenger_status = findViewById(R.id.passenger_status);
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