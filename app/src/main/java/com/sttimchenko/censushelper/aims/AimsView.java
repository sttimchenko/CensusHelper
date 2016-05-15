package com.sttimchenko.censushelper.aims;

import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

public interface AimsView {
    void onAdapterData(List<Aim> list);
    void onChoiceMade(int aimId, int flatNumber);
    void showConcreteDialog(List<String> list, int index);
}
