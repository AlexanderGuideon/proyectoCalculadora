package com.example.proyectocalculadora

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)


        val opcEstandar = findViewById<View>(R.id.opcEstandar) as Button
        val opcCientifica = findViewById<View>(R.id.opcCientifica) as Button
        val opcOtras = findViewById<View>(R.id.opcOtras) as Button
        val opcFunciones = findViewById<View>(R.id.opcFunciones) as Button


        opcEstandar.setOnClickListener { mostrarEstandar()}

        opcCientifica.setOnClickListener { mostrarCientifica() }

        opcOtras.setOnClickListener { mostrarOtras() }

        opcFunciones.setOnClickListener { mostrarFunciones() }
    }

    private fun  mostrarEstandar() {

        val intent = Intent(this, ActivityEstandar::class.java)
        startActivityForResult(intent, 0)
    }

    private fun mostrarCientifica() {
        val intent = Intent(this, ActivityCientifica::class.java)
        startActivityForResult(intent, 0)
    }

    private fun mostrarOtras() {
        Toast.makeText(this, "Estamos trabajando en ello", Toast.LENGTH_LONG).show()
    }

    private fun mostrarFunciones() {
        Toast.makeText(this, "Estamos trabajando en ello", Toast.LENGTH_LONG).show()
    }
}