/*
 * Controlleur.java                                   20 août 2023
 * François de Saint Palais, aucun droit réservé
 */

package com.fsp.ticket_resto_app.controlleur;

import com.fsp.ticket_resto_app.donnee.mathematique.Decomposition;

/**
 * Gére les interactions de l'utilisateur avec l'application.
 * @autor François de Saint Palais
 */
public class Controlleur {

    private static Controlleur instance = null;

    private Decomposition decomposition;

    /**
     * Constructeur privé pour le singleton.
     */
    private Controlleur() {
        super();
        decomposition = new Decomposition();
    }

    public static Controlleur getControlleur() {
        if (instance == null) {
            instance = new Controlleur();
        }
        return instance;
    }

    public void setMontantAPayer(double montant) {
        decomposition.setMontant(montant);
    }

    public int getQuantiteTicket1() {
        return decomposition.decomposeNbPremierValeur();
    }

    public int getQuantiteTicket2() {
        return decomposition.decomposeNbDeuxiemeValeur();
    }

    public double getReste() {
        return decomposition.decomposeReste();
    }

    public void setValeurTicket1(int valeur) {
        decomposition.setPremiereValeur(valeur);
    }

    public void setValeurTicket2(int valeur) {
        decomposition.setDeuxiemeValeur(valeur);
    }

    public double getValeurTicket1() {
        return decomposition.getPremiereValeur();
    }

    public double getValeurTicket2() {
        return decomposition.getDeuxiemeValeur();
    }
}
