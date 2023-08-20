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
    
}
