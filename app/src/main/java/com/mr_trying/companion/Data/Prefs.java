package com.mr_trying.companion.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private static final String SHARED_PREFS = "Companion-Prefs";

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
}
