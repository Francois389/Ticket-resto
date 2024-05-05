package com.fsp.ticket_resto_app.ui.parametre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.databinding.FragmentParametreBinding;
import com.fsp.ticket_resto_app.utilitaire.Popup;

/**
 * Le controlleur de l'onget Paramétre.
 *
 * @author François de Saint Palais
 */
public class Parametre extends Fragment {

    private FragmentParametreBinding binding;
    private Controlleur controlleur;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentParametreBinding.inflate(inflater, container, false);
        controlleur = Controlleur.getControlleur();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.montantPremierTicket.setText(controlleur.getValeurTicket1() + "");
        binding.montantDeuxiemeTicket.setText(controlleur.getValeurTicket2() + "");
        binding.btnEnregistrer.setOnClickListener(v -> enregistrer());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void enregistrer() {
        String saisieValeurTicket1;
        String saisieValeurTicket2;

        saisieValeurTicket1 = binding.montantPremierTicket.getText().toString();
        saisieValeurTicket2 = binding.montantDeuxiemeTicket.getText().toString();

        try {
            if (!saisieValeurTicket1.isEmpty()) {
                int montantPremierTicket = Integer.parseInt(binding.montantPremierTicket.getText().toString());
                controlleur.setValeurTicket1(montantPremierTicket);
            }

            if (!saisieValeurTicket2.isEmpty()) {
                int montantDeuxiemeTicket = Integer.parseInt(binding.montantDeuxiemeTicket.getText().toString());
                controlleur.setValeurTicket2(montantDeuxiemeTicket);

            }
            popupValidation("Les valeurs ont bien été enregistrées");
        } catch (IllegalArgumentException e) {
            popupErreur("Veillez saisir un nombre entier positif");
        }

    }

    private void popupErreur(String message) {
        Popup.Companion.showErreur(message, getContext());
    }

    private void popupValidation(String message) {
        Popup.Companion.showInformation(message, getContext());
    }
}