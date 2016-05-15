package com.sttimchenko.censushelper.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.sttimchenko.censushelper.R;

public class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public InfoWindowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View v = LayoutInflater.from(context).inflate(R.layout.map_info_window_item, null);

        ((TextView) v.findViewById(R.id.tv_info)).setText(marker.getTitle());
        ((TextView) v.findViewById(R.id.tv_type)).setText("HOHOHO");

        return v;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
