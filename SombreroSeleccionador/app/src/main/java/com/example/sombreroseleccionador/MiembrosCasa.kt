package com.example.sombreroseleccionador

import android.os.Bundle
import org.json.JSONObject
import android.widget.ListView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MiembrosCasa : AppCompatActivity(){

    lateinit var miembrosCasa: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_miembros_casa)

        val fondo = findViewById<RelativeLayout>(R.id.activityMiembrosPagina)
        infoCasas(fondo)

        val listaMiembros = findViewById<ListView>(R.id.listaMiembros)
        miembrosCasa = mutableListOf()

        datosListView()
        adaptadorListView()

    }

    fun datosListView(){
        val datosJson = JSONObject(loadJSONFromAsset())
        val miembrosDatos = datosJson.getJSONArray("miembros")

        for( i in 0 until miembrosDatos.length()){
            val datosMiembro = miembrosDatos.getJSONObject(i)
            miembrosCasa.add(datosMiembro.getString("nombre"))
        }
    }

    fun adaptadorListView(){

    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val istream: InputStream = assets.open("miembros.json")
            val size: Int = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        val jsonObject = JSONObject(json)
        return json
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