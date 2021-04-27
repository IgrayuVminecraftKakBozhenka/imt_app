package com.igrayuvminecraftkakbozhenka.superapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.igrayuvminecraftkakbozhenka.superapp.data.db.OpenDbHelper;
import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.ArrayList;
import java.util.List;

public final class ImtRepository {

    private final ContentValues contentValues;
    private final SQLiteDatabase db;

    public ImtRepository(final Context context) {
        this.contentValues = new ContentValues();
        OpenDbHelper dbHelper = new OpenDbHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public void saveResult(ImtModel imtModel) {
        contentValues.put(OpenDbHelper.COLUMN_NAME, imtModel.getName());
        contentValues.put(OpenDbHelper.COLUMN_HIGH, imtModel.getHigh());
        contentValues.put(OpenDbHelper.COLUMN_WEIGH, imtModel.getWeigh());
        contentValues.put(OpenDbHelper.COLUMN_IMT, imtModel.getImt());
        db.insert(OpenDbHelper.TABLE_NAME, null, contentValues);
    }

    public List<ImtModel> getAllResults() {
        Cursor cursor = db.query(OpenDbHelper.TABLE_NAME, null, null, null, null, null, null);
        List<ImtModel> imtModelsList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            int nameColumnIndex = cursor.getColumnIndex(OpenDbHelper.COLUMN_NAME);
            int highColumnIndex = cursor.getColumnIndex(OpenDbHelper.COLUMN_HIGH);
            int weighColumnIndex = cursor.getColumnIndex(OpenDbHelper.COLUMN_WEIGH);
            int imtColumnIndex = cursor.getColumnIndex(OpenDbHelper.COLUMN_IMT);
            do {
                String name = cursor.getString(nameColumnIndex);
                double high = cursor.getDouble(highColumnIndex);
                double weigh = cursor.getDouble(weighColumnIndex);
                double imt = cursor.getDouble(imtColumnIndex);
                ImtModel imtModel = new ImtModel(name, high, weigh, imt);
                imtModelsList.add(imtModel);
            } while (cursor.moveToNext());
        } else {
            cursor.close();
        }

        return imtModelsList;
    }

    public void clearRepository() {
        db.delete(OpenDbHelper.TABLE_NAME, null, null);
    }

}
