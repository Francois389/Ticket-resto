package com.fsp.ticket_resto_app.ui.accueil;

import android.icu.util.Currency;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.R;
import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.databinding.FragmentAccueilBinding;

import java.util.Locale;

/**
 * Le controlleur de l'onget Accueil.
 * @author François de Saint Palais
 */
public class Accueil extends Fragment {

    private FragmentAccueilBinding binding;
    private Controlleur controlleur;

    private static String symboleMonnaie = Currency.getInstance(Locale.getDefault()).getSymbol();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccueilBinding.inflate(inflater, container, false);
        controlleur = Controlleur.getControlleur();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.labelPremierTicket.setText(getString(R.string.txt_montant_ticket_1) + " " + controlleur.getValeurTicket1() + symboleMonnaie);
        binding.labelSecondTicket.setText(getString(R.string.txt_montant_ticket_2) + " " + controlleur.getValeurTicket2() + symboleMonnaie);
        binding.quantitePremierTicket.setText(0 + "");
        binding.quantiteSecondTicket.setText(0 + "");
        binding.valeurReste.setText(0 + symboleMonnaie);
        binding.btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void calculer() {

        String textSaisie;
        textSaisie = binding.montantAPayer.getText().toString();
        if (textSaisie.isEmpty()) {
            popupErreur("Veillez saisir un montant");
        } else {
            try {
                int montant = Integer.parseInt(textSaisie);
                controlleur.setMontantAPayer(montant);
                binding.quantitePremierTicket.setText(controlleur.getQuantiteTicket1()+"");
                binding.quantiteSecondTicket.setText(controlleur.getQuantiteTicket2()+"");
                binding.valeurReste.setText(controlleur.getReste()+ Currency.getInstance(Locale.getDefault()).getSymbol());
            } catch (NumberFormatException e) {
                popupErreur("Veillez saisir un entier");
            } catch (IllegalArgumentException e) {
                popupErreur("Vous devez saisir une valeur positive");
            }
        }
    }

    private void popupErreur(String message) {
        //TODO afficher une popup d'erreur
    }

}