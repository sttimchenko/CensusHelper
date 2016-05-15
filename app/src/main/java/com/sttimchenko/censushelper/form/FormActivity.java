package com.sttimchenko.censushelper.form;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.sttimchenko.censushelper.Constants;
import com.sttimchenko.censushelper.R;

import java.util.Calendar;

public class FormActivity extends AppCompatActivity implements FormView, View.OnClickListener {

    private FormViewHolder holder;
    private FormPresenter presenter;

    private ScrollView scrollView;

    private String [] familyStatuses;
    private String [] education;
    private String [] workStatuses;

    private Calendar calendar;

    private int aimId;
    private int flatNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);

        Intent intent = getIntent();
        if (intent != null){
            aimId = intent.getIntExtra(Constants.EXTRA_KEY_ID, 0);
            flatNumber = intent.getIntExtra(Constants.EXTRA_KEY_FLAT, 0);
        }

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        holder = new FormViewHolder(
                (Toolbar) findViewById(R.id.toolbar),
                (RadioButton) findViewById(R.id.rb_man),
                (RadioButton) findViewById(R.id.rb_woman),
                (EditText) findViewById(R.id.et_age),
                (EditText) findViewById(R.id.et_birthday),
                (EditText) findViewById(R.id.et_birthplace),
                (Spinner) findViewById(R.id.sp_family_status),
                (AutoCompleteTextView) findViewById(R.id.ac_ethnicity),
                (AutoCompleteTextView) findViewById(R.id.ac_language),
                (AutoCompleteTextView) findViewById(R.id.ac_nationality),
                (Spinner) findViewById(R.id.sp_education),
                (AutoCompleteTextView) findViewById(R.id.ac_incomes),
                (Spinner) findViewById(R.id.sp_work_status),
                (EditText) findViewById(R.id.et_living_conditions),
                (FloatingActionButton) findViewById(R.id.fab)
        );

        this.presenter = new FormPresenterImpl(this, new FormModelImpl());

        setSupportActionBar(holder.toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        familyStatuses = getResources().getStringArray(R.array.family_status);
        education = getResources().getStringArray(R.array.education);
        workStatuses = getResources().getStringArray(R.array.work_status);

        presenter.onCreate(this, savedInstanceState);

        initSpinners();
        initAucompletes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        holder.fab.setOnClickListener(this);
        holder.etBirthday.setOnClickListener(this);
        holder.etBirthday.setKeyListener(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        holder.fab.setOnClickListener(null);
        holder.etBirthday.setOnClickListener(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.form_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                saveData(true);
                super.onBackPressed();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
            }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void clearView() {
        holder.rbMan.setChecked(false);
        holder.rbWoman.setChecked(false);
        holder.etAge.setText("");
        holder.etBirthday.setText("");
        holder.etBirthplace.setText("");
        holder.spFamilyStatus.setSelection(0);
        holder.acEthnicity.setText("");
        holder.acLanguage.setText("");
        holder.acNationality.setText("");
        holder.spEducation.setSelection(0);
        holder.acIncomes.setText("");
        holder.spWorkStatus.setSelection(0);
        holder.etLivingConditions.setText("");

        scrollView.smoothScrollTo(0, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                saveData(false);
                break;

            case R.id.et_birthday:
                calendar = Calendar.getInstance();
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(year, monthOfYear, dayOfMonth);
                        holder.etBirthday.setText(year + "." + monthOfYear + "." + dayOfMonth);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }

    private void initSpinners(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, familyStatuses);
        holder.spFamilyStatus.setAdapter(adapter);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, education);
        holder.spEducation.setAdapter(adapter);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, workStatuses);
        holder.spWorkStatus.setAdapter(adapter);
    }

    private void initAucompletes(){
        String [] arr = getResources().getStringArray(R.array.ethnicity);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, arr);
        holder.acEthnicity.setAdapter(adapter);
        holder.acEthnicity.setThreshold(1);

        arr = getResources().getStringArray(R.array.language);
        adapter= new ArrayAdapter<>(this, android.R.layout.select_dialog_item, arr);
        holder.acLanguage.setAdapter(adapter);
        holder.acLanguage.setThreshold(1);

        arr = getResources().getStringArray(R.array.nationality);
        adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, arr);
        holder.acNationality.setAdapter(adapter);
        holder.acNationality.setThreshold(1);

        arr = getResources().getStringArray(R.array.incomes);
        adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, arr);
        holder.acIncomes.setAdapter(adapter);
        holder.acIncomes.setThreshold(1);
    }

    private void saveData(boolean isLast){
        presenter.saveData(
                holder.rbMan.isChecked() ? "Чоловік" : "Жінка",
                Integer.valueOf(holder.etAge.getText().toString()),
                calendar.getTimeInMillis(),
                holder.etBirthplace.getText().toString(),
                familyStatuses[holder.spFamilyStatus.getSelectedItemPosition()],
                holder.acEthnicity.getText().toString(),
                holder.acLanguage.getText().toString(),
                holder.acNationality.getText().toString(),
                education[holder.spEducation.getSelectedItemPosition()],
                holder.acIncomes.getText().toString(),
                workStatuses[holder.spWorkStatus.getSelectedItemPosition()],
                holder.etLivingConditions.getText().toString(),
                isLast
                , aimId
                , flatNumber
        );
    }
}
