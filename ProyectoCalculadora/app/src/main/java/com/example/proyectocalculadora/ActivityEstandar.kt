package com.example.proyectocalculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText

class ActivityEstandar : AppCompatActivity() {

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
    internal var ValorA = ""
    internal var ValorB = ""
    internal var operador = ' '
    private var cont = ""
    internal var decimal = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_estandar)
        actionBar.hide()
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

        btnSumar = findViewById<View>(R.id.btnSuma) as Button
        btnRestar = findViewById<View>(R.id.btnResta) as Button
        btnDividir = findViewById<View>(R.id.btnDividir) as Button
        btnMultiplicar = findViewById<View>(R.id.btnMultiplicar) as Button
        btnPotenciacion = findViewById<View>(R.id.btnPotencia) as Button
        btnRadicacion = findViewById<View>(R.id.btnRaiz) as Button

        btnIgual = findViewById<View>(R.id.btnIgual) as Button
        btnBorrar = findViewById<View>(R.id.btnBorrar) as Button
        btnPunto = findViewById<View>(R.id.btnPunto) as Button
        btnLimpiar = findViewById<View>(R.id.btnLimpiar) as Button

        val onclick = View.OnClickListener { v ->
            val dato = v as Button
            ValorA += dato.text
            txtResultado.setText(ValorA)
        }
        btn0.setOnClickListener(onclick)
        btn1.setOnClickListener(onclick)
        btn2.setOnClickListener(onclick)
        btn3.setOnClickListener(onclick)
        btn4.setOnClickListener(onclick)
        btn5.setOnClickListener(onclick)
        btn6.setOnClickListener(onclick)
        btn7.setOnClickListener(onclick)
        btn8.setOnClickListener(onclick)
        btn9.setOnClickListener(onclick)

        val onclickPunto = object : View.OnClickListener {
            var hayPunto = false
            override fun onClick(v: View) {
                val dato = v as Button
                try {
                    val a = java.lang.Float.parseFloat(ValorA).toDouble()
                    if (a % 1 == 0.0) {
                        ValorA += dato.text
                        txtResultado.setText(ValorA)
                    } else if (a % 1 != 0.0) {
                        hayPunto = true
                        return
                    }
                } catch (nfe: NumberFormatException) {
                    return
                }

            }
        }
        btnPunto.setOnClickListener(onclickPunto)

        val onclickOper = View.OnClickListener { v ->
            val dato = v as Button
            operador = dato.text[0]
            ValorB = ValorA
            ValorA = ""
        }

        btnSumar.setOnClickListener(onclickOper)
        btnRestar.setOnClickListener(onclickOper)
        btnDividir.setOnClickListener(onclickOper)
        btnMultiplicar.setOnClickListener(onclickOper)
        btnPotenciacion.setOnClickListener(onclickOper)

        val onclickOper1 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""
            val a: Double

            a = java.lang.Float.parseFloat(ValorB).toDouble()
            val resultado = Math.sqrt(a)
            txtResultado.setText(resultado.toString())
        }
        btnRadicacion.setOnClickListener(onclickOper1)

        val onclickResulOper = object : View.OnClickListener {
            var resultado = 0.0

            var a: Double = 0.toDouble()
            var b: Double = 0.toDouble()

            override fun onClick(v: View) {

                try {
                    when (operador) {
                        '+' -> {

                            resultado = (java.lang.Float.parseFloat(ValorB) + java.lang.Float.parseFloat(ValorA)).toDouble()
                        }
                        '-' -> {

                            resultado = (java.lang.Float.parseFloat(ValorB) - java.lang.Float.parseFloat(ValorA)).toDouble()
                        }
                        '/' -> {

                            resultado = (java.lang.Float.parseFloat(ValorB) / java.lang.Float.parseFloat(ValorA)).toDouble()
                        }
                        '*' -> {

                            resultado = (java.lang.Float.parseFloat(ValorB) * java.lang.Float.parseFloat(ValorA)).toDouble()
                        }
                        '^' -> {
                            a = java.lang.Float.parseFloat(ValorB).toDouble()
                            b = java.lang.Float.parseFloat(ValorA).toDouble()
                            resultado = Math.pow(a, b)
                        }
                        else -> {
                        }
                    }
                    txtResultado.setText(resultado.toString())
                } catch (e: Exception) {
                    txtResultado.setText("Error")
                }

            }

        }

        btnIgual.setOnClickListener(onclickResulOper)

        val onclickborrar = View.OnClickListener {
            txtResultado.setText(ValorB.substring(0, ValorB.length + 1))
        }
        btnBorrar.setOnClickListener(onclickborrar)

        val onclicklimpiar = View.OnClickListener {
            ValorA = ""
            ValorB = ""
            txtResultado.setText("")
        }
        btnLimpiar.setOnClickListener(onclicklimpiar)
    }
}
