package com.fsp.ticket_resto_app.ui.parametre

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.fsp.ticket_resto_app.R
import com.fsp.ticket_resto_app.controlleur.Controlleur
import com.fsp.ticket_resto_app.sauvegarderValeurs
import com.fsp.ticket_resto_app.utilitaire.showInformation
import com.fsp.ticket_resto_app.utilitaire.showErreur
import com.fsp.ticket_resto_app.utilitaire.simpleFormat

/**
 * Le controlleur de l'onget Paramétre.
 *
 * @author François de Saint Palais
 */
class Parametre : AppCompatActivity() {

    private var btnEnregistrer: Button? = null
    private var btnAnnuler: Button? = null
    private var montantPremierTicket: EditText? = null
    private var montantDeuxiemeTicket: EditText? = null

    private fun initialiseComposants() {

        btnEnregistrer = findViewById(R.id.btnEnregistrer)
        btnAnnuler = findViewById(R.id.btnAnnuler)
        montantPremierTicket = findViewById(R.id.montantPremierTicket)
        montantDeuxiemeTicket = findViewById(R.id.montantDeuxiemeTicket)

        montantPremierTicket?.setText(simpleFormat(Controlleur.valeurTicket1))
        montantDeuxiemeTicket?.setText(simpleFormat(Controlleur.valeurTicket2))

        btnEnregistrer?.setOnClickListener { enregistrer() }
        btnAnnuler?.setOnClickListener { finish() }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.fragment_parametre)


        initialiseComposants()
    }

    private fun enregistrer() {
        val saisieValeurTicket1 = montantPremierTicket!!.text.toString()
        val saisieValeurTicket2 = montantDeuxiemeTicket!!.text.toString()

        if (saisieValeurTicket1.isEmpty() || saisieValeurTicket2.isEmpty()) {
            popupErreur("Veillez remplir les deux champs")
        } else {
            try {
                if (saisieValeurTicket1.isNotEmpty()) {
                    val montantPremierTicket = saisieValeurTicket1.toDouble()
                    Controlleur.valeurTicket1 = montantPremierTicket
                }

                if (saisieValeurTicket2.isNotEmpty()) {
                    val montantDeuxiemeTicket = saisieValeurTicket2.toDouble()
                    Controlleur.valeurTicket2 = montantDeuxiemeTicket
                }
                popupValidation("Les valeurs ont bien été enregistrées")
                setResult(RESULT_OK)
                savePersistance()
                finish()
            } catch (e: IllegalArgumentException) {
                popupErreur("Veillez saisir un nombre entier positif")
            }
        }
    }

    private fun popupErreur(message: String) {
        if (!isFinishing) {
            showErreur(message, this)
        }
    }

    private fun popupValidation(message: String) {
        if (!isFinishing) {
            showInformation(message, this)
        }
    }

    private fun savePersistance() {
        Log.d(TAG, "savePersistance: ")
        sauvegarderValeurs(Controlleur.valeurTicket1, Controlleur.valeurTicket2, this)
    }

    companion object {
        private const val TAG = "Parametre"
    }
}