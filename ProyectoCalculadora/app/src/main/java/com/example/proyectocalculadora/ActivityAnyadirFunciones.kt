package com.example.proyectocalculadora

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_anyadir_funciones.*

class ActivityAnyadirFunciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anyadir_funciones)

        val btAnyadir = findViewById<Button>(R.id.btAnyadir)

        btAnyadir.setOnClickListener {
            accionAnyadir()
        }
    }

    private fun accionAnyadir(){

        val txtExpresion :TextView = findViewById(R.id.txtResultado)
        val funciones = SQLiteOpenHelperFunciones(this, "funciones", null, 1)
        val bd = funciones.writableDatabase
        val registro = ContentValues()
        val n = 0
        registro.put("codigo", n)
        registro.put("nombre", txtNombre.getText().toString())
        registro.put("expresion", txtExpresion.getText().toString())
        bd.insert("funciones", null, registro)
        bd.close()
        txtNombre.setText("")
        txtExpresion.setText("")

        Toast.makeText(this, "Añadida Correctamente", Toast.LENGTH_LONG).show()
    }
}
