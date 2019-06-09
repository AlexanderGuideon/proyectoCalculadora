package com.example.proyectocalculadora

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast

class ActivityHerramientas : ActivityPadre() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_herramientas)

        val btEcuaciones = findViewById<Button>(R.id.opcionEcuaciones)

        val btMcmMcd = findViewById<Button>(R.id.opcionMcmMcd)
        val btVozTexto = findViewById<Button>(R.id.opcionVozTexto)

        btEcuaciones.setOnClickListener {
            accionEcuaciones()
        }


        btMcmMcd.setOnClickListener {
            accionMcmMcd()
        }

        btVozTexto.setOnClickListener {
            accionVozTexto()
        }
    }

    private fun accionVozTexto() {
        val intent = Intent(this, ReconocimentoVoz::class.java)
        startActivityForResult(intent, 0)
    }

    private fun accionMcmMcd() {
        val intent = Intent(this, ActivityComunes::class.java)
        startActivityForResult(intent, 0)
    }

    private fun accionEcuaciones(){
        val intent = Intent(this, ActivityEcuacion::class.java)
        startActivityForResult(intent, 0)
    }


}
