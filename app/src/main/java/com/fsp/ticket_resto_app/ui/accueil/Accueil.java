package com.fsp.ticket_resto_app.ui.accueil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Currency;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fsp.ticket_resto_app.PersistanceKt;
import com.fsp.ticket_resto_app.R;
import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.ui.parametre.Parametre;
import com.fsp.ticket_resto_app.utilitaire.Popup;

import static com.fsp.ticket_resto_app.utilitaire.UtilitaireKt.simpleFormat;

import java.util.Locale;

import kotlin.Pair;

/**
 * Le controlleur de l'onget Accueil.
 *
 * @author François de Saint Palais
 */
public class Accueil extends AppCompatActivity {

    private static final String TAG = "Accueil";

    private Controlleur controlleur;

    private Button btnCalculer;
    private Button btnParametre;
    private EditText montantAPayer;
    private TextView labelPremierTicket;
    private TextView labelSecondTicket;
    private TextView quantitePremierTicket;
    private TextView quantiteSecondTicket;
    private TextView valeurReste;

    private ActivityResultLauncher<Intent> goParametreLauncher;

    private void initialiseComposants() {
        btnCalculer = findViewById(R.id.btnCalculer);
        btnParametre = findViewById(R.id.btnParametre);
        montantAPayer = findViewById(R.id.montantAPayer);
        labelPremierTicket = findViewById(R.id.labelPremierTicket);
        labelSecondTicket = findViewById(R.id.labelSecondTicket);
        quantitePremierTicket = findViewById(R.id.quantitePremierTicket);
        quantiteSecondTicket = findViewById(R.id.quantiteSecondTicket);
        valeurReste = findViewById(R.id.valeurReste);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.fragment_accueil);

        initialiseComposants();
        controlleur = Controlleur.getControlleur();
        goParametreLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::retourActivity);

        btnCalculer.setOnClickListener(v -> calculer());
        btnParametre.setOnClickListener(v -> goParametre());

        loadPersistance();
        resetVue();
    }

    private void retourActivity(ActivityResult result) {
        resetVue();
    }

    private void calculer() {
        String textSaisie;
        textSaisie = montantAPayer.getText().toString();
        if (textSaisie.isEmpty()) {
            popupErreur("Veillez saisir un montant");
        } else {
            try {
                double montant = Double.parseDouble(textSaisie);
                controlleur.setMontantAPayer(montant);
                quantitePremierTicket.setText(controlleur.getQuantiteTicket1() + "");
                quantiteSecondTicket.setText(controlleur.getQuantiteTicket2() + "");
                valeurReste.setText(simpleFormat(controlleur.getReste()) + getMoneySymbol());
                Log.d("Accueil", "calculer: " + controlleur.getValeurTicket1() + " " + controlleur.getValeurTicket2() + " " + montant);
            } catch (NumberFormatException e) {
                popupErreur("Veillez saisir un entier");
            } catch (IllegalArgumentException e) {
                popupErreur("Vous devez saisir une valeur positive");
            }
        }
    }

    private static String getMoneySymbol() {
        return Currency.getInstance(Locale.getDefault()).getSymbol();
    }

    /**
     * Remet à zéro les champs de l'interface graphique.
     */
    private void resetVue() {
        labelPremierTicket.setText(String.format(getString(R.string.txt_label_quantite_ticket), simpleFormat(controlleur.getValeurTicket1())) + " " + getMoneySymbol());
        labelSecondTicket.setText(String.format(getString(R.string.txt_label_quantite_ticket), simpleFormat(controlleur.getValeurTicket2())) + " " + getMoneySymbol());
        quantitePremierTicket.setText("0");
        quantiteSecondTicket.setText("0");
        valeurReste.setText(0 + getMoneySymbol());
    }

    private void goParametre() {
        Intent intent = new Intent(this, Parametre.class);
        goParametreLauncher.launch(intent);
    }

    /**
     * Affiche une popup d'erreur.
     *
     * @param message le message à afficher.
     */
    private void popupErreur(String message) {
        Popup.Companion.showErreur(message, this);
    }

    private void toastErreur(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void loadPersistance() {
        if (controlleur != null) {
            kotlin.Pair<Double, Double> valeurs = PersistanceKt.chargerValeurs(this);
            controlleur.setValeurTicket1(valeurs.component1());
            controlleur.setValeurTicket2(valeurs.component2());
        }
    }
}