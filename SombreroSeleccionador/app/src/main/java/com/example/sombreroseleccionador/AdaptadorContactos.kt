package com.example.sombreroseleccionador

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView


class AdaptadorContactos(context: Contactos?, c: Cursor?, flags: Int): CursorAdapter(context,c,flags) {
    private val CONTACT_ID_INDEXAR = 0
    private val DISPLAY_NOMBRE_INDEXAR = 1

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.apoyo_contactos,parent, false)
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        val idContactoVista = view?.findViewById<TextView>(R.id.contactoApoyo)
        val nombreVista = view?.findViewById<TextView>(R.id.nombreApoyo)
        val idnumero = cursor?.getInt(CONTACT_ID_INDEXAR)
        val nombre = cursor?.getString(DISPLAY_NOMBRE_INDEXAR)
        idContactoVista?.text = idnumero?.toString()
        nombreVista?.text = nombre
    }
}