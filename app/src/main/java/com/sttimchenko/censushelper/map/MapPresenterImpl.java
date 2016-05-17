package com.sttimchenko.censushelper.map;

import android.app.Activity;
import android.os.Bundle;

import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

import rx.functions.Action1;

public class MapPresenterImpl implements MapPresenter {
    private MapView view;
    private MapModel model;

    private Activity activity;

    private List<Aim> list;

    public MapPresenterImpl(MapView view, MapModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void requestData() {
        model.getAims(activity).subscribe(new Action1<List<Aim>>() {
            @Override
            public void call(List<Aim> list) {
                view.onData(list);
            }
        });
    }

    @Override
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        this.activity = activity;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onItemChosen(int position) {

    }

    @Override
    public void onItemChosen(Aim aim, int flat) {
        view.onChoiceMade(aim.getId(), flat);
    }
}
