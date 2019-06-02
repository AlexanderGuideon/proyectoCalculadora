package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ActivityMatrices : ActivityPadre() {


    private lateinit var txtMatrizUno: EditText
    private lateinit var txtMatrizDos: EditText


    private lateinit var btComparar: Button
    private lateinit var btSuma: Button
    private lateinit var btTraspuestaM1: Button
    private lateinit var btProducto: Button
    private lateinit var btResta: Button
    private lateinit var btTraspuestaM2: Button

    private var matrizUno: Matriz? = null
    private var matrizDos: Matriz? = null

    private var onClickMatrizUno: View.OnClickListener? = null
    private var onClickMatrizDos: View.OnClickListener? = null
    private var onClickComparar: View.OnClickListener? = null
    private var onClickSuma: View.OnClickListener? = null
    private var onClickResta: View.OnClickListener? = null
    private var onClickProducto: View.OnClickListener? = null
    private var onClickTraspuesta: View.OnClickListener? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrices)
        obtenerElementos()
        establecerEventos()
        registrarEventos()
    }

    private fun registrarEventos() {
        txtMatrizUno.setOnClickListener(onClickMatrizUno)
        txtMatrizDos.setOnClickListener(onClickMatrizDos)

        btComparar.setOnClickListener(onClickComparar)

        btSuma.setOnClickListener(onClickSuma)

        btResta.setOnClickListener(onClickResta)

        btProducto.setOnClickListener(onClickProducto)

        btTraspuestaM1.setOnClickListener(onClickTraspuesta)
        btTraspuestaM2.setOnClickListener(onClickTraspuesta)
    }

    private fun establecerEventos() {

        onClickMatrizUno = View.OnClickListener { v ->

        }

        onClickMatrizDos = View.OnClickListener { v ->

        }

        onClickComparar = View.OnClickListener { v ->

        }

        onClickSuma = View.OnClickListener { v ->

        }

        onClickResta = View.OnClickListener { v ->

        }

        onClickProducto = View.OnClickListener { v ->

        }

        onClickTraspuesta = View.OnClickListener { v ->

        }


    }

    private fun obtenerElementos() {

        txtMatrizUno = findViewById<View>(R.id.txtMatrizUno) as EditText
        txtMatrizDos = findViewById<View>(R.id.txtMatrizDos) as EditText

        btComparar = findViewById<View>(R.id.btComparar) as Button
        btSuma = findViewById<View>(R.id.btSuma) as Button
        btTraspuestaM1 = findViewById<View>(R.id.btTraspuestaM1) as Button
        btProducto = findViewById<View>(R.id.btProducto) as Button
        btResta = findViewById<View>(R.id.btResta) as Button
        btTraspuestaM2 = findViewById<View>(R.id.btTraspuestaM2) as Button
    }
}
