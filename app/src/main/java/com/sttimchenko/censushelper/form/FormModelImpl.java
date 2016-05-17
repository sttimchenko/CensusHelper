package com.sttimchenko.censushelper.form;

import android.content.Context;

import com.sttimchenko.censushelper.database.CensusDatabase;
import com.sttimchenko.censushelper.database.DatabaseFactory;
import com.sttimchenko.censushelper.model.FormResponse;

public class FormModelImpl implements FormModel {
    private CensusDatabase database;

    @Override
    public void saveDataAndDeleteAim(Context context, FormResponse formResponse, int id, int flat) {
        if (database == null) database = DatabaseFactory.get(context).getCensusDatabase();

        database.writeResponse(formResponse);
        database.deleteAim(id, flat);
    }

    @Override
    public void saveData(Context context, FormResponse formResponse) {
        if (database == null) database = DatabaseFactory.get(context).getCensusDatabase();

        database.writeResponse(formResponse);
    }
}
