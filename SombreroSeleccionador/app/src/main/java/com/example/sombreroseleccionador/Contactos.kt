package com.example.sombreroseleccionador

import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Contactos : AppCompatActivity() {

    //mProjection
    var proyeccion: Array<String>? = null
    //mCursor
    var cursorcito: Cursor? = null
    //mContactsAdapter
    var adapContactos:AdaptadorContactos? = null
    var listita: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        permisos()

        val fondo = findViewById<RelativeLayout>(R.id.listotaGrande)
        infoCasas(fondo)

        listita = findViewById(R.id.listota)
        proyeccion = arrayOf(ContactsContract.Profile._ID, ContactsContract.Profile.DISPLAY_NAME_PRIMARY )
        adapContactos = AdaptadorContactos(this, null, 0)
        cursorcito = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, proyeccion, null, null, null)
        listita?.adapter = adapContactos

        inicializarVisualizacion()
    }


    fun permisos(){
        when {
            ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED -> {
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this, android.Manifest.permission.READ_CONTACTS) -> {
                requestPermissions(
                    arrayOf(android.Manifest.permission.READ_CONTACTS),
                    Permisos.REQUEST_READ_CONTACTS)
            }
            else -> {
                requestPermissions(
                    arrayOf(android.Manifest.permission.READ_CONTACTS),
                    Permisos.REQUEST_READ_CONTACTS)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            Permisos.REQUEST_READ_CONTACTS ->{
                if (requestCode == Permisos.REQUEST_READ_CONTACTS && resultCode == RESULT_OK) {
                    //ok
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Permisos.REQUEST_READ_CONTACTS -> {
                //If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this, "Invita a tus amigos a tomar cerveza de mantequilla", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No puedes invitar a tus amigos a tomar cerveza de mantequilla", Toast.LENGTH_SHORT).show()
                }
                return
            }
            else -> {
                // Ignore all other requests.
            }
        }
    }

    fun inicializarVisualizacion(){
        if(ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.READ_CONTACTS)==PackageManager.PERMISSION_GRANTED){
            cursorcito = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, proyeccion, null, null, null)
            adapContactos?.changeCursor(cursorcito)
        }
    }

    fun infoCasas(fondo: RelativeLayout) {
        when (SeleccionCasa.casaSeleccionadaFinal) {
            "Ravenclaw" -> {
                val colorFondo = resources.getColor(R.color.Ravenclaw)
                fondo.setBackgroundColor(colorFondo)
            }

            "Slytherin" -> {
                val colorFondo = resources.getColor(R.color.Slytherin)
                fondo.setBackgroundColor(colorFondo)
            }

            "Gryffindor" -> {
                val colorFondo = resources.getColor(R.color.Gryffindor)
                fondo.setBackgroundColor(colorFondo)
            }

            "Hufflepuff" -> {
                val colorFondo = resources.getColor(R.color.Hufflepuff)
                fondo.setBackgroundColor(colorFondo)

            }
        }
    }
}