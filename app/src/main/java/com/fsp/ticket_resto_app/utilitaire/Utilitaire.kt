package com.fsp.ticket_resto_app.utilitaire

/**
 * Formate un double pour l'affichage.
 * Si la valeur est un entier, elle est affichée sans décimale.
 * Sinon, elle est affichée avec deux décimales.
 *
 * @param value la valeur à formater.
 * @return la valeur formatée.
 */
fun simpleFormat(value: Double): String {
    val reponse = String.format("%.2f", value)
    if (value == value.toLong().toDouble()) {
        return String.format("%d", value.toLong())
    }
    return reponse
}
