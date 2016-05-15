package com.sttimchenko.censushelper.aims;

import android.app.Activity;
import android.os.Bundle;

public interface AimsPresenter {
    void requestAdapterData();
    void onCreate(Activity activity, Bundle savedInstanceState);
    void onDestroy();
    void onItemChosen(int position);
    void onItemChosen(int position, int flat);
}
