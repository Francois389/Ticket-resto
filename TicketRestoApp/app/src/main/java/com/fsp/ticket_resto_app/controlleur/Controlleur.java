package com.fsp.ticket_resto_app.controlleur;

import com.fsp.ticket_resto_app.modele.mathematique.Decomposition;
import com.fsp.ticket_resto_app.ui.Accueil;
import com.fsp.ticket_resto_app.ui.Parametre;

public class Controlleur {

    /** Valeur par défaut du ticket 1*/
    private static final int VALEUR_TICKET_1_DEFAUT = 13;
    /** Valeur par défaut du ticket 2*/
    private static final int VALEUR_TICKET_2_DEFAUT = 8;

    private int montantAPayerSaisie;
    private boolean montantAPayerSaisieValide;
    private int valeurTicket1;
    private int valeurTicket2;

    private Accueil accueil;
    private Parametre parametre;

    public Controlleur(Accueil accueil, Parametre parametre) {
        valeurTicket1 = VALEUR_TICKET_1_DEFAUT;
        valeurTicket2 = VALEUR_TICKET_2_DEFAUT;
        montantAPayerSaisieValide = false;
        this.accueil = accueil;
        this.parametre = parametre;
    }

    public int getValeurTicket1() {
        return valeurTicket1;
    }

    public void setValeurTicket1(int valeurTicket1) {
        this.valeurTicket1 = valeurTicket1;
    }

    public int getValeurTicket2() {
        return valeurTicket2;
    }

    public void setValeurTicket2(int valeurTicket2) {
        this.valeurTicket2 = valeurTicket2;
    }

    public int getMontantAPayerSaisie() {
        return montantAPayerSaisie;
    }

    /**
     * @param montantAPayerSaisie
     */
    public void setMontantAPayerSaisie(String montantAPayerSaisie) {
        try {
            this.montantAPayerSaisie = Integer.parseInt(montantAPayerSaisie);
            montantAPayerSaisieValide = true;
        } catch (NumberFormatException e) {
            montantAPayerSaisieValide = false;
        }
    }

    public void calculer() {
        if (montantAPayerSaisieValide) {
            Decomposition decomposition
                    = new Decomposition(valeurTicket1, valeurTicket2,montantAPayerSaisie);

            //Affichage des resulat
            accueil.afficherResultatTicket1(decomposition.getNombreTicket1());
            accueil.afficherResultatTicket2(decomposition.getNombreTicket2());
            accueil.afficherResultatReste(decomposition.getReste());
        } else {
            //TODO Affichage d'un message d'erreur
            accueil.afficherMessageerreur("Le montant saisie n'est pas valide");
        }
    }
}
