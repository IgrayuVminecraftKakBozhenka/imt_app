package com.igrayuvminecraftkakbozhenka.superapp;

import android.content.Context;
import android.content.SharedPreferences;

public class ImtRepository {
    private static final String APP_PREFERENCES = "statistic";
    private static final String APP_PREFERENCES_NAME = "name";
    private static final String APP_PREFERENCES_HIGH = "high";
    private static final String APP_PREFERENCES_WEIGH = "weigh";
    private static final String APP_PREFERENCES_IMT = "imt";
    final private Context context;
    final private String name;
    final private String high;
    final private String weight;
    final private String imt;
    final private SharedPreferences results;
    ImtRepository(String name, String high, String weight, String imt, Context context) {
        this.name = name;
        this.high = high;
        this.weight = weight;
        this.imt = imt;
        this.context = context;
        results = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        saveResult(this.name, this.high, this.weight, this.imt);
    }
    private void saveResult(String name, String high, String weight, String imt) {
        SharedPreferences.Editor editor = results.edit();
        editor.putString(APP_PREFERENCES_NAME, name);
        editor.putString(APP_PREFERENCES_HIGH, high);
        editor.putString(APP_PREFERENCES_WEIGH, weight);
        editor.putString(APP_PREFERENCES_IMT, imt);
        editor.apply();
    }

    public String getResult() {
        return results.getString(APP_PREFERENCES_NAME, "");
    }


}
