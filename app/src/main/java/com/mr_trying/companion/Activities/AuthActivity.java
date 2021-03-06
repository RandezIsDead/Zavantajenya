package com.mr_trying.companion.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.snackbar.Snackbar;
import com.mr_trying.companion.Data.Constants;
import com.mr_trying.companion.Data.Prefs;
import com.mr_trying.companion.Data.RequestHandler;
import com.mr_trying.companion.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        AppCompatButton byPass = findViewById(R.id.by_pass);
        AppCompatButton byTicket = findViewById(R.id.by_ticket);
        RelativeLayout passLog = findViewById(R.id.log_by_pass);
        RelativeLayout ticketLog = findViewById(R.id.log_by_ticket);

        EditText pass = findViewById(R.id.pass_et);
        EditText vagon = findViewById(R.id.vagon_et);
        EditText seat = findViewById(R.id.place_et);
        EditText ticket = findViewById(R.id.ticket_et);
        AppCompatButton confirm = findViewById(R.id.confirm_auth);

        byPass.setOnClickListener(v -> {
            passLog.setVisibility(View.VISIBLE);
            ticketLog.setVisibility(View.GONE);

            byPass.setBackgroundResource(R.drawable.auth_method_button_left_red);
            byTicket.setBackgroundResource(R.drawable.auth_method_button_right_white);
            byPass.setTextColor(Color.parseColor("#FFFFFF"));
            byTicket.setTextColor(Color.parseColor("#000000"));
        });
        byTicket.setOnClickListener(v -> {
            passLog.setVisibility(View.GONE);
            ticketLog.setVisibility(View.VISIBLE);

            byPass.setBackgroundResource(R.drawable.auth_method_button_left_white);
            byTicket.setBackgroundResource(R.drawable.auth_method_button_right_red);
            byPass.setTextColor(Color.parseColor("#000000"));
            byTicket.setTextColor(Color.parseColor("#FFFFFF"));
        });

        confirm.setOnClickListener(v -> {
            String passport = pass.getText().toString().trim();
            String vag = vagon.getText().toString().trim();
            String place = seat.getText().toString().trim();
            String tick = ticket.getText().toString().trim();

            if (tick.equals("")) {
                if (passport.equals("") || vag.equals("") || place.equals("")) {
                    Snackbar.make(v, "?????????????? ???? ?????? ????????????", Snackbar.LENGTH_SHORT).show();
                } else {
                    logIn(v, passport, vag, place, tick);
                }
            } else {
                logIn(v, passport, vag, place, tick);
            }
        });
    }

    private void logIn(View v, String pass, String vagon, String seat, String ticket) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_LOGIN,
                response -> {
                    if (response.equals("allowed")) {
                        getLuxStatus(v, pass, vagon, seat, ticket);
                    } else {
                        Snackbar.make(v, "???????????? ?????????????? ??????????????????????", Snackbar.LENGTH_SHORT).show();
                    }
                },
                System.out::println)
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("pass", pass);
                params.put("vagon", vagon);
                params.put("seat", seat);
                params.put("ticket", ticket);

                return params;
            }
        };

        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void getLuxStatus(View v, String pass, String vagon, String seat, String ticket) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_GET_USER_STATUS,
                response -> {
                    try {
                        System.out.println(response);
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);

                            Prefs.write(getApplicationContext(), "flightNum", object.getString("flightNum"));
                            Prefs.write(getApplicationContext(), "luxStatus", object.getString("lux"));
                            Prefs.write(getApplicationContext(), "vagon", object.getString("vagon"));
                            Prefs.write(getApplicationContext(), "seat", object.getString("seat"));
                            Prefs.write(getApplicationContext(), "loggedIn", "true");
                            Snackbar.make(v, "?????????? ????????????????????", Snackbar.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            overridePendingTransition(0, 0);
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
                params.put("pass", pass);
                params.put("vagon", vagon);
                params.put("seat", seat);
                params.put("ticket", ticket);

                return params;
            }
        };

        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}