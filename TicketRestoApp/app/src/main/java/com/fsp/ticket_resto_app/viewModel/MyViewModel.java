package com.fsp.ticket_resto_app.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> myTextLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> getTextLiveData() {
        return myTextLiveData;
    }

    public void updateText(int newText) {
        myTextLiveData.setValue(newText);
    }
}
