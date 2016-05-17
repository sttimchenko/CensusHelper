package com.sttimchenko.censushelper.map;

import android.content.Context;

import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

import rx.Observable;

public interface MapModel {
    Observable<List<Aim>> getAims(Context context);
}
