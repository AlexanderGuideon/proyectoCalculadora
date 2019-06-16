package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * ActivityEstandar: similar  a ActivityCientifica pero solo realiza calculos basicos
 */
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
    internal var resul = ""

	
	//Eventos de nuestra activity
    private var onClick: View.OnClickListener? = null
    private var onClickResulOper:View.OnClickListener? = null
    private var onClickBorrar:View.OnClickListener? = null
    private var onClickLimpiar:View.OnClickListener? = null
    private var onClickFuncion:View.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estandar)

        obtenerElementos()
        registrarEventos()
        establecerEventos()

    }


    private fun obtenerElementos() {

        //Elementos Numericos
        txtResultado = findViewById<View>(R.id.edtContent) as EditText
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
			
			
			//Elementos Operadores
			btnPunto.setOnClickListener(onClick)
            btnSumar.setOnClickListener(onClick)
            btnRestar.setOnClickListener(onClick)
            btnDividir.setOnClickListener(onClick)
            btnMultiplicar.setOnClickListener(onClick)
            btnPotenciacion.setOnClickListener(onClick)

        }

        if(onClickFuncion != null)
            btnRadicacion.setOnClickListener(onClickFuncion)
        
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
            ponerDato(v)
        }

        onClickFuncion = View.OnClickListener { v ->
            if(txtResultado.text.toString() != ""){
                var dato = v as Button
                valorA = dato.text.toString() +"("+txtResultado.text.toString()+")"
            }

            txtResultado.setText(valorA)
        }

        onClickResulOper = View.OnClickListener {v ->
            obtenerResultado(v)
        }


        onClickLimpiar = View.OnClickListener {v ->
            limpiar(v)
        }

        onClickBorrar = View.OnClickListener { v ->
            borrar(v)
        }
    }

    private fun ponerDato(v:View) {
        var dato = v as Button
        if(dato.text.toString() == "n!")
            valorA += "!"
        else
            valorA += dato.text

        txtResultado.setText(valorA)
    }


	private fun obtenerResultado(v:View) {

        if(txtResultado.text.toString()!=""){
            try{
                resul = txtResultado.text.toString()
                txtResultado.setText("")
                var datoResul:Double = EvaluadorExpresiones(resul).resultado
                txtResultado.setText(datoResul.toString())
                resul = ""
            }

            catch (e: Exception){Toast.makeText(this,"Expresion invalida",Toast.LENGTH_LONG).show()}
        }
    }

    private fun limpiar(v:View){
        if(txtResultado.text.toString()!= ""){
            valorA = ""
            txtResultado.setText(valorA)
            resul = ""
        }
    }

    private fun borrar(v:View){
        if(txtResultado.text.toString()!= ""){
            valorA = valorA.substring(0,valorA.length-1)
            txtResultado.setText(valorA)
            resul = txtResultado.text.toString()
        }
    }

}
