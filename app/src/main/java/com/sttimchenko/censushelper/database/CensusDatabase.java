package com.sttimchenko.censushelper.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import com.sttimchenko.censushelper.Utils;
import com.sttimchenko.censushelper.database.contracts.AimsTableContract;
import com.sttimchenko.censushelper.database.contracts.ResponseseTableContract;
import com.sttimchenko.censushelper.model.Response;

import java.util.List;

/**
 * Created by Stanislav on 14.05.2016.
 */
public class CensusDatabase extends Database {

    public static final String CREATE_TABLE_AIMS =
            "CREATE TABLE IF NOT EXISTS " + AimsTableContract.TABLE_NAME
                    + " (" + AimsTableContract._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + AimsTableContract.STREET_NAME + " TEXT NOT NULL, "
                    + AimsTableContract.BUILDING_NUMBER + " INTEGER NOT NULL, "
                    + AimsTableContract.FLAT_NUMBERS + " TEXT DEFAULT '', "
                    + AimsTableContract.LAT + " REAL NOT NULL, "
                    + AimsTableContract.LONG + " REAL NOT NULL"
                    + ");";

    public static final String CREATE_TABLE_RESPONSES =
            "CREATE TABLE IF NOT EXISTS " + ResponseseTableContract.TABLE_NAME
                    + " (" + ResponseseTableContract._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
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
                    + ResponseseTableContract.LIVING_CONDITIONS + " TEXT NOT NULL"
                    + ");";

    public CensusDatabase(Context context, SQLiteOpenHelper databaseHelper) {
        super(context, databaseHelper);
    }

    public Cursor getAims(){
        return databaseHelper.getReadableDatabase().query(AimsTableContract.TABLE_NAME, null
                , null, null, null, null, null);
    }

    public void writeResponse(Response response){
        ContentValues cv = new ContentValues();

        cv.put(ResponseseTableContract.AGE, response.getAge());
        cv.put(ResponseseTableContract.BIRTH_DATE, response.getBirthday());
        cv.put(ResponseseTableContract.BIRTH_PLACE, response.getBirthplace());
        cv.put(ResponseseTableContract.EDUCATION, response.getEducation());
        cv.put(ResponseseTableContract.ETHNICITY, response.getEthnicity());
        cv.put(ResponseseTableContract.FAMILY_STATUS, response.getFamilyStatus());
        cv.put(ResponseseTableContract.GENDER, response.getGender());
        cv.put(ResponseseTableContract.INCOME_SOURCES, response.getIncomes());
        cv.put(ResponseseTableContract.SPOKEN_LANGUAGE, response.getLanguage());
        cv.put(ResponseseTableContract.LIVING_CONDITIONS, response.getLivingConditions());

        databaseHelper.getWritableDatabase().insert(ResponseseTableContract.TABLE_NAME, null, cv);
    }

    public void deleteAim(int id, int flatNumber){
        if (flatNumber != 0) {
            ContentValues cv = new ContentValues();

            Cursor c = databaseHelper.getReadableDatabase().query(AimsTableContract.TABLE_NAME, new String[]{AimsTableContract.FLAT_NUMBERS}
                    , AimsTableContract._ID + " = ?", new String[]{id + ""}, null, null, null);

            if (c != null){
                List<String> list = Utils.splitToList(c.getString(c.getColumnIndexOrThrow(AimsTableContract.FLAT_NUMBERS)), ",");

                list.remove(String.valueOf(flatNumber));

                cv.put(AimsTableContract.FLAT_NUMBERS, Utils.join(list, ","));

                databaseHelper.getWritableDatabase().update(AimsTableContract.TABLE_NAME, cv
                        , AimsTableContract._ID + " = ?", new String[]{id + ""});

                c.close();
            }

        } else {
            databaseHelper.getWritableDatabase().delete(AimsTableContract.TABLE_NAME
                    , AimsTableContract._ID + " = ?", new String[]{id + ""});
        }
    }
}
