package com.sttimchenko.censushelper.map;

import android.app.Activity;
import android.os.Bundle;

import com.sttimchenko.censushelper.model.Aim;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface MapPresenter {
    void requestData();
    void onCreate(Activity activity, Bundle savedInstanceState);
    void onDestroy();
    void onItemChosen(int position);
    void onItemChosen(Aim aim, int flat);
}
