package com.sttimchenko.censushelper.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Stanislav on 14.05.2016.
 */
public class DatabaseFactory {
    public static final String DB_NAME = "census.db";
    public static final int DB_VERSION = 1;

    private CensusDatabase censusDatabase;
    private CensusDBHelper censusDBHelper;

    private static DatabaseFactory instance;

    private static final Object lock = new Object();

    public static DatabaseFactory get(Context context) {
        synchronized (lock) {
            if (instance == null)
                instance = new DatabaseFactory(context);

            return instance;
        }
    }

    private DatabaseFactory(Context context){
        this.censusDBHelper = new CensusDBHelper(context);

        this.censusDatabase = new CensusDatabase(context, censusDBHelper);
    }

    public CensusDatabase getCensusDatabase(){
        return censusDatabase;
    }

    private class CensusDBHelper extends SQLiteOpenHelper{

        public CensusDBHelper(Context context){
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CensusDatabase.CREATE_TABLE_AIMS);
            db.execSQL(CensusDatabase.CREATE_TABLE_RESPONSES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
