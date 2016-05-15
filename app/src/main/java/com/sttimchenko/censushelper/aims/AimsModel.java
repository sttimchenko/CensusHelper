package com.sttimchenko.censushelper.aims;

import android.content.Context;

import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

import rx.Observable;

public interface AimsModel {
    Observable<List<Aim>> getAims(Context context);
}
