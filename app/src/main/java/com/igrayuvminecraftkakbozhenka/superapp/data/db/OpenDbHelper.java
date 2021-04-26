package com.igrayuvminecraftkakbozhenka.superapp.data.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenDbHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "results";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_HIGH = "high";
    public static final String COLUMN_WEIGH = "weigh";
    public static final String COLUMN_IMT = "imt";
    private static final int DATABASE_VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + "( _id INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_HIGH + " REAL, " + COLUMN_WEIGH + " REAL, " + COLUMN_IMT + " REAL )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
