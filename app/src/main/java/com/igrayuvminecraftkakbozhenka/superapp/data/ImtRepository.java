package com.igrayuvminecraftkakbozhenka.superapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.igrayuvminecraftkakbozhenka.superapp.data.db.DbHelper;
import com.igrayuvminecraftkakbozhenka.superapp.data.db.OpenDbHelper;
import com.igrayuvminecraftkakbozhenka.superapp.models.ImtModel;

import java.util.List;

public final class ImtRepository {

    private final ContentValues contentValues;
    private final SQLiteDatabase db;
    private final DbHelper dbHelper;

    public ImtRepository(final Context context) {
        this.contentValues = new ContentValues();
        OpenDbHelper dbHelper = new OpenDbHelper(context);
        this.db = dbHelper.getWritableDatabase();
        this.dbHelper = new DbHelper(context);
    }

    public void saveResult(ImtModel imtModel) {
        dbHelper.setData(imtModel);
    }

    public List<ImtModel> getAllResults() {
        return dbHelper.getData();
    }

    public void clearRepository() {
        db.delete(OpenDbHelper.TABLE_NAME, null, null);
    }

}
