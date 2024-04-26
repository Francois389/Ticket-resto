import kotlin.math.min
import kotlin.math.max


class Decomposition (
    private var premiereValeur : Int = 8,
    private var deuxiemeValeur : Int = 13,
    private var montant : Int){

    fun getPremiereValeur() : Int {
        return this.premiereValeur
    }
    fun getDeuxiemeValeur() : Int {
        return this.deuxiemeValeur
    }
    fun getMontant() : Int {
        return this.montant
    }

    fun setPremiereValeur(nouvelleValeur : Int){
        this.premiereValeur = nouvelleValeur
    }
    fun setDeuxiemeValeur(nouvelleValeur : Int) {
        this.deuxiemeValeur = nouvelleValeur
    }
    fun setMontant(nouvelleValeur : Int) {
        this.montant = nouvelleValeur
    }

    fun decomposition(): IntArray {
        val resultat = IntArray(3)
        var reste = montant
        val valeurPetite: Int = min(premiereValeur, deuxiemeValeur)

        while (valeurPetite <= reste && reste != 0) {
            if (premiereValeur <= reste) {
                resultat[0]++
                reste -= premiereValeur
            }
            if (deuxiemeValeur <= reste) {
                resultat[1]++
                reste -= deuxiemeValeur
            }
        }
        resultat[2] = reste
        return resultat
    }


}