package com.mr_trying.companion.Activities.SecondaryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mr_trying.companion.Data.TranslatorApi;
import com.mr_trying.companion.R;

public class TranslationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        ImageView swap = findViewById(R.id.swap);
        TextView lang1 = findViewById(R.id.lang1);
        TextView lang2 = findViewById(R.id.lang2);
        EditText text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        Button btnTranslate = findViewById(R.id.btnTranslate);

        btnTranslate.setOnClickListener(view -> {
            TranslatorApi translate=new TranslatorApi();
            translate.setOnTranslationCompleteListener(new TranslatorApi.OnTranslationCompleteListener() {
                @Override
                public void onStartTranslation() {
                }

                @Override
                public void onCompleted(String text) {
                    text2.setText(text);
                }

                @Override
                public void onError(Exception e) {

                }
            });
            translate.execute(text1.getText().toString().trim(), lang1.getText().toString().equals(getResources().getString(R.string.english)) ? "en" : "ru",
                    lang2.getText().toString().equals(getResources().getString(R.string.english)) ? "en" : "ru");
        });
        swap.setOnClickListener(v -> {
            String l1 = lang1.getText().toString();
            String t1 = text1.getText().toString().trim();

            lang1.setText(lang2.getText().toString());
            lang2.setText(l1);
            text1.setText(text2.getText().toString().trim());
            text2.setText(t1);
        });

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