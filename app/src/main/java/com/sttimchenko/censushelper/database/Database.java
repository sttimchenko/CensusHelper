package com.sttimchenko.censushelper.database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Stanislav on 14.05.2016.
 */
public abstract class Database {
    protected SQLiteOpenHelper databaseHelper;
    protected final Context context;

    public Database(Context context, SQLiteOpenHelper databaseHelper) {
        this.context        = context;
        this.databaseHelper = databaseHelper;
    }

    public SQLiteOpenHelper getDatabaseHelper() {
        return databaseHelper;
    }
}
