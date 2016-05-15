package com.sttimchenko.censushelper.aims;

import android.app.Activity;
import android.os.Bundle;

import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

import rx.functions.Action1;

public class AimsPresenterImpl implements AimsPresenter {
    private AimsModel model;
    private AimsView view;
    private Activity activity;
    private List<Aim> list;

    public AimsPresenterImpl(AimsView view, AimsModel model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void requestAdapterData() {
        model.getAims(activity).subscribe(new Action1<List<Aim>>() {
            @Override
            public void call(List<Aim> list) {
                AimsPresenterImpl.this.list = list;
                view.onAdapterData(list);
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
        Aim aim = list.get(position);

        if (aim.getFlatsNumbers().isEmpty()){
            view.onChoiceMade(aim.getId(), 0);
        } else {
            view.showConcreteDialog(aim.getFlatsNumbers(), position);
        }
    }

    @Override
    public void onItemChosen(int position, int flat) {
        Aim aim = list.get(position);

        view.onChoiceMade(aim.getId(), flat);
    }
}
