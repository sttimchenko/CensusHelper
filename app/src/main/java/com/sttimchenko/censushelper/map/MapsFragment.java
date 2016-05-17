package com.sttimchenko.censushelper.map;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sttimchenko.censushelper.Constants;
import com.sttimchenko.censushelper.R;
import com.sttimchenko.censushelper.form.FormActivity;
import com.sttimchenko.censushelper.model.Aim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsFragment extends Fragment implements com.sttimchenko.censushelper.map.MapView
        , OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener{

    private MapPresenter presenter;

    private GoogleMap mMap;
    private MapView mapView;

    private Map<Marker, Aim> dataMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        presenter = new MapPresenterImpl(this, new MapModelImpl());
        presenter.onCreate(getActivity(), savedInstanceState);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapView.onResume();

        presenter.requestData();

        UiSettings settings = mMap.getUiSettings();
        settings.setMyLocationButtonEnabled(true);
        settings.setAllGesturesEnabled(true);
        settings.setMyLocationButtonEnabled(true);

        MapsInitializer.initialize(this.getActivity());

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.5111, 30.7909), 12));

        mMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onData(List<Aim> list) {
        this.dataMap = new HashMap<>(list.size());

        for (Aim aim : list){
            dataMap.put(mMap.addMarker(new MarkerOptions().position(aim.getCordinates())
                            .title(aim.getStreetName() + " " + aim.getBuildingNumber())), aim);
        }
    }

    public void showConcreteDialog(final List<String> list, final Aim aim) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Оберіть номер квартири");

        builder.setItems(list.toArray(new String[list.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.onItemChosen(aim, Integer.valueOf(list.get(which)));
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Відміна", null);

        builder.show();
    }

    @Override
    public void onChoiceMade(int aimId, int flatNumber) {
        Intent intent = new Intent(getActivity(), FormActivity.class);
        intent.putExtra(Constants.EXTRA_KEY_ID, aimId);
        intent.putExtra(Constants.EXTRA_KEY_FLAT, flatNumber);
        getContext().startActivity(intent);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Aim aim = dataMap.get(marker);

        if (!aim.getFlatsNumbers().isEmpty()){
            showConcreteDialog(aim.getFlatsNumbers(), aim);
        } else {
            onChoiceMade(aim.getId(), 0);
        }
    }
}
