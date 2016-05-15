package com.sttimchenko.censushelper.map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sttimchenko.censushelper.R;
import com.sttimchenko.censushelper.main.MainActivity;

public class MapsFragment extends Fragment implements OnMapReadyCallback, View.OnTouchListener {

    private GoogleMap mMap;
    private MapView mapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);
        mapView.setOnTouchListener(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapView.onResume();

        UiSettings settings = mMap.getUiSettings();
        settings.setMyLocationButtonEnabled(true);
        settings.setAllGesturesEnabled(true);

        MapsInitializer.initialize(this.getActivity());

        InfoWindowAdapter adapter = new InfoWindowAdapter(getContext());

//        mMap.setInfoWindowAdapter(adapter);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ViewParent parent = ((MainActivity) getActivity()).getViewPager();
        // or get a reference to the ViewPager and cast it to ViewParent

        parent.requestDisallowInterceptTouchEvent(true);

        // let this view deal with the event or
        return mapView.onTouchEvent(event);
    }
}
