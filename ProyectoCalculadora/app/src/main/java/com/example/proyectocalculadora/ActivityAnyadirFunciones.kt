package com.example.proyectocalculadora

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_anyadir_funciones.*

class ActivityAnyadirFunciones : AppCompatActivity() {

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

    private lateinit var btnFact: Button
    private lateinit var btnLimpiar: Button

    private var onClick:View.OnClickListener? = null
    private var onClickOperacion:View.OnClickListener? = null
    private var onClickLimpiar:View.OnClickListener? = null

    internal var valorA = ""
    internal var esFun = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anyadir_funciones)

        val btAnyadir = findViewById<Button>(R.id.btAnyadir)

        obtenerElementos()
        registrarEventos()
        establecerEventos()

        btAnyadir.setOnClickListener {
            accionAnyadir()
        }
    }

    private fun registrarEventos() {

        onClick = View.OnClickListener { v ->
            ponerDato(v)
            if(esFun){
                var texto = txtResultado.text.toString()
                texto += ")"
                txtResultado.setText(texto)
            }
        }

        onClickOperacion = View.OnClickListener { v ->
            ponerDato(v)
            var texto = txtResultado.text.toString()
            texto += "("
            txtResultado.setText(texto)
            esFun = true
        }
    }

    private fun ponerDato(v:View) {
        var dato = v as Button
        valorA += dato.text
        txtResultado.setText(valorA)
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

        btnSen = findViewById<View>(R.id.btnSen) as Button
        btnaSen = findViewById<View>(R.id.btnaSen) as Button
        btnCos = findViewById<View>(R.id.btnCos) as Button
        btnaCos = findViewById<View>(R.id.btnaCos) as Button
        btnTan = findViewById<View>(R.id.btnTan) as Button
        btnaTan = findViewById<View>(R.id.btnaTan) as Button

        btnFact = findViewById<View>(R.id.btnFact) as Button
        btnPunto = findViewById<View>(R.id.btnPunto) as Button
        btnLimpiar = findViewById<View>(R.id.btnLimpiar) as Button
    }

    private fun establecerEventos() {


        if(onClick != null){

            //Elementos Numericos
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


            //Elementos Operadores
            btnPunto.setOnClickListener(onClick)
            btnSumar.setOnClickListener(onClick)
            btnRestar.setOnClickListener(onClick)
            btnDividir.setOnClickListener(onClick)
            btnMultiplicar.setOnClickListener(onClick)
            btnPotenciacion.setOnClickListener(onClick)
            btnRadicacion.setOnClickListener(onClick)
            btnFact.setOnClickListener(onClick)
        }

        if(onClickOperacion != null)
            btnSen.setOnClickListener(onClickOperacion)

        if(onClickOperacion != null)
            btnCos.setOnClickListener(onClickOperacion)

        if(onClickOperacion != null)
            btnTan.setOnClickListener(onClickOperacion)


        if(onClickOperacion != null)
            btnaSen.setOnClickListener(onClickOperacion)

        if(onClickOperacion != null)
            btnaCos.setOnClickListener(onClickOperacion)

        if(onClickOperacion != null)
            btnaTan.setOnClickListener(onClickOperacion)




        //Elementos de Borrado
        if(onClickLimpiar != null)
            btnLimpiar.setOnClickListener(onClickLimpiar)

    }

    private fun accionAnyadir(){

        val txtExpresion :TextView = findViewById(R.id.txtResultado)
        val funciones = FuncionesSQLiteHelper(this, "funciones", null, 1)
        val bd = funciones.writableDatabase
        val registro = ContentValues()

        registro.put("nombre", txtNombre.text.toString())
        registro.put("expresion", txtExpresion.text.toString())
        bd.insert("funciones", null, registro)
        bd.close()
        txtNombre.setText("")
        txtExpresion.setText("")

        Toast.makeText(this, "Añadida Correctamente", Toast.LENGTH_LONG).show()
    }
}
