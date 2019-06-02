package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Float
import android.widget.Toast.makeText as makeText1

class ActivityEstandar : ActivityPadre() {

    //Recogemos elementos de la vista para trabajar con ellos
    private lateinit var txtResultado: EditText

    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnPunto: Button


    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var btnDividir: Button
    private lateinit var btnMultiplicar: Button
    private lateinit var btnPotenciacion: Button
    private lateinit var btnRadicacion: Button


    private lateinit var btnIgual: Button
    private lateinit var btnBorrar: Button
    private lateinit var btnLimpiar: Button


    //Variables para obtener los operandos y el resultado correspondiente en la calculadora
    internal var valorA = ""
    internal var valorB = ""
    internal var operador = ' '
    private var cont = ""

    private var onClick: View.OnClickListener? = null
    private var onClickPunto: View.OnClickListener? = null
    private var onClickOper:View.OnClickListener? = null
    private var onClickOper1:View.OnClickListener? = null
    private var onClickResulOper:View.OnClickListener? = null
    private var onClickBorrar:View.OnClickListener? = null
    private var onClickLimpiar:View.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_estandar)

        obtenerElementos()
        registrarEventos()
        establecerEventos()

    }


    private fun obtenerElementos() {

        //Elementos Numericos
        txtResultado = findViewById<View>(R.id.txtResultado) as EditText
        btn0 = findViewById<View>(R.id.btn0) as Button
        btn1 = findViewById<View>(R.id.btn1) as Button
        btn2 = findViewById<View>(R.id.btn2) as Button
        btn3 = findViewById<View>(R.id.btn3) as Button
        btn4 = findViewById<View>(R.id.btn4) as Button
        btn5 = findViewById<View>(R.id.btn5) as Button
        btn6 = findViewById<View>(R.id.btn6) as Button
        btn7 = findViewById<View>(R.id.btn7) as Button
        btn8 = findViewById<View>(R.id.btn8) as Button
        btn9 = findViewById<View>(R.id.btn9) as Button

        //Elementos Operadores
        btnSumar = findViewById<View>(R.id.btnSuma) as Button
        btnRestar = findViewById<View>(R.id.btnResta) as Button
        btnDividir = findViewById<View>(R.id.btnDividir) as Button
        btnMultiplicar = findViewById<View>(R.id.btnMultiplicar) as Button
        btnPotenciacion = findViewById<View>(R.id.btnPotencia) as Button
        btnRadicacion = findViewById<View>(R.id.btnRaiz) as Button
        btnIgual = findViewById<View>(R.id.btnIgual) as Button
        btnPunto = findViewById<View>(R.id.btnPunto) as Button

        //Elementos de Borrado
        btnBorrar = findViewById<View>(R.id.btnBorrar) as Button
        btnLimpiar = findViewById<View>(R.id.btnLimpiar) as Button
    }

    private fun establecerEventos() {

        //Elementos Numericos
        if(onClick != null){
            btn0.setOnClickListener(onClick)
            btn1.setOnClickListener(onClick)
            btn2.setOnClickListener(onClick)
            btn3.setOnClickListener(onClick)
            btn4.setOnClickListener(onClick)
            btn5.setOnClickListener(onClick)
            btn6.setOnClickListener(onClick)
            btn7.setOnClickListener(onClick)
            btn8.setOnClickListener(onClick)
            btn9.setOnClickListener(onClick)
        }

        //Elementos Operadores
        if(onClickPunto != null)
            btnPunto.setOnClickListener(onClickPunto)

        if(onClickOper != null){
            btnSumar.setOnClickListener(onClickOper)
            btnRestar.setOnClickListener(onClickOper)
            btnDividir.setOnClickListener(onClickOper)
            btnMultiplicar.setOnClickListener(onClickOper)
            btnPotenciacion.setOnClickListener(onClickOper)
        }

        if(onClickOper1 != null)
            btnRadicacion.setOnClickListener(onClickOper1)

        if(onClickResulOper != null)
            btnIgual.setOnClickListener(onClickResulOper)

        //Elementos de Borrado

        if(onClickBorrar != null)
            btnBorrar.setOnClickListener(onClickBorrar)

        if(onClickResulOper != null)
            btnLimpiar.setOnClickListener(onClickLimpiar)


    }

    private fun registrarEventos() {

        onClick = View.OnClickListener { v ->
            var dato = v as Button
            valorA += dato.text
            txtResultado.setText(valorA)
        }


        onClickPunto = object : View.OnClickListener {
            var hayPunto = false
            override fun onClick(v: View) {
                var dato = v as Button
                try {
                    var a = java.lang.Float.parseFloat(valorA).toDouble()
                    if (a % 1 == 0.0) {
                        valorA += dato.text
                        txtResultado.setText(valorA)
                    } else if (a % 1 != 0.0) {
                        hayPunto = true
                        return
                    }
                } catch (nfe: NumberFormatException) {
                    var Mensaje: Toast = Toast.makeText(this@ActivityEstandar, "Error de formato", Toast.LENGTH_LONG) as Toast
                    Mensaje.show()
                }

            }
        }


        onClickOper = View.OnClickListener { v ->
            var dato = v as Button
            operador = dato.text[0]
            valorB = valorA
            valorA = ""
            txtResultado.setText("")
        }



        onClickOper1 = View.OnClickListener { v ->
            var datos:Double? = obtenerDatos(v)
            if(datos!=null){
                var resultado = Math.sqrt(datos)
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }


        onClickResulOper = object : View.OnClickListener {
            var resultado = 0.0

            override fun onClick(v: View) {

                if(valorB != "" && valorA != ""){

                    var b = Float.parseFloat(valorB).toDouble()
                    var a = Float.parseFloat(valorA).toDouble()
                    var esIndeterminado = false

                    try {
                        when (operador) {
                            '+' -> resultado = b + a

                            '-' -> resultado = b - a


                            '/' -> {
                                if(a != 0.0){
                                    resultado = (Float.parseFloat(valorB) / Float.parseFloat(valorA)).toDouble()
                                    esIndeterminado = false
                                }

                                else
                                    esIndeterminado = true
                            }


                            '*' -> resultado = (Float.parseFloat(valorB) * Float.parseFloat(valorA)).toDouble()


                            '^' -> resultado = Math.pow(a, b)

                        }
                        if(!esIndeterminado)
                            txtResultado.setText(resultado.toString())
                        else
                            Toast.makeText(this@ActivityEstandar, "Indeterminacion", Toast.LENGTH_LONG)

                    } catch (e: Exception) {
                        Toast.makeText(this@ActivityEstandar, "Error de calculo", Toast.LENGTH_LONG)
                    }
                }

            }

        }

        onClickBorrar = View.OnClickListener {
            txtResultado.setText("")
        }

        onClickLimpiar = View.OnClickListener {
            valorA = ""
            valorB = ""
            txtResultado.setText("")
        }
    }

    private fun obtenerDatos(v:View):Double?{
        var dato = v as Button
        cont = dato.text.toString()
        valorB = valorA
        valorA = ""
        txtResultado.setText("")

        var a: Double? = null
        if (valorB!= "")
            return Float.parseFloat(valorB).toDouble()
        else
            return null

    }

}
