package com.sttimchenko.censushelper.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sttimchenko.censushelper.model.Response;

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

        Response response = new Response();

        response.setGender(gender);
        response.setAge(age);
        response.setBirthday(birthday);
        response.setBirthplace(birthplace);
        response.setFamilyStatus(familyStatus);
        response.setEthnicity(ethnicity);
        response.setLanguage(language);
        response.setNationality(nationality);
        response.setEducation(education);
        response.setIncomes(incomes);
        response.setWorkStatus(workStatus);
        response.setLivingConditions(livingConditions);

        if (isLast){
            model.saveDataAndDeleteAim(activity, response, id, flat);
            view.onBackPressed();
        } else {
            model.saveData(activity, response);
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
