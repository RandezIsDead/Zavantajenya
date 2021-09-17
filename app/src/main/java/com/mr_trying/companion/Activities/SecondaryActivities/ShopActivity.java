package com.mr_trying.companion.Activities.SecondaryActivities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.mr_trying.companion.Adapters.ItemAdapter;
import com.mr_trying.companion.Data.Constants;
import com.mr_trying.companion.Data.DbHelper;
import com.mr_trying.companion.Data.RequestHandler;
import com.mr_trying.companion.Models.Item;
import com.mr_trying.companion.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);
        DbHelper.getShopItems(getApplicationContext(), findViewById(R.id.recycler_view), "true");

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