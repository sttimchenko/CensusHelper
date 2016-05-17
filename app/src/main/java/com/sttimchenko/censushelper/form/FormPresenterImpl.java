package com.sttimchenko.censushelper.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sttimchenko.censushelper.model.FormResponse;

public class FormPresenterImpl implements FormPresenter {
    private FormView view;
    private FormModel model;

    private AppCompatActivity activity;

    public FormPresenterImpl(FormView view, FormModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void saveData(String gender, int age, long birthday, String birthplace, String familyStatus
            , String ethnicity, String language, String nationality, String education, String incomes
            , String workStatus, String livingConditions, boolean isLast, int id, int flat) {

        FormResponse formResponse = new FormResponse();

        formResponse.setGender(gender);
        formResponse.setAge(age);
        formResponse.setBirthday(birthday);
        formResponse.setBirthplace(birthplace);
        formResponse.setFamilyStatus(familyStatus);
        formResponse.setEthnicity(ethnicity);
        formResponse.setLanguage(language);
        formResponse.setNationality(nationality);
        formResponse.setEducation(education);
        formResponse.setIncomes(incomes);
        formResponse.setWorkStatus(workStatus);
        formResponse.setLivingConditions(livingConditions);

        if (isLast){
            model.saveDataAndDeleteAim(activity, formResponse, id, flat);
            view.onBackPressed();
        } else {
            model.saveData(activity, formResponse);
            view.clearView();
        }
    }

    @Override
    public void onCreate(AppCompatActivity activity, Bundle savedInstanceState) {
        this.activity = activity;
    }

    @Override
    public void onDestroy() {

    }
}
