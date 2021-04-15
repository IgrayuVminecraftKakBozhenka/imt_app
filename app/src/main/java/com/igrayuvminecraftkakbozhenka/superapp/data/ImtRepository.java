package com.igrayuvminecraftkakbozhenka.superapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.Map;

public final class ImtRepository {

    private static final String APP_PREFERENCES = "statistic";
    private static final String APP_PREFERENCES_NAME = "name";
    private static final String APP_PREFERENCES_HIGH = "high";
    private static final String APP_PREFERENCES_WEIGH = "weigh";
    private static final String APP_PREFERENCES_IMT = "imt";

    private final SharedPreferences results;

    public ImtRepository(final Context context) {
        results = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void saveResult(ImtModel imtModel) {
        String parameters = "name: " + imtModel.getName() + " high: " + imtModel.getHigh() + ", weigh: " + imtModel.getWeigh() + ", imt: " + imtModel.getImt();
        SharedPreferences.Editor editor = results.edit();
        editor.putString(APP_PREFERENCES_NAME, parameters);
        editor.apply();
    }

    public Map<String, ?> getResult() {
        return results.getAll();
    }


}
