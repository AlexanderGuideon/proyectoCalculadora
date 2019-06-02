package com.example.proyectocalculadora


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ActivityRellenaMatriz : ActivityPadre() {


    private lateinit var txtFilas: EditText
    private lateinit var txtColumnas: EditText
    private lateinit var txtDato: EditText

    private lateinit var btIntroFilasColumnas: Button
    private lateinit var btIntroDato: Button
    private lateinit var btAutoRellena: Button
    private lateinit var btCrearMatriz: Button

    private var onClickIntroFilasColumnas: View.OnClickListener? = null
    private var onClickIntroDato: View.OnClickListener? = null
    private var onClickAutoRellena: View.OnClickListener? = null
    private var onClickIntroCrearMatriz: View.OnClickListener? = null

    private var matriz: Matriz? = null
    private var filas: Int = 0
    private var columnas: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rellena_matriz)
        obtenerElementos()
        establecerEventos()
        registrarEventos()
    }

    private fun registrarEventos() {
        btIntroFilasColumnas.setOnClickListener(onClickIntroFilasColumnas)
        btIntroDato.setOnClickListener(onClickIntroDato)
        btAutoRellena.setOnClickListener(onClickAutoRellena)
        btCrearMatriz.setOnClickListener(onClickIntroCrearMatriz)
    }

    private fun establecerEventos() {

        onClickIntroFilasColumnas = View.OnClickListener { v ->
            if(txtFilas.text.toString()=== "" || txtColumnas.text.toString()=== ""){
                filas = Integer.parseInt(txtFilas.text.toString())
                columnas = Integer.parseInt(txtColumnas.text.toString())
            }
        }

        onClickIntroDato = View.OnClickListener { v ->
                obtenerMatriz()
        }

        onClickAutoRellena = View.OnClickListener { v ->

        }

        onClickIntroCrearMatriz = View.OnClickListener { v ->

        }
    }

    private fun obtenerElementos() {
        txtFilas = findViewById<View>(R.id.txtFilas) as EditText
        txtColumnas = findViewById<View>(R.id.txtColumnas) as EditText
        txtDato = findViewById<View>(R.id.txtDato) as EditText

        btIntroFilasColumnas = findViewById<View>(R.id.btIntroFilasColumnas) as Button
        btIntroDato = findViewById<View>(R.id.btIntroDato) as Button
        btAutoRellena = findViewById<View>(R.id.btAutoRellena) as Button
        btCrearMatriz = findViewById<View>(R.id.btCrearMatriz) as Button
    }

    private fun obtenerMatriz(){

        val dato = 1

        val array = Array(filas) { IntArray(columnas) }

        for (i in 0 until columnas) {
            for (j in 0 until filas) {
                array[i][j] = dato
            }
        }
        matriz = Matriz(array)

    }
}
