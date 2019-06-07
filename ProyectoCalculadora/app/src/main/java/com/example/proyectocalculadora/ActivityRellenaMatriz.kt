package com.example.proyectocalculadora


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.Toast


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
    private var datos: IntArray? = null
    private var tamDatos :Int = 0
    private var dato:Int = 0
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
            if(txtFilas.text.toString()!= "" || txtColumnas.text.toString()!== ""){
                filas = Integer.parseInt(txtFilas.text.toString())
                columnas = Integer.parseInt(txtColumnas.text.toString())
            }
        }

        onClickAutoRellena = View.OnClickListener { v ->
            val array = Array(filas) { IntArray(columnas) }
            for (i in 0 until columnas) {
                for (j in 0 until filas) {
                    array[i][j] = Integer.parseInt((Math.round(Math.random()*9)).toString())
                }
            }
            matriz = Matriz(array)
            for (i in 0 until columnas) {
                for (j in 0 until filas) {
                    Toast.makeText(this,matriz!!.data[i][j],Toast.LENGTH_LONG)
                }
            }
        }


        var array :Array<IntArray> =  Array(filas) { IntArray(columnas) }


        onClickIntroDato = View.OnClickListener { v ->
            tamDatos = filas*columnas
            if(datos == null)
                datos = IntArray(tamDatos)

            if(dato < tamDatos){
                datos!![dato] = Integer.parseInt(txtDato.text.toString())
                txtDato.setText("")
                dato++
            }

        }


        onClickIntroCrearMatriz = View.OnClickListener { v ->
            if(datos!=null){
                for (i in 0 until columnas) {
                    for (j in 0 until filas) {
                        if(dato<tamDatos){
                            array[i][j] = datos!![dato]
                            dato++
                        }
                        else{
                            dato = 0
                            tamDatos = 0
                        }
                    }
                }
                matriz = Matriz(array)
            }
            if(matriz != null){
                val intent = Intent(this, ActivityMatrices::class.java)
                intent.putExtra("matriz",matriz)
                startActivity(intent)
            }
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

}
