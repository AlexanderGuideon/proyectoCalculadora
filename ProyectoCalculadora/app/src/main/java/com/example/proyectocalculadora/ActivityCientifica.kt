package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cientifica.*
import java.lang.Float.*


/**
* ActivityCientifica: activity que muestra una calculadora cientifica, los botones ponen el texto
* correspondiente en txtResultado y esto se envia al evaluador de expresiones
*/
class ActivityCientifica : ActivityPadre() {

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
    private lateinit var btnPorciento: Button

    private lateinit var btnSen: Button
    private lateinit var btnCos: Button
    private lateinit var btnLogaritmo: Button
    private lateinit var btnTan: Button


    private lateinit var btnFact: Button
    private lateinit var btnParDer: Button
    private lateinit var btnParIzq: Button
    private lateinit var btnIgual: Button
    private lateinit var btnBorrar: Button
    private lateinit var btnLimpiar: Button
	
	//Variables para obtener los operandos y el resultado correspondiente en la calculadora
    internal var valorA = ""
    internal var resul = ""
	internal var finParentesis:Boolean = false
	internal var esArco:Boolean = false
    internal var esFun = false
    internal var esPi = false
	
    //Eventos de nuestra activity
    private var onClick:View.OnClickListener? = null
    private var onClickResulOper:View.OnClickListener? = null
    private var onClickBorrar:View.OnClickListener? = null
    private var onClickLimpiar:View.OnClickListener? = null
	private var onLongParentesis:View.OnLongClickListener? = null
	private var onLongFuncion:View.OnLongClickListener? = null
    private var onClickFuncion:View.OnClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_cientifica)

        obtenerElementos()
        registrarEventos()
        establecerEventos()
    }

    private fun obtenerElementos() {

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

        btnSumar = findViewById<View>(R.id.btnSuma) as Button
        btnRestar = findViewById<View>(R.id.btnResta) as Button
        btnDividir = findViewById<View>(R.id.btnDividir) as Button
        btnMultiplicar = findViewById<View>(R.id.btnMultiplicar) as Button
        btnPotenciacion = findViewById<View>(R.id.btnPotencia) as Button
        btnRadicacion = findViewById<View>(R.id.btnRaiz) as Button
        btnPorciento = findViewById<View>(R.id.btnPorciento) as Button
        btnFact = findViewById<View>(R.id.btnFact) as Button
        btnPorciento = findViewById<View>(R.id.btnPorciento) as Button

        btnSen = findViewById<View>(R.id.btnSen) as Button

        btnCos = findViewById<View>(R.id.btnCos) as Button
        btnLogaritmo = findViewById<View>(R.id.btnLogaritmo) as Button
        btnTan = findViewById<View>(R.id.btnTan) as Button


        btnParDer = findViewById<View>(R.id.btnParDer) as Button
        btnParIzq = findViewById<View>(R.id.btnParIzq) as Button
        btnIgual = findViewById<View>(R.id.btnIgual) as Button
        btnBorrar = findViewById<View>(R.id.btnBorrar) as Button
        btnPunto = findViewById<View>(R.id.btnPunto) as Button
        btnLimpiar = findViewById<View>(R.id.btnLimpiar) as Button
    }

    private fun registrarEventos() {


        onClick = View.OnClickListener { v ->
            ponerDato(v)
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
            btnParDer.setOnClickListener(onClick)
            btnParIzq.setOnClickListener(onClick)
			
			//Elementos funcion  
            btnRadicacion.setOnClickListener(onClick)
            btnSen.setOnClickListener(onClick)
            btnCos.setOnClickListener(onClick)
            btnTan.setOnClickListener(onClick)
            btnPorciento.setOnClickListener(onClick)

            btnLogaritmo.setOnClickListener(onClick)
            btnFact.setOnClickListener(onClick)
            btnIgual.setOnClickListener(onClickResulOper)
            
        }
	
        //Elementos de Borrado
        if(onClickBorrar != null)
            btnBorrar.setOnClickListener(onClickBorrar)

        if(onClickLimpiar != null)
            btnLimpiar.setOnClickListener(onClickLimpiar)

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
