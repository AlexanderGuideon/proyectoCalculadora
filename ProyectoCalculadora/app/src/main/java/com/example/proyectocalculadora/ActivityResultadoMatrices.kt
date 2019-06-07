package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.content.Intent



class ActivityResultadoMatrices : ActivityPadre() {

    private lateinit var txtResultado: EditText

    private lateinit var btVolver: Button

    private lateinit var matriz: Matriz

    private var onClickVolver: View.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_matrices)
        obtenerElementos()
        establecerEventos()
        registrarEventos()
    }

    private fun registrarEventos() {
        btVolver.setOnClickListener(onClickVolver)
    }

    private fun establecerEventos() {
        onClickVolver = View.OnClickListener { v ->
            val intent = Intent(this, ActivityMatrices::class.java)
            intent.putExtra("matriz",matriz)
            startActivity(intent)
        }
    }

    private fun obtenerElementos() {
        txtResultado = findViewById<View>(R.id.edtContent) as EditText

        btVolver = findViewById<View>(R.id.btVolver) as Button
    }
}
