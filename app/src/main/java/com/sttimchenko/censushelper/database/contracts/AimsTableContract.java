package com.sttimchenko.censushelper.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface AimsTableContract extends BaseColumns {
    String TABLE_NAME = "aims_table";

    String STREET_NAME = "street_name";
    String BUILDING_NUMBER = "building_numbers";
    String FLAT_NUMBERS = "flat_number";
    String LAT = "lat";
    String LONG = "long";
}
