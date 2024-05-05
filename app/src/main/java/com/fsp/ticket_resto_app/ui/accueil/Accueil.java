package com.fsp.ticket_resto_app.ui.accueil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.util.Currency;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.R;
import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.databinding.FragmentAccueilBinding;

import java.util.Locale;

/**
 * Le controlleur de l'onget Accueil.
 *
 * @author François de Saint Palais
 */
public class Accueil extends Fragment {

    private FragmentAccueilBinding binding;
    private Controlleur controlleur;

    private static final String symboleMonnaie = Currency.getInstance(Locale.getDefault()).getSymbol();


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
        resetVue();
        binding.btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        resetVue();
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
                double montant = Double.parseDouble(textSaisie);
                controlleur.setMontantAPayer(montant);
                binding.quantitePremierTicket.setText(controlleur.getQuantiteTicket1() + "");
                binding.quantiteSecondTicket.setText(controlleur.getQuantiteTicket2() + "");
                binding.valeurReste.setText(controlleur.getReste() + Currency.getInstance(Locale.getDefault()).getSymbol());
                Log.d("Accueil", "calculer: " + controlleur.getValeurTicket1() + " " + controlleur.getValeurTicket2() + " " + montant);
            } catch (NumberFormatException e) {
                popupErreur("Veillez saisir un entier");
            } catch (IllegalArgumentException e) {
                popupErreur("Vous devez saisir une valeur positive");
            }
        }
    }

    /**
     * Remet à zéro les champs de l'interface graphique.
     */
    private void resetVue() {
        binding.labelPremierTicket.setText(String.format(getString(R.string.txt_label_quantite_ticket), simpleFormat(controlleur.getValeurTicket1())) + " " + symboleMonnaie);
        binding.labelSecondTicket.setText(String.format(getString(R.string.txt_label_quantite_ticket), simpleFormat(controlleur.getValeurTicket2())) + " " + symboleMonnaie);
        binding.quantitePremierTicket.setText("0");
        binding.quantiteSecondTicket.setText("0");
        binding.valeurReste.setText(0 + symboleMonnaie);
    }

    /**
     * Formate un double pour l'affichage.
     * Si la valeur est un entier, elle est affichée sans décimale.
     * Sinon, elle est affichée avec deux décimales.
     *
     * @param value la valeur à formater.
     * @return la valeur formatée.
     */
    private String simpleFormat(double value) {
        String reponse = String.format("%.2f", value);
        if (value == value.longValue()) {
            return String.format("%d", (long) value);
        }
        return reponse;
    }

    /**
     * Affiche une popup d'erreur.
     *
     * @param message le message à afficher.
     */
    private void popupErreur(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMessage(message);
        builder.setTitle("Attention");
        builder.setCancelable(true);

        builder.setNegativeButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void toastErreur(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

}