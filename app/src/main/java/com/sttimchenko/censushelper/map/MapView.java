package com.sttimchenko.censushelper.map;

import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

/**
 * Created by Stanislav on 14.05.2016.
 */
public interface MapView {
    void onData(List<Aim> map);
    void onChoiceMade(int aimId, int flatNumber);
}
