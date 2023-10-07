package com.fsp.ticket_resto_app.ui.parametre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.R;
import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.databinding.FragmentParametreBinding;

/**
 * Le controlleur de l'onget Paramétre.
 * @author François de Saint Palais
 */
public class Parametre extends Fragment {

    private FragmentParametreBinding binding;
    private Controlleur controlleur;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentParametreBinding.inflate(inflater, container, false);
        controlleur = Controlleur.getControlleur();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.montantPremierTicket.setText(controlleur.getValeurTicket1() + "");
        binding.montantDeuxiemeTicket.setText(controlleur.getValeurTicket2() + "");
        binding.btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enregistrer();
            }
        });
    }
}