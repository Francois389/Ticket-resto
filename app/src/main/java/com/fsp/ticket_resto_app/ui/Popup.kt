package com.fsp.ticket_resto_app.ui

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class Popup(
    val title: String,
    val message: String,
    val context: Context
) {

    private lateinit var builder: AlertDialog.Builder;

    init {
        builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setNegativeButton(
            "Ok",
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
    }

    fun show() {
        builder.show()
    }

    companion object {
        fun showErreur(message: String, context: Context) {
            val popup = Popup("Erreur", message, context)
            popup.show()
        }

        fun showInformation(message: String, context: Context) {
            val popup = Popup("Information", message, context)
            popup.show()
        }
    }
}

