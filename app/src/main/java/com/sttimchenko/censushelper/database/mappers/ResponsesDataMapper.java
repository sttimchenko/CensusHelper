package com.sttimchenko.censushelper.database.mappers;

import android.content.Context;
import android.database.Cursor;

import com.sttimchenko.censushelper.database.CensusDatabase;
import com.sttimchenko.censushelper.database.DatabaseFactory;
import com.sttimchenko.censushelper.database.contracts.ResponseseTableContract;
import com.sttimchenko.censushelper.model.FormResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanislav on 14.05.2016.
 */
public class ResponsesDataMapper {
    private CensusDatabase database;

    public ResponsesDataMapper(Context context){
        this.database = DatabaseFactory.get(context).getCensusDatabase();
    }

    public List<FormResponse> getResponces(){
        Cursor cursor = database.getResponses();

        List<FormResponse> list = new ArrayList<>(cursor.getCount());

        while (!cursor.isLast()){
            FormResponse response = getResponse(cursor);

            if (response != null) list.add(response);
            else return list;
        }

        cursor.close();
        return list;
    }

    public FormResponse getResponse(Cursor cursor){
        if (cursor == null || !cursor.moveToNext()) {
            return null;
        }

        FormResponse response = new FormResponse();

        response.setGender(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.GENDER)));
        response.setAge(cursor.getInt(cursor.getColumnIndexOrThrow(ResponseseTableContract.AGE)));
        response.setBirthday(cursor.getLong(cursor.getColumnIndexOrThrow(ResponseseTableContract.BIRTH_DATE)));
        response.setBirthplace(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.BIRTH_PLACE)));
        response.setFamilyStatus(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.FAMILY_STATUS)));
        response.setEthnicity(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.ETHNICITY)));
        response.setNationality(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.NATIONALITY)));
        response.setLanguage(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.SPOKEN_LANGUAGE)));
        response.setEducation(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.EDUCATION)));
        response.setIncomes(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.INCOME_SOURCES)));
        response.setWorkStatus(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.WORKING_STATUS)));
        response.setLivingConditions(cursor.getString(cursor.getColumnIndexOrThrow(ResponseseTableContract.LIVING_CONDITIONS)));

        return response;
    }
}
