package com.sttimchenko.censushelper.form;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class FormViewHolder {
    protected Toolbar toolbar;
    protected RadioButton rbMan;
    protected RadioButton rbWoman;
    protected EditText etAge;
    protected EditText etBirthday;
    protected EditText etBirthplace;
    protected Spinner spFamilyStatus;
    protected AutoCompleteTextView acEthnicity;
    protected AutoCompleteTextView acLanguage;
    protected AutoCompleteTextView acNationality;
    protected Spinner spEducation;
    protected AutoCompleteTextView acIncomes;
    protected Spinner spWorkStatus;
    protected EditText etLivingConditions;
    protected FloatingActionButton fab;

    public FormViewHolder(Toolbar toolbar, RadioButton rbMan, RadioButton rbWoman, EditText etAge
            , EditText etBirthday, EditText etBirthplace, Spinner spFamilyStatus
            , AutoCompleteTextView acEthnicity, AutoCompleteTextView acLanguage
            , AutoCompleteTextView acNationality, Spinner spEducation, AutoCompleteTextView acIncomes
            , Spinner spWorkStatus, EditText etLivingConditions, FloatingActionButton fab) {
        this.toolbar = toolbar;
        this.rbMan = rbMan;
        this.rbWoman = rbWoman;
        this.etAge = etAge;
        this.etBirthday = etBirthday;
        this.etBirthplace = etBirthplace;
        this.spFamilyStatus = spFamilyStatus;
        this.acEthnicity = acEthnicity;
        this.acLanguage = acLanguage;
        this.acNationality = acNationality;
        this.spEducation = spEducation;
        this.acIncomes = acIncomes;
        this.spWorkStatus = spWorkStatus;
        this.etLivingConditions = etLivingConditions;
        this.fab = fab;
    }
}
