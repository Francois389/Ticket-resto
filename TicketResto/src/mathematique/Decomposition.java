/*
 * Decomposition.java                                    20 août 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 */

package mathematique;

/** TODO comment class responsibility (SRP)
 * Étant donnée deux entier positif et un montant réel positif,
 * calcul une décomposition de ce montant. 
 * @author François
 */
public class Decomposition {

    /** Le premier entier pour la  decomposition */
    private int premiereValeur;
    /** Le deuxième entier pour la  decomposition */
    private int deuxiemeValeur;
    /** Le montant à décomposé */
    private int montant;
    
    /** TODO comment initial state properties
     * @param premiereValeur
     * @param deuxiemeValeur
     * @param montant
     */
    public Decomposition(int premiereValeur, int deuxiemeValeur, int montant) {
        super();
        if (premiereValeur <= 0 || deuxiemeValeur <= 0 || montant <= 0) {
            throw new IllegalArgumentException("Erreur : Vous devez saisir une valeur positive");
        }
        this.premiereValeur = premiereValeur;
        this.deuxiemeValeur = deuxiemeValeur;
        this.montant = montant;
    }
    
    /**
     * Le valeur devront être set plus tard.
     */
    public Decomposition() {
        super();
    }
    
    /**
     * Décompose montant en somme
     * de premiereValeur et
     * de deuxiemeValeur avec un reste.
     * @return Un tableau contenant
     * le nombre de premiereValeur en indice 0
     * le nombre de deuxiemeValeur en indice 1 et
     * le reste en indice 3.
     */
    public int[] decomposer() {
        //TODO Issue #1 La place des valeurs ne sont pas gardé
        int[] resultat = new int[3];
        int reste = montant;
        int valeurPetite = Math.min(premiereValeur, deuxiemeValeur);
        int valeurGrande = Math.max(premiereValeur, deuxiemeValeur);

        while (valeurPetite <= reste && reste != 0) {
            if (premiereValeur <= reste) {
                resultat[0]++;
                reste -= premiereValeur;
            }
            if (deuxiemeValeur <= reste) {
                resultat[1]++;
                reste -= deuxiemeValeur;
            }
        }
        resultat[2] = reste;
        return resultat;
    }
    
    /**
     * Decompose le montant mais ne renvoie que le nombre de deuxiemeValeur.
     * @return le nombre de deuxiemeValeur nessecaire pour décomposer le montant
     */
    public int decomposeNbDeuxiemeValeur () {
        return decomposer()[1];
    }

    /**
     * Decompose le montant mais ne renvoie que le nombre de premierValeur.
     * @return le nombre de premierValeur nessecaire pour décomposer le montant.
     */
    public int decomposeNbPremierValeur () {
        return decomposer()[0];
    }

    /**
     * @return la valeur du reste de la decomposition.
     */
    public int decomposeReste () {
        return decomposer()[2];
    }

    /** @return valeur de premiereValeur */
    public int getPremiereValeur() {
        return premiereValeur;
    }

    /** @return valeur de deuxiemeValeur */
    public int getDeuxiemeValeur() {
        return deuxiemeValeur;
    }
    
    /** @return valeur de montant */
    public int getMontant() {
        return montant;
    }

    /** @param premiereValeur nouvelle valeur de premiereValeur */
    public void setPremiereValeur(int premiereValeur) {
        if (premiereValeur <= 0) {
            throw new IllegalArgumentException("Erreur : Vous devez saisir une valeur positive");
        }
        this.premiereValeur = premiereValeur;
    }

    /** @param deuxiemeValeur nouvelle valeur de deuxiemeValeur */
    public void setDeuxiemeValeur(int deuxiemeValeur) {
        if (deuxiemeValeur <= 0) {
            throw new IllegalArgumentException("Erreur : Vous devez saisir une valeur positive");
        }
        this.deuxiemeValeur = deuxiemeValeur;
    }

    /** @param montant nouvelle valeur de montant */
    public void setMontant(int montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Erreur : Vous devez saisir une valeur positive");
        }
        this.montant = montant;
    }

    /* non javadoc - @see java.lang.Object#toString() */
    @Override
    public String toString() {
        return   "Decomposition [premiereValeur=" + premiereValeur 
               + ", deuxiemeValeur=" + deuxiemeValeur + ", montant="
               + montant + "]";
    }
    
    
    
}
