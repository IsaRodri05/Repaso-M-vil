package com.example.sombreroseleccionador

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MenuCasa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_casa)

        val fondo = findViewById<RelativeLayout>(R.id.menuFondo)
        val imagenCasaSelecc = findViewById<ImageView>(R.id.imagenMiembrosCasa)
        val contactos = findViewById<TextView>(R.id.contactos)
        val miembrosCasa = findViewById<TextView>(R.id.mimebrosCasa)
        val camara = findViewById<TextView>(R.id.camara)

        infoCasas(fondo,imagenCasaSelecc)

        contactos.setOnClickListener{
            val intentContactos = Intent(this, Contactos::class.java)
            startActivity(intentContactos)
        }

        miembrosCasa.setOnClickListener{
            val intentMiembrosCasa = Intent(this, MiembrosCasa::class.java)
            startActivity(intentMiembrosCasa)
        }

        camara.setOnClickListener{
            val intentCamara = Intent(this, Camara::class.java)
            startActivity(intentCamara)
        }

    }

    fun infoCasas(fondo: RelativeLayout, imagenCasaSelecc: ImageView){
        when(SeleccionCasa.casaSeleccionadaFinal){
            "Ravenclaw" -> {
                val colorFondo= resources.getColor(R.color.Ravenclaw)
                fondo.setBackgroundColor(colorFondo)
                imagenCasaSelecc.setImageResource(R.drawable.ravenclaw)
            }
            "Slytherin" -> {
                val colorFondo= resources.getColor(R.color.Slytherin)
                fondo.setBackgroundColor(colorFondo)
                imagenCasaSelecc.setImageResource(R.drawable.slytherin)
            }
            "Gryffindor" -> {
                val colorFondo= resources.getColor(R.color.Gryffindor)
                fondo.setBackgroundColor(colorFondo)
                imagenCasaSelecc.setImageResource(R.drawable.gryffindor)
            }
            "Hufflepuff" -> {
                val colorFondo= resources.getColor(R.color.Hufflepuff)
                fondo.setBackgroundColor(colorFondo)
                imagenCasaSelecc.setImageResource(R.drawable.hufflepuff)
            }
        }
    }

}