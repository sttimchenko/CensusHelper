package com.sttimchenko.censushelper.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface ResponseseTableContract extends BaseColumns {
    String TABLE_NAME = "aims_table";

    String AIM_ID = "aim_id";
    String IS_SIGNED = "is_signed";
    String GENDER = "gender";
    String AGE = "age";
    String BIRTH_DATE = "birth_date";
    String BIRTH_PLACE = "birth_place";
    String FAMILY_STATUS = "family_status";
    String ETHNICITY = "ethnicity";
    String NATIONALITY = "nationality";
    String SPOKEN_LANGUAGE = "spoken_language";
    String EDUCATION = "education";
    String INCOME_SOURCES = "income_sources";
    String WORKING_STATUS = "working_status";
    String LIVING_CONDITIONS = "living_conditions";
}
