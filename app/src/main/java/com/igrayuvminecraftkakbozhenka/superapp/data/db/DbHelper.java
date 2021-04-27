package com.igrayuvminecraftkakbozhenka.superapp.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.ArrayList;
import java.util.List;

public class DbHelper implements DataBase {

    private final ContentValues contentValues;
    private final SQLiteDatabase db;

    public DbHelper(final Context context) {
        this.contentValues = new ContentValues();
        OpenDbHelper dbHelper = new OpenDbHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    @Override
    public void setData(ImtModel imtModel) {
        contentValues.put(OpenDbHelper.COLUMN_NAME, imtModel.getName());
        contentValues.put(OpenDbHelper.COLUMN_HIGH, imtModel.getHigh());
        contentValues.put(OpenDbHelper.COLUMN_WEIGH, imtModel.getWeigh());
        contentValues.put(OpenDbHelper.COLUMN_IMT, imtModel.getImt());
        db.insert(OpenDbHelper.TABLE_NAME, null, contentValues);
    }


    @Override
    public List<ImtModel> getData() {
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
}
