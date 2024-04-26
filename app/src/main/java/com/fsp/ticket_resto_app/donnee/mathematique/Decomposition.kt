package com.fsp.ticket_resto_app.donnee.mathematique

import kotlin.math.min

class Decomposition(
        var premiereValeur: Double = 8.0,
        var deuxiemeValeur: Double = 13.0,
        var montant: Double = 0.0
) {

    private var reste: Double = 0.0
    private var nbPremiereValeur: Int = 0
    private var nbDeuxiemeValeur: Int = 0

    private fun decomposition() {
        reste = montant
        val valeurPetite: Double = min(premiereValeur, deuxiemeValeur)

        while (valeurPetite <= reste && reste != 0.0) {
            if (premiereValeur <= reste) {
                nbPremiereValeur++
                reste -= premiereValeur
            }
            if (deuxiemeValeur <= reste) {
                nbDeuxiemeValeur++
                reste -= deuxiemeValeur
            }
        }
    }

    fun decomposeNbPremierValeur(): Int {
        val resultat = decomposition()
        return nbPremiereValeur
    }

    fun decomposeNbDeuxiemeValeur(): Int {
        val resultat = decomposition()
        return nbDeuxiemeValeur
    }

    fun decomposeReste(): Double {
        val resultat = decomposition()
        return reste
    }

}