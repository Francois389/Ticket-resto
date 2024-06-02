package com.fsp.ticket_resto_app

import android.content.Context

private const val FILE_NAME = "ticket_resto_app_data"

private const val KEY_PREMIERE_VALEUR = "premiere_valeur"
private const val KEY_DEUXIEME_VALEUR = "deuxieme_valeur"

fun sauvegarderValeurs(premiereValeur: Double, deuxiemeValeur: Double, context: Context) {
    val sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putFloat(KEY_PREMIERE_VALEUR, premiereValeur.toFloat())
    editor.putFloat(KEY_DEUXIEME_VALEUR, deuxiemeValeur.toFloat())
    editor.apply()
}

fun chargerValeurs(context: Context): Pair<Double, Double> {
    val sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    val premiereValeur = sharedPreferences.getFloat(KEY_PREMIERE_VALEUR, 8.0f).toDouble()
    val deuxiemeValeur = sharedPreferences.getFloat(KEY_DEUXIEME_VALEUR, 13.0f).toDouble()
    return Pair(premiereValeur, deuxiemeValeur)
}
