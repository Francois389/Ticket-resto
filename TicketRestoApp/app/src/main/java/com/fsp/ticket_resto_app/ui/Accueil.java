package com.fsp.ticket_resto_app.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.MainActivity;
import com.fsp.ticket_resto_app.databinding.FragmentAccueilBinding;

public class Accueil extends Fragment {


    private FragmentAccueilBinding binding;

    private


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccueilBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.controlleur.calculer();
            }
        });

        binding.montantAPayer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                MainActivity.controlleur.setMontantAPayerSaisie(editable.toString());
            }
        });
    }

    /**
     * Affiche une popup contenant le message d'erreur
     * @param message Le message d'erreur à afficher
     */
    public void afficherMessageerreur(String message) {
        //TODO
    }

    public void afficherResultatTicket1(int nombreTicket1) {
        binding.quantitePremierTicket.setText(String.valueOf(nombreTicket1));
    }

    public void afficherResultatTicket2(int nombreTicket2) {
        binding.quantiteDeuxiemeTicket.setText(String.valueOf(nombreTicket2));
    }

    public void afficherResultatReste(int reste) {
        binding.reste.setText(String.valueOf(reste));
    }
}