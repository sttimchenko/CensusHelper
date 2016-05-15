package com.sttimchenko.censushelper.form;

import android.content.Context;

import com.sttimchenko.censushelper.model.Response;

public interface FormModel {
    void saveDataAndDeleteAim(Context context, Response response, int id, int flat);
    void saveData(Context context, Response response);
}
