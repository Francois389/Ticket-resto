package com.fsp.ticket_resto_app.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> labelTicket1 = new MutableLiveData<>();

    private MutableLiveData<Integer> labelTicket2 = new MutableLiveData<>();

    public MutableLiveData<Integer> getLabelTicket1() {
        return labelTicket1;
    }

    public MutableLiveData<Integer> getLabelTicket2() {
        return labelTicket2;
    }

    public void updateLabel1(int nouvelleValeur) {
        labelTicket1.setValue(nouvelleValeur);
    }

    public void updateLabel2(int nouvelleValeur) {
        labelTicket2.setValue(nouvelleValeur);
    }
}
