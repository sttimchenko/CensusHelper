package com.sttimchenko.censushelper.form;

import android.content.Context;

import com.sttimchenko.censushelper.model.FormResponse;

public interface FormModel {
    void saveDataAndDeleteAim(Context context, FormResponse formResponse, int id, int flat);
    void saveData(Context context, FormResponse formResponse);
}
