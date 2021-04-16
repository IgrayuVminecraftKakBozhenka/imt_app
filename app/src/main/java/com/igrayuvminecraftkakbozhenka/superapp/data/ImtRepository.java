package com.igrayuvminecraftkakbozhenka.superapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.ArrayList;
import java.util.HashMap;
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

    private SharedPreferences results;
    private SharedPreferences keys;

    public ImtRepository(final Context context) {
        results = context.getSharedPreferences(APP_PREFERENCES_PARAMETERS, Context.MODE_PRIVATE);
        keys = context.getSharedPreferences(APP_PREFERENCES_KEYS, Context.MODE_PRIVATE);
    }

    public void saveResult(ImtModel imtModel) {
        SharedPreferences.Editor editor = results.edit();
        String parameters = results.getString(APP_PREFERENCES_NAME, "") + imtModel.getName() + ","
                + imtModel.getHigh() + "," + imtModel.getWeigh() + "," + imtModel.getImt() + ",";
        editor.putString(imtModel.getName(), parameters);
        editor.apply();
    }

    public List<ImtModel> getAllResults() {
        Map<String, ?> resultsFromPreferences = results.getAll();
        Set<String> keys = resultsFromPreferences.keySet();
        List<ImtModel> imtModelsList = new ArrayList<>();

        for (String key : keys) {
            String parameters = results.getString(key, "");
            String[] parametersArray = parameters.split(",");
            ImtModel imtModel = new ImtModel(parametersArray[0], parametersArray[1], parametersArray[2], parametersArray[3]);
            imtModelsList.add(imtModel);
        }

        return imtModelsList;
    }

    public void clearRepository() {
        SharedPreferences.Editor editor = results.edit();
        editor.clear();
        editor.apply();
    }

}
