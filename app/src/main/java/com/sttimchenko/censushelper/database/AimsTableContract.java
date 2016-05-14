package com.sttimchenko.censushelper.database;

import android.provider.BaseColumns;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface AimsTableContract extends BaseColumns {
    String TABLE_NAME = "aims_table";

    String STREET_NAME = "street_name";
    String BUILDING_NUMBER = "building_number";
    String FLAT_NUMBER = "flat_number";
}
