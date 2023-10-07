package com.fsp.ticket_resto_app.ui.parametre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.R;

/**
 * Le controlleur de l'onget Paramétre.
 * @author François de Saint Palais
 */
public class Parametre extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parametre, container, false);
    }
}