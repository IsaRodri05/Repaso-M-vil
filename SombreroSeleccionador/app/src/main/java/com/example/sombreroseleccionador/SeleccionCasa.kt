package com.example.sombreroseleccionador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class SeleccionCasa : AppCompatActivity() {
    companion object{
        var casaSeleccionadaFinal = "Ninguna"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_casa)

        val botonSeleccion = findViewById<Button>(R.id.button_seleccion)
        val resultado = findViewById<TextView>(R.id.textResultado)
        val imagenResultado = findViewById<ImageView>(R.id.imagen_variante)
        val fondoColor = findViewById<RelativeLayout>(R.id.fondo)
        val textMenu = findViewById<TextView>(R.id.textMenu)

        botonSeleccion.setOnClickListener{
            seleccionCasa(resultado,imagenResultado,textMenu,fondoColor)
            textMenu.text = "Menu de $casaSeleccionadaFinal"
            habilitarBoton(botonSeleccion)
        }

        textMenu.setOnClickListener{
            val intentMenu = Intent(this, MenuCasa::class.java)
            startActivity(intentMenu)
        }

    }

    fun habilitarBoton(boton:Button){
        boton.isEnabled = false
    }

    fun seleccionCasa(resultado: TextView, imagenResultado: ImageView, textMenu: TextView, fondoColor :RelativeLayout){
        val numeros = 0 .. 3
        val numeroFinal:Int = numeros.random()
        val casas = listOf<String>("Ravenclaw","Slytherin","Gryffindor","Hufflepuff")

        val casaSeleccionada = casas[numeroFinal]
        when (numeroFinal){
            0 -> {
                imagenResultado.setImageResource(R.drawable.ravenclaw)
                val colorRavenclaw = resources.getColor(R.color.Ravenclaw)
                fondoColor.setBackgroundColor(colorRavenclaw)
                //fondoColor.setBackgroundColor(R.color.Ravenclaw.toInt())
                casaSeleccionadaFinal = casaSeleccionada
                val colorLetra = resources.getColor(R.color.RavenclawLetra)
                textMenu.setTextColor(colorLetra)
                //textMenu.setTextColor(R.color.RavenclawLetra.toInt())
            }
            1 -> {
                imagenResultado.setImageResource(R.drawable.slytherin)
                val colorSlytherin = resources.getColor(R.color.Slytherin)
                fondoColor.setBackgroundColor(colorSlytherin)
                //fondoColor.setBackgroundColor(R.color.Slytherin.toInt())
                casaSeleccionadaFinal = casaSeleccionada
                val colorLetra = resources.getColor(R.color.SlytherinLetra)
                textMenu.setTextColor(colorLetra)
                //textMenu.setTextColor(R.color.SlytherinLetra.toInt())
            }
            2 -> {
                imagenResultado.setImageResource(R.drawable.gryffindor)
                val colorGryffindor = resources.getColor(R.color.Gryffindor)
                fondoColor.setBackgroundColor(colorGryffindor)
                //fondoColor.setBackgroundColor(R.color.Gryffindor.toInt())
                casaSeleccionadaFinal = casaSeleccionada
                val colorLetra = resources.getColor(R.color.GryffindorLetra)
                textMenu.setTextColor(colorLetra)
                //textMenu.setTextColor(R.color.GryffindorLetra.toInt())
            }
            3 -> {
                imagenResultado.setImageResource(R.drawable.hufflepuff)
                val colorHufflepuff = resources.getColor(R.color.Hufflepuff)
                fondoColor.setBackgroundColor(colorHufflepuff)
                //fondoColor.setBackgroundColor(R.color.Hufflepuff.toInt())
                casaSeleccionadaFinal = casaSeleccionada
                val colorLetra = resources.getColor(R.color.HufflepuffLetra)
                textMenu.setTextColor(colorLetra)
                //textMenu.setTextColor(R.color.HufflepuffLetra.toInt())
            }
        }
        resultado.text = "Fuiste seleccionado para la casa: $casaSeleccionada"
    }
}