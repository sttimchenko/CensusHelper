package com.sttimchenko.censushelper.form;

import android.content.Context;

import com.sttimchenko.censushelper.database.CensusDatabase;
import com.sttimchenko.censushelper.database.DatabaseFactory;
import com.sttimchenko.censushelper.model.Response;

public class FormModelImpl implements FormModel {
    private CensusDatabase database;

    @Override
    public void saveDataAndDeleteAim(Context context, Response response, int id, int flat) {
        if (database == null) database = DatabaseFactory.get(context).getCensusDatabase();

        database.writeResponse(response);
        database.deleteAim(id, flat);
    }

    @Override
    public void saveData(Context context, Response response) {
        if (database == null) database = DatabaseFactory.get(context).getCensusDatabase();

        database.writeResponse(response);
    }
}
