package com.igrayuvminecraftkakbozhenka.superapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ImtRepository {

    private static final String APP_PREFERENCES_PARAMETERS = "parameters";
    private static final String APP_PREFERENCES_KEYS = "keys";
    private static final String APP_PREFERENCES_NAME = "name";
    private static final String APP_PREFERENCES_HIGH = "high";
    private static final String APP_PREFERENCES_WEIGH = "weigh";
    private static final String APP_PREFERENCES_IMT = "imt";

    private SharedPreferences keys;

    public ImtRepository(final Context context) {
        keys = context.getSharedPreferences(APP_PREFERENCES_KEYS, Context.MODE_PRIVATE);
    }

    public void saveResult(ImtModel imtModel, Context context) {
        SharedPreferences.Editor keysEditor = keys.edit();
        keysEditor.putString(imtModel.getName(), imtModel.getName());
        keysEditor.apply();

        final String preferencesName = imtModel.getName();
        SharedPreferences name = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor nameEditor = name.edit();

        nameEditor.putString(APP_PREFERENCES_HIGH, imtModel.getHigh());
        nameEditor.putString(APP_PREFERENCES_WEIGH, imtModel.getWeigh());
        nameEditor.putString(APP_PREFERENCES_IMT, imtModel.getImt());
        nameEditor.apply();

    }

    public List<ImtModel> getAllResults(Context context) {
        Map<String, ?> keysFromKeysPreferences = keys.getAll();
        Set<String> keys = keysFromKeysPreferences.keySet();
        List<ImtModel> imtModelsList = new ArrayList<>();
        for (String key : keys) {
            List<String> params = new ArrayList<>();
            SharedPreferences prefs = context.getSharedPreferences(key, Context.MODE_PRIVATE);
            params.add(key);
            params.add(prefs.getString(APP_PREFERENCES_HIGH, ""));
            params.add(prefs.getString(APP_PREFERENCES_WEIGH, ""));
            params.add(prefs.getString(APP_PREFERENCES_IMT, ""));
            ImtModel imtModel = new ImtModel(params.get(0), params.get(1), params.get(2), params.get(3));
            imtModelsList.add(imtModel);
            }
        return imtModelsList;
    }

    public void clearRepository() {
        SharedPreferences.Editor keysEditor = keys.edit();
        keysEditor.clear();
        keysEditor.apply();


    }

}
