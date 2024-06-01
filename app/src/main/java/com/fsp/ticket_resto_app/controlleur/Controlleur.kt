/*
 * Controlleur.java                                   20 août 2023
 * François de Saint Palais, aucun droit réservé
 */
package com.fsp.ticket_resto_app.controlleur

import com.fsp.ticket_resto_app.donnee.mathematique.Decomposition

/**
 * Gére les interactions de l'utilisateur avec l'application.
 * @autor François de Saint Palais
 */
object Controlleur {
    private val decomposition = Decomposition()

    fun setMontantAPayer(montant: Double) {
        decomposition.montant = montant
    }

    val quantiteTicket1: Int
        get() = decomposition.decomposeNbPremierValeur()

    val quantiteTicket2: Int
        get() = decomposition.decomposeNbDeuxiemeValeur()

    val reste: Double
        get() = decomposition.decomposeReste()

    var valeurTicket1: Double
        get() = decomposition.premiereValeur
        set(valeur) {
            decomposition.premiereValeur = valeur
        }

    var valeurTicket2: Double
        get() = decomposition.deuxiemeValeur
        set(valeur) {
            decomposition.deuxiemeValeur = valeur
        }
}
