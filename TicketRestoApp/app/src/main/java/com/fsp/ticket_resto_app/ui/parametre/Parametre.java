package com.fsp.ticket_resto_app.ui.parametre;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.icu.util.Currency;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.fsp.ticket_resto_app.R;
import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.databinding.FragmentAccueilBinding;
import com.fsp.ticket_resto_app.databinding.FragmentParametreBinding;
import com.fsp.ticket_resto_app.viewModel.MyViewModel;

import java.util.Locale;

/**
 * Le controlleur de l'onget Paramétre.
 * @author François de Saint Palais
 */
public class Parametre extends Fragment {

    private FragmentParametreBinding binding;
    private FragmentAccueilBinding bindingAccueil;
    private Controlleur controlleur;

    private MyViewModel viewModel;

    private static String symboleMonnaie = Currency.getInstance(Locale.getDefault()).getSymbol();

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Créez une instance du ViewModel
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
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
                //TODO mettre à jour le label de l'accueil
                viewModel.updateLabel1(montantPremierTicket);
            }

            if (!saisieValeurTicket2.isEmpty()) {
                int montantDeuxiemeTicket = Integer.parseInt(binding.montantDeuxiemeTicket.getText().toString());
                controlleur.setValeurTicket2(montantDeuxiemeTicket);
                //TODO mettre à jour le label de l'accueil
                viewModel.updateLabel2(montantDeuxiemeTicket);

            }
            popupValidation("Les valeurs ont bien été enregistrées");
        } catch (NumberFormatException e) {
            popupErreur("Veillez saisir un nombre entier positif");
        } catch (IllegalArgumentException e) {
            popupErreur("Veillez saisir un nombre entier positif");
        }

    }

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
    private void popupValidation(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMessage(message);
        builder.setTitle("Information");
        builder.setCancelable(true);

        builder.setNegativeButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}