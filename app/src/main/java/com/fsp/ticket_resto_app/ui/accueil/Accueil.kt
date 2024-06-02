package com.fsp.ticket_resto_app.ui.accueil

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.icu.util.Currency
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.fsp.ticket_resto_app.R
import com.fsp.ticket_resto_app.chargerValeurs
import com.fsp.ticket_resto_app.controlleur.Controlleur
import com.fsp.ticket_resto_app.ui.parametre.Parametre
import com.fsp.ticket_resto_app.utilitaire.showErreur
import com.fsp.ticket_resto_app.utilitaire.simpleFormat
import java.util.Locale

/**
 * Le controlleur de l'onget Accueil.
 *
 * @author François de Saint Palais
 */
@SuppressLint("SetTextI18n")
class Accueil : AppCompatActivity() {

    private val TAG = "Accueil"

    private var btnCalculer: Button? = null
    private var btnParametre: Button? = null
    private var labelPremierTicket: TextView? = null
    private var labelSecondTicket: TextView? = null
    private var quantitePremierTicket: TextView? = null
    private var quantiteSecondTicket: TextView? = null
    private var valeurReste: TextView? = null
    private var montant: EditText? = null

    private val moneySymbol: String = Currency.getInstance(Locale.getDefault()).symbol

    private var goParametreLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_accueil)

        Log.d(TAG, "onCreate: Début")

        initialiseComposants()

        goParametreLauncher =
            registerForActivityResult<Intent, ActivityResult>(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                this.retourActivity(result)
            }

        loadPersistance()
        resetVue()

        Log.d(TAG, "onCreate: Fin")
    }

    private fun initialiseComposants() {
        btnCalculer = findViewById(R.id.btnCalculer)
        btnParametre = findViewById(R.id.btnParametre)
        labelPremierTicket = findViewById(R.id.labelPremierTicket)
        labelSecondTicket = findViewById(R.id.labelSecondTicket)
        quantitePremierTicket = findViewById(R.id.quantitePremierTicket)
        quantiteSecondTicket = findViewById(R.id.quantiteSecondTicket)
        valeurReste = findViewById(R.id.valeurReste)
        montant = findViewById(R.id.montantAPayer)

        Log.d(TAG, btnCalculer.toString())
        Log.d(TAG, btnParametre.toString())
        btnCalculer!!.setOnClickListener {
            calculer()
            Log.d(this.TAG, "onCreate: Click Caluler")
        }
        btnParametre!!.setOnClickListener {
            goParametre()
            Log.d(this.TAG, "onCreate: Click Parametre")
        }
    }

    private fun retourActivity(result: ActivityResult) {
        resetVue()
    }

    private fun calculer() {
        val saisieMontant = montant?.text.toString()
        if (saisieMontant.isEmpty()) {
            showErreur("Veuillez saisir un montant", this)
        } else {
            try {
                val montant = saisieMontant.toDouble()
                Controlleur.setMontantAPayer(montant)
                quantitePremierTicket?.text = "${Controlleur.quantiteTicket1}"
                quantiteSecondTicket?.text = "${Controlleur.quantiteTicket2}"
                valeurReste?.text = simpleFormat(Controlleur.reste) + moneySymbol
            } catch (e: NumberFormatException) {
                showErreur("Le montant saisi n'est pas valide", this)
            }
        }

    }

    /**
     * Remet à zéro les champs de l'interface graphique.
     */
    private fun resetVue() {
        labelPremierTicket?.text = "${simpleFormat(Controlleur.valeurTicket1)}$moneySymbol"
        labelSecondTicket?.text = "${simpleFormat(Controlleur.valeurTicket2)}$moneySymbol"

        quantitePremierTicket?.text = "0"
        quantiteSecondTicket?.text = "0"

        valeurReste?.text = "0$moneySymbol"
    }

    private fun goParametre() {
        val intent = Intent(this, Parametre::class.java)
        goParametreLauncher?.launch(intent)
    }

    private fun loadPersistance() {
        val valeurs = chargerValeurs(this)
        Controlleur.valeurTicket1 = valeurs.component1()
        Controlleur.valeurTicket2 = valeurs.component2()
    }
}