package com.mr_trying.companion.Activities.SecondaryActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.mr_trying.companion.Adapters.FlightAdapter;
import com.mr_trying.companion.Data.Constants;
import com.mr_trying.companion.Data.Prefs;
import com.mr_trying.companion.Data.RequestHandler;
import com.mr_trying.companion.Models.Flight;
import com.mr_trying.companion.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JournalActivity extends AppCompatActivity {

    private TextView flight_number;
    private TextView car_number;
    private TextView seat_number;
    private TextView from_station;
    private TextView to_station;
    private TextView arrival_time;
    private TextView sending_time;
    private TextView passenger_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        flight_number = findViewById(R.id.flight_number);
        car_number = findViewById(R.id. car_number);
        seat_number = findViewById(R.id.seat_number);
        from_station = findViewById(R.id.from_station);
        to_station = findViewById(R.id.to_station);
        arrival_time = findViewById(R.id.arrival_time);
        sending_time = findViewById(R.id.sending_time);
        passenger_status = findViewById(R.id.passenger_status);

        getFlight(getApplicationContext());

        ImageView close = findViewById(R.id.close);
        close.setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    private void getFlight(Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_GET_FLIGHT_BY_NUMBER,
                response -> {
                    try {
                        JSONArray array = new JSONArray(response);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);

                            flight_number.setText(object.getString("flightNum"));
                            from_station.setText(object.getString("fromStation"));
                            to_station.setText(object.getString("toStation"));
                            sending_time.setText(object.getString("sendingDate"));
                            arrival_time.setText(object.getString("arrivalDate"));
                            car_number.setText(Prefs.read(context, "vagon"));
                            seat_number.setText(Prefs.read(context, "seat"));
                            passenger_status.setText(Prefs.read(context, "luxStatus"));

                            Prefs.write(context, "st", object.getString("startLat"));
                            Prefs.write(context, "sg", object.getString("startLng"));
                            Prefs.write(context, "et", object.getString("endLat"));
                            Prefs.write(context, "eg", object.getString("endLng"));

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                System.out::println)
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("flightNum", Prefs.read(context, "flightNum"));

                return params;
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