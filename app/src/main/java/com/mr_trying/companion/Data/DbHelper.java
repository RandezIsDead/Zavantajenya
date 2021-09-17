package com.mr_trying.companion.Data;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.mr_trying.companion.Adapters.ItemAdapter;
import com.mr_trying.companion.Models.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbHelper {

    public static void getShopItems(Context context, RecyclerView recyclerView, String param) {
        List<Item> items = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_GET_ITEMS,
                response -> {
                    try {
                        System.out.println(response);
                        JSONArray array = new JSONArray(response);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);

                            items.add(new Item(
                                    object.getString("imageUrl"),
                                    object.getString("name"),
                                    object.getString("cost")
                            ));
                        }

                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                        recyclerView.setAdapter(new ItemAdapter(context, items));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                System.out::println)
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("isShop", param);

                return params;
            }
        };

        RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
    }
}
