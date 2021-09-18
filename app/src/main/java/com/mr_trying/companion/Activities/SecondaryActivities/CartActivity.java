package com.mr_trying.companion.Activities.SecondaryActivities;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.mr_trying.companion.Adapters.ItemAdapter;
import com.mr_trying.companion.Data.Prefs;
import com.mr_trying.companion.Models.Item;
import com.mr_trying.companion.R;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> items;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        items = Prefs.getItems(getApplicationContext());

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items, true));

        update();

        ImageView close = findViewById(R.id.close);
        AppCompatButton confirm = findViewById(R.id.conform_cart);
        AppCompatButton clear = findViewById(R.id.clear_cart);
        close.setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
        confirm.setOnClickListener(v -> {
            if (items.size() > 0) {
                Dialog dialogWindow = new Dialog(v.getRootView().getContext());

                dialogWindow.setContentView(R.layout.alert_two_elements);
                dialogWindow.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button conf = dialogWindow.findViewById(R.id.edit_message);
                Button cancel = dialogWindow.findViewById(R.id.remove_message);

                dialogWindow.show();

                conf.setOnClickListener(v1 -> {
                    //TODO: add queue to database
                    Prefs.saveItems(getApplicationContext(), null);
                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), Prefs.getItems(getApplicationContext()), true));
                    Snackbar.make(v, "Заказ подтверждён, ожидайте", Snackbar.LENGTH_SHORT).show();
                    dialogWindow.dismiss();
                });

                cancel.setOnClickListener(v1 -> dialogWindow.dismiss());
            } else Snackbar.make(v, "Корзина пуста", Snackbar.LENGTH_SHORT).show();
        });
        clear.setOnClickListener(v -> {
            Dialog dialogWindow = new Dialog(v.getRootView().getContext());

            dialogWindow.setContentView(R.layout.alert_two_elements);
            dialogWindow.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            Button conf = dialogWindow.findViewById(R.id.edit_message);
            Button cancel = dialogWindow.findViewById(R.id.remove_message);

            dialogWindow.show();

            conf.setOnClickListener(v1 -> {
                Prefs.saveItems(getApplicationContext(), null);
                recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), Prefs.getItems(getApplicationContext()), true));
                Snackbar.make(v, "Корзина очищена", Snackbar.LENGTH_SHORT).show();
                dialogWindow.dismiss();
            });

            cancel.setOnClickListener(v1 -> dialogWindow.dismiss());
        });
    }

    private void update() {
        Runnable runnable = this::update;

        List<Item> itemList = Prefs.getItems(getApplicationContext());
        if (itemList.size() != items.size()) {
            items = itemList;
            recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items, true));
        }
        handler.postDelayed(runnable, 1000);
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