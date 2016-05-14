package com.sttimchenko.censushelper.database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Stanislav on 14.05.2016.
 */
public class CensusDatabase extends Database {

    public static final String CREATE_TABLE_AIMS =
            "CREATE TABLE " + AimsTableContract.TABLE_NAME
                    + " (" + AimsTableContract._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + AimsTableContract.STREET_NAME + " TEXT NOT NULL, "
                    + AimsTableContract.BUILDING_NUMBER + " INTEGER NOT NULL, "
                    + AimsTableContract.FLAT_NUMBER + " INTEGER, "
                    + ");";

    public static final String CREATE_TABLE_RESPONSES =
            "CREATE TABLE " + ResponseseTableContract.TABLE_NAME
                    + ResponseseTableContract._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + ResponseseTableContract.AIM_ID + " INTEGER NOT NULL, "
                    + ResponseseTableContract.IS_SIGNED + " INTEGER NOT NULL DEFAULT 0, "
                    + ResponseseTableContract.GENDER + " TEXT NOT NULL, "
                    + ResponseseTableContract.AGE + " INTEGER NOT NULL, "
                    + ResponseseTableContract.BIRTH_DATE + " INTEGER NOT NULL, "
                    + ResponseseTableContract.BIRTH_PLACE + " TEXT NOT NULL, "
                    + ResponseseTableContract.FAMILY_STATUS + " TEXT NOT NULL, "
                    + ResponseseTableContract.ETHNICITY + " TEXT NOT NULL, "
                    + ResponseseTableContract.NATIONALITY + " TEXT NOT NULL, "
                    + ResponseseTableContract.SPOKEN_LANGUAGE + " TEXT NOT NULL, "
                    + ResponseseTableContract.EDUCATION + " TEXT NOT NULL, "
                    + ResponseseTableContract.INCOME_SOURCES + " TEXT NOT NULL, "
                    + ResponseseTableContract.WORKING_STATUS + " TEXT NOT NULL, "
                    + ResponseseTableContract.LIVING_CONDITIONS + " TEXT NOT NULL, "
                    + ");";

    public CensusDatabase(Context context, SQLiteOpenHelper databaseHelper) {
        super(context, databaseHelper);
    }
}
