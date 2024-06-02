package com.fsp.ticket_resto_app.utilitaire

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class Popup(
    private val title: String,
    private val message: String,
    private val context: Context
) {

    private var builder: AlertDialog.Builder = AlertDialog.Builder(context);

    init {
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setNegativeButton("Ok") { dialog, _ -> dialog.dismiss() }
    }

    fun show(): AlertDialog = builder.show()
}

fun showErreur(message: String, context: Context) {
    val popup = Popup("Erreur", message, context)
    popup.show()
}

fun showInformation(message: String, context: Context) {
    val popup = Popup("Information", message, context)
    popup.show()
}

