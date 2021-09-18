package com.mr_trying.companion.Activities.SecondaryActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.mr_trying.companion.Adapters.FlightAdapter;
import com.mr_trying.companion.Adapters.ItemAdapter;
import com.mr_trying.companion.Data.Constants;
import com.mr_trying.companion.Data.RequestHandler;
import com.mr_trying.companion.Models.Flight;
import com.mr_trying.companion.Models.Item;
import com.mr_trying.companion.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);

        List<Flight> flightList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getFlights(getApplicationContext(), recyclerView, flightList);

        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    public static void getFlights(Context context, RecyclerView recyclerView, List<Flight> flightList) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_GET_FLIGHTS,
                response -> {
                    flightList.clear();
                    try {
                        JSONArray array = new JSONArray(response);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);

                            flightList.add(new Flight(
                                    object.getString("flightNum"),
                                    object.getString("fromStation"),
                                    object.getString("toStation"),
                                    object.getString("sendingDate"),
                                    object.getString("arrivalDate"),
                                    object.getString("startLat"),
                                    object.getString("startLng"),
                                    object.getString("endLat"),
                                    object.getString("endLng")
                            ));
                        }

                        recyclerView.setAdapter(new FlightAdapter(context, flightList));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                System.out::println)
        {
            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }
        };

        RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
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