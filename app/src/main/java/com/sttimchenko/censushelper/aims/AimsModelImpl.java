package com.sttimchenko.censushelper.aims;

import android.content.Context;

import com.sttimchenko.censushelper.database.mappers.AimsDataMapper;
import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class AimsModelImpl implements AimsModel {
    @Override
    public Observable<List<Aim>> getAims(final Context context) {
        return Observable.create(new Observable.OnSubscribe<List<Aim>>() {
            @Override
            public void call(Subscriber<? super List<Aim>> subscriber) {
                AimsDataMapper mapper = new AimsDataMapper(context);
                subscriber.onNext(mapper.getAims());
            }
        });
    }
}
