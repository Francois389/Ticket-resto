package com.fsp.ticket_resto_app.ui.parametre;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fsp.ticket_resto_app.PersistanceKt;
import com.fsp.ticket_resto_app.R;
import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.utilitaire.Popup;

import static com.fsp.ticket_resto_app.utilitaire.UtilitaireKt.simpleFormat;

/**
 * Le controlleur de l'onget Paramétre.
 *
 * @author François de Saint Palais
 */
public class Parametre extends AppCompatActivity {

    private Controlleur controlleur;

    private Button btnEnregistrer;
    private EditText montantPremierTicket;
    private EditText montantDeuxiemeTicket;

    private static final String TAG = "Parametre";

    private void initialiseComposants() {
        btnEnregistrer = findViewById(R.id.btnEnregistrer);
        montantPremierTicket = findViewById(R.id.montantPremierTicket);
        montantDeuxiemeTicket = findViewById(R.id.montantDeuxiemeTicket);

        montantPremierTicket.setText(simpleFormat(controlleur.getValeurTicket1()));
        montantDeuxiemeTicket.setText(simpleFormat(controlleur.getValeurTicket2()));

        btnEnregistrer.setOnClickListener(v -> enregistrer());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.fragment_parametre);
        controlleur = Controlleur.getControlleur();

        initialiseComposants();
    }

    private void enregistrer() {
        String saisieValeurTicket1;
        String saisieValeurTicket2;

        saisieValeurTicket1 = montantPremierTicket.getText().toString();
        saisieValeurTicket2 = montantDeuxiemeTicket.getText().toString();

        if (saisieValeurTicket1.isEmpty() || saisieValeurTicket2.isEmpty()) {
            popupErreur("Veillez remplir les deux champs");
        } else {
            try {
                if (!saisieValeurTicket1.isEmpty()) {
                    double montantPremierTicket = Double.parseDouble(saisieValeurTicket1);
                    controlleur.setValeurTicket1(montantPremierTicket);
                }

                if (!saisieValeurTicket2.isEmpty()) {
                    double montantDeuxiemeTicket = Double.parseDouble(saisieValeurTicket2);
                    controlleur.setValeurTicket2(montantDeuxiemeTicket);
                }
                popupValidation("Les valeurs ont bien été enregistrées");
                setResult(RESULT_OK);
                savePersistance();
                finish();
            } catch (IllegalArgumentException e) {
                popupErreur("Veillez saisir un nombre entier positif");
            }
        }
    }

    private void popupErreur(String message) {
        Popup.Companion.showErreur(message, this);
    }

    private void popupValidation(String message) {
        Popup.Companion.showInformation(message, this);
    }

    private void savePersistance() {
        Log.d(TAG, "savePersistance: ");
        if (controlleur != null) {
            PersistanceKt.sauvegarderValeurs(controlleur.getValeurTicket1(), controlleur.getValeurTicket2(), this);
        }
    }
}