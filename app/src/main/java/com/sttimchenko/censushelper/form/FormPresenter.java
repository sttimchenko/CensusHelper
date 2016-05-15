package com.sttimchenko.censushelper.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public interface FormPresenter {
    void saveData(String gender, int age, long birthday, String birthplace, String familyStatus
            , String ethnicity, String language, String nationality, String education, String incomes
            , String workStatus, String livingConditions, boolean isLast, int id, int flat);
    void onCreate(AppCompatActivity activity, Bundle savedInstanceState);
    void onDestroy();
}
