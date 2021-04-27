package com.igrayuvminecraftkakbozhenka.superapp.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.List;

public class DbHelper extends SQLiteDatabase implements DataBase {

    private final ContentValues contentValues;
    private final SQLiteDatabase db;

    public DbHelper(final Context context) {
        super();
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
        return null;
    }
}
