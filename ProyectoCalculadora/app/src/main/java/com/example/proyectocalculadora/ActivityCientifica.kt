package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Float.*

class ActivityCientifica : ActivityPadre() {

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
    private lateinit var btnPorciento: Button

    private lateinit var btnSen: Button
    private lateinit var btnaSen: Button
    private lateinit var btnCos: Button
    private lateinit var btnaCos: Button
    private lateinit var btnTan: Button
    private lateinit var btnaTan: Button

    private lateinit var btnFact: Button

    private lateinit var btnIgual: Button
    private lateinit var btnBorrar: Button
    private lateinit var btnLimpiar: Button
    internal var valorA = ""
    internal var valorB = ""
    internal var operador = ' '
    private var cont = ""
    
    private var onClick:View.OnClickListener? = null
    private var onClickPunto:View.OnClickListener? = null
    private var onClickOper:View.OnClickListener? = null
    private var onClickOper1:View.OnClickListener? = null
    private var onClickOper2:View.OnClickListener? = null
    private var onClickOper3:View.OnClickListener? = null
    private var onClickOper4:View.OnClickListener? = null
    private var onClickOper5:View.OnClickListener? = null
    private var onClickOper6:View.OnClickListener? = null
    private var onClickOper7:View.OnClickListener? = null
    private var onClickOper8:View.OnClickListener? = null
    private var onClickOper9:View.OnClickListener? = null
    private var onClickResulOper:View.OnClickListener? = null
    private var onClickBorrar:View.OnClickListener? = null
    private var onClickLimpiar:View.OnClickListener? = null

    

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_cientifica)

        obtenerElementos()
        registrarEventos()
        establecerEventos()
    }

    private fun obtenerElementos() {

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
        btnPorciento = findViewById<View>(R.id.btnPorciento) as Button
        btnFact = findViewById<View>(R.id.btnFact) as Button


        btnSen = findViewById<View>(R.id.btnSen) as Button
        btnaSen = findViewById<View>(R.id.btnaSen) as Button
        btnCos = findViewById<View>(R.id.btnCos) as Button
        btnaCos = findViewById<View>(R.id.btnaCos) as Button
        btnTan = findViewById<View>(R.id.btnTan) as Button
        btnaTan = findViewById<View>(R.id.btnaTan) as Button


        btnIgual = findViewById<View>(R.id.btnIgual) as Button
        btnBorrar = findViewById<View>(R.id.btnBorrar) as Button
        btnPunto = findViewById<View>(R.id.btnPunto) as Button
        btnLimpiar = findViewById<View>(R.id.btnLimpiar) as Button
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
                    var a = java.lang.Double.parseDouble(valorA)
                    if (a % 1 == 0.0) {
                        valorA += dato.text
                        txtResultado.setText(valorA)
                    } else if (a % 1 != 0.0) {
                        hayPunto = true
                        return
                    }
                } catch (nfe: NumberFormatException) {
                    Toast.makeText(this@ActivityCientifica, "Formato numerico erroneo",Toast.LENGTH_LONG)
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

        onClickOper2 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){
                var resultado = Math.sin(Math.toRadians(datos))
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }

        onClickOper3 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){
                var resultado = Math.cos(Math.toRadians(datos))
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }

        onClickOper4 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){

                var resultado = Math.tan(Math.toRadians(datos))
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }

        onClickOper5 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){
                var resultado :Double = (datos*100)/datos
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }

        onClickOper6 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){
                var resultado = Math.asin(Math.toRadians(datos))
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }

        onClickOper7 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){

                var resultado = Math.acos(Math.toRadians(datos))
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }

        onClickOper8 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){

                var resultado = Math.atan(Math.toRadians(datos))
                valorA = resultado.toString()
                txtResultado.setText(resultado.toString())
            }
            else
                Toast.makeText(this,"Error de Operador", Toast.LENGTH_LONG).show()
        }

        onClickOper9 = View.OnClickListener { v ->

            var datos:Double? = obtenerDatos(v)
            if(datos!=null){
                var resultado :Double = calcularFactorial()
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

                    var b = parseFloat(valorB).toDouble()
                    var a = parseFloat(valorA).toDouble()
                    var esIndeterminado = false

                    try {
                        when (operador) {
                            '+' -> resultado = b + a

                            '-' -> resultado = b - a


                            '/' -> {
                                if(a != 0.0){
                                    resultado = (parseFloat(valorB) / parseFloat(valorA)).toDouble()
                                    esIndeterminado = false
                                }

                                else
                                    esIndeterminado = true
                            }


                            '*' -> resultado = (parseFloat(valorB) * parseFloat(valorA)).toDouble()


                            '^' -> resultado = Math.pow(a, b)

                        }
                        if(!esIndeterminado)
                            txtResultado.setText(resultado.toString())
                        else
                            Toast.makeText(this@ActivityCientifica, "Indeterminacion", Toast.LENGTH_LONG)

                    } catch (e: Exception) {
                        Toast.makeText(this@ActivityCientifica, "Error de calculo", Toast.LENGTH_LONG)
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

    private fun calcularFactorial(): Double {
        var factorial = 1.0
        var numero = parseFloat(valorB).toDouble()

        while (numero != 0.0) {
            factorial *= numero
            numero--
        }
        return factorial
    }


    private fun obtenerDatos(v:View):Double?{
        var dato = v as Button
        cont = dato.text.toString()
        valorB = valorA
        valorA = ""
        txtResultado.setText("")

        var a: Double? = null
        if (valorB!= "")
            return parseFloat(valorB).toDouble()
        else
            return null

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
        if(onClickOper != null){
            btnPunto.setOnClickListener(onClickPunto)
            btnSumar.setOnClickListener(onClickOper)
            btnRestar.setOnClickListener(onClickOper)
            btnDividir.setOnClickListener(onClickOper)
            btnMultiplicar.setOnClickListener(onClickOper)
            btnPotenciacion.setOnClickListener(onClickOper)

        }

        if(onClickOper1 != null)
            btnRadicacion.setOnClickListener(onClickOper1)

        if(onClickOper2 != null)
            btnSen.setOnClickListener(onClickOper2)

        if(onClickOper3 != null)
            btnCos.setOnClickListener(onClickOper3)

        if(onClickOper4 != null)
            btnTan.setOnClickListener(onClickOper4)

        if(onClickOper5 != null)
            btnPorciento.setOnClickListener(onClickOper5)

        if(onClickOper6 != null)
            btnaSen.setOnClickListener(onClickOper6)

        if(onClickOper7 != null)
            btnaCos.setOnClickListener(onClickOper7)

        if(onClickOper8 != null)
            btnaTan.setOnClickListener(onClickOper8)

        if(onClickOper9 != null)
            btnFact.setOnClickListener(onClickOper9)

        if(onClickResulOper != null)
            btnIgual.setOnClickListener(onClickResulOper)


        //Elementos de Borrado
        if(onClickBorrar != null)
            btnBorrar.setOnClickListener(onClickBorrar)

        if(onClickLimpiar != null)
            btnLimpiar.setOnClickListener(onClickLimpiar)

    }
}
