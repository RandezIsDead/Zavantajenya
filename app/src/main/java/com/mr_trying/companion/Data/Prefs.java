package com.mr_trying.companion.Data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mr_trying.companion.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class Prefs {

    private static final String SHARED_PREFS = "Companion-Prefs";
    private static final Gson gson = new Gson();

    public static void write(Context context, String key, String text) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, text);
        editor.apply();
    }

    public static String read(Context context, String key) {
        return context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
                .getString(key, null);
    }

    public static void writeObject(Context context, String key, List value) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(key, json);
        prefsEditor.apply();
    }

    public static String getJson(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    public static List<Item> getItems(Context context) {
        if (gson.fromJson(getJson(context, "items"), new TypeToken<List<Item>>() {}.getType()) == null)
            return new ArrayList<>();
        else return gson.fromJson(getJson(context, "items"), new TypeToken<List<Item>>() {}.getType());
    }

    public static void saveItems(Context context, List<Item> items) {
        writeObject(context, "items", items);
    }
}
