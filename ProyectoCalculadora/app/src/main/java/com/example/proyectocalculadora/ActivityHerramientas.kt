package com.example.proyectocalculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast

class ActivityHerramientas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_herramientas)

        val btEcuaciones = findViewById<Button>(R.id.opcionEcuaciones)
        val btMatrices = findViewById<Button>(R.id.opcionMatrices)

        btEcuaciones.setOnClickListener {
            accionEcuaciones()
        }

        btMatrices.setOnClickListener {
            accionMatrices()
        }
    }

    private fun accionEcuaciones(){
        Toast.makeText(this, "Estamos trabajando en ello", Toast.LENGTH_LONG).show()
    }

    private fun accionMatrices() {
        Toast.makeText(this, "Estamos trabajando en ello", Toast.LENGTH_LONG).show()
    }
}
