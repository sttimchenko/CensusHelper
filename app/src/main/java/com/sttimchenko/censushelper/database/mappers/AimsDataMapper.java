package com.sttimchenko.censushelper.database.mappers;

import android.content.Context;
import android.database.Cursor;

import com.google.android.gms.maps.model.LatLng;
import com.sttimchenko.censushelper.Utils;
import com.sttimchenko.censushelper.database.CensusDatabase;
import com.sttimchenko.censushelper.database.DatabaseFactory;
import com.sttimchenko.censushelper.database.contracts.AimsTableContract;
import com.sttimchenko.censushelper.model.Aim;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanislav on 14.05.2016.
 */
public class AimsDataMapper {
    private CensusDatabase database;

    public AimsDataMapper(Context context) {
        this.database = DatabaseFactory.get(context).getCensusDatabase();
    }

    public List<Aim> getAims(){
        Cursor cursor = database.getAims();

        List<Aim> list = new ArrayList<>(cursor.getCount());

        while (!cursor.isLast()){
            Aim aim = getAim(cursor);

            if (aim != null) list.add(aim);
            else return list;
        }

        cursor.close();
        return list;
    }

    public Aim getAim(Cursor cursor){
        if (cursor == null || !cursor.moveToNext()) {
            return null;
        }

        Aim aim = new Aim();

        aim.setId(cursor.getInt(cursor.getColumnIndexOrThrow(AimsTableContract._ID)));
        aim.setStreetName(cursor.getString(cursor.getColumnIndexOrThrow(AimsTableContract.STREET_NAME)));
        aim.setBuildingNumber(cursor.getString(cursor.getColumnIndexOrThrow(AimsTableContract.BUILDING_NUMBER)));
        aim.setFlatsNumbers(Utils.splitToList(cursor.getString(cursor.getColumnIndexOrThrow(AimsTableContract.FLAT_NUMBERS)), ","));

        LatLng latLng = new LatLng(cursor.getDouble(cursor.getColumnIndexOrThrow(AimsTableContract.LAT))
                , cursor.getDouble(cursor.getColumnIndexOrThrow(AimsTableContract.LONG)));
        aim.setCordinates(latLng);

        return aim;
    }
}
