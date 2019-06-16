package com.example.proyectocalculadora

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast

/**
 * Principal: Pantalla principal del programa.
 * Permite elegir entre: Calculadora Cientifica,
 * Calculadora Estándar, Mis Funciones y Otras Operaciones.
 */
class Principal : ActivityPadre() {

    internal lateinit var opcCientifica:Button
    internal lateinit var opcEstandar:Button
    internal lateinit var opcOtras:Button
    internal lateinit var opcFunciones:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        encontrarElementos()
        estalecerEventos()
    }

    private fun estalecerEventos() {

        opcEstandar.setOnClickListener { mostrarEstandar()}
        opcCientifica.setOnClickListener { mostrarCientifica() }
        opcOtras.setOnClickListener { mostrarOtras() }
        opcFunciones.setOnClickListener { mostrarFunciones() }
    }

    private fun encontrarElementos() {

        opcEstandar = findViewById<View>(R.id.opcEstandar) as Button
        opcCientifica = findViewById<View>(R.id.opcCientifica) as Button
        opcOtras = findViewById<View>(R.id.opcOtras) as Button
        opcFunciones = findViewById<View>(R.id.opcFunciones) as Button
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
        val intent = Intent(this, ActivityHerramientas::class.java)
        startActivityForResult(intent, 0)
    }

    private fun mostrarFunciones() {
        val intent = Intent(this, ActivityFunciones::class.java)
        startActivityForResult(intent, 0)
    }

    override fun onBackPressed() {
        val builder = android.support.v7.app.AlertDialog.Builder(this)
        builder.setMessage("¿Desea Salir?")
        builder.setTitle("MENSAJE:")

        builder.setPositiveButton(
            "Si"
        ) { dialog, which -> finish()}

        builder.setNegativeButton(
            "No"
        ) { dialog, which -> dialog.cancel() }
        val dialog = builder.create()
        dialog.show()



    }
}
