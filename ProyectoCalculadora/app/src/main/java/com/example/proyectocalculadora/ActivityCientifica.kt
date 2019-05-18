package com.example.proyectocalculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText

class ActivityCientifica : AppCompatActivity() {

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

    private lateinit var btnSen: Button
    private lateinit var btnaSen: Button
    private lateinit var btnCos: Button
    private lateinit var btnaCos: Button
    private lateinit var btnTan: Button
    private lateinit var btnaTan: Button
    private lateinit var btndiv1: Button
    private lateinit var btnFact: Button

    private lateinit var btnIgual: Button
    private lateinit var btnBorrar: Button
    private lateinit var btnLimpiar: Button
    internal var ValorA = ""
    internal var ValorB = ""
    internal var operador = ' '
    private var cont = ""
    internal var decimal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_cientifica)

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

        btnSen = findViewById<View>(R.id.btnSen) as Button
        btnaSen = findViewById<View>(R.id.btnaSen) as Button
        btnCos = findViewById<View>(R.id.btnCos) as Button
        btnaCos = findViewById<View>(R.id.btnaCos) as Button
        btnTan = findViewById<View>(R.id.btnTan) as Button
        btnaTan = findViewById<View>(R.id.btnaTan) as Button
        btndiv1 = findViewById<View>(R.id.btndiv1) as Button
        btnFact = findViewById<View>(R.id.btnFact) as Button

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
            internal var hayPunto = false
            override fun onClick(v: View) {
                val dato = v as Button
                try {
                    val a = java.lang.Double.parseDouble(ValorA)
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

        val onclickOper2 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            val b: Double
            val b1: Double

            b = java.lang.Float.parseFloat(ValorB).toDouble()
            b1 = Math.toRadians(b)
            val resultado = Math.sin(b1)
            txtResultado.setText(resultado.toString())
        }
        btnSen.setOnClickListener(onclickOper2)

        val onclickOper3 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            val c: Double
            val c1: Double

            c = java.lang.Float.parseFloat(ValorB).toDouble()
            c1 = Math.toRadians(c)
            val resultado = Math.cos(c1)
            txtResultado.setText(resultado.toString())
        }
        btnCos.setOnClickListener(onclickOper3)

        val onclickOper4 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            val d: Double
            val d1: Double

            d = java.lang.Float.parseFloat(ValorB).toDouble()
            d1 = Math.toRadians(d)
            val resultado = Math.tan(d1)
            txtResultado.setText(resultado.toString())
        }
        btnTan.setOnClickListener(onclickOper4)

        val onclickOper5 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            val e: Double

            e = java.lang.Float.parseFloat(ValorB).toDouble()
            val resultado = 1 / e
            txtResultado.setText(resultado.toString())
        }
        btndiv1.setOnClickListener(onclickOper5)

        val onclickOper6 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            val a: Double
            val a1: Double

            a = java.lang.Float.parseFloat(ValorB).toDouble()
            a1 = Math.toRadians(a)
            val resultado = Math.asin(a1)
            txtResultado.setText(resultado.toString())
        }
        btnaSen.setOnClickListener(onclickOper6)

        val onclickOper7 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            val b: Double
            val b1: Double

            b = java.lang.Float.parseFloat(ValorB).toDouble()
            b1 = Math.toRadians(b)
            val resultado = Math.acos(b1)
            txtResultado.setText(resultado.toString())
        }
        btnaCos.setOnClickListener(onclickOper7)
        val onclickOper8 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            val c: Double
            val c1: Double

            c = java.lang.Float.parseFloat(ValorB).toDouble()
            c1 = Math.toRadians(c)
            val resultado = Math.atan(c1)
            txtResultado.setText(resultado.toString())
        }
        btnaTan.setOnClickListener(onclickOper8)

        val onclickOper9 = View.OnClickListener { v ->
            val dato = v as Button
            cont = dato.text.toString()
            ValorB = ValorA
            ValorA = ""

            var factorial = 1.0
            var numero = java.lang.Float.parseFloat(ValorB).toDouble()

            while (numero != 0.0) {
                factorial = factorial * numero
                numero--
            }
            txtResultado.setText(factorial.toString())
        }
        btnFact.setOnClickListener(onclickOper9)

        val onclickResulOper = object : View.OnClickListener {
            var resultado = 0.0
            var a: Double = 0.toDouble()
            var b: Double = 0.toDouble()

            override fun onClick(v: View) {

                try {
                    when (operador) {
                        '+' -> {
                            resultado =
                                (java.lang.Float.parseFloat(ValorB) + java.lang.Float.parseFloat(ValorA)).toDouble()
                            //resultado = Integer.parseInt(ValorB) + Integer.parseInt(ValorA);
                        }
                        '-' -> {
                            resultado =
                                (java.lang.Float.parseFloat(ValorB) - java.lang.Float.parseFloat(ValorA)).toDouble()
                            //resultado = Integer.parseInt(ValorB) - Integer.parseInt(ValorA);
                        }
                        '/' -> {
                            resultado =
                                (java.lang.Float.parseFloat(ValorB) / java.lang.Float.parseFloat(ValorA)).toDouble()
                            //resultado = Integer.parseInt(ValorB) / Integer.parseInt(ValorA);
                        }
                        '*' -> {
                            resultado =
                                (java.lang.Float.parseFloat(ValorB) * java.lang.Float.parseFloat(ValorA)).toDouble()
                            //resultado = Integer.parseInt(ValorB) * Integer.parseInt(ValorA);
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
            val temporal = ValorB.substring(0, ValorB.length + 1)

            ValorB = temporal
            txtResultado.setText(ValorB)
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
