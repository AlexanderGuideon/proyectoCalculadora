package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

/**
 * Activity que muestra las opciones de calcular el MCM(Minimo común multiplo) y MCD(Máximo Común Divisor) al usuario
 * Y realiza los calculos que procedan para cada opcion.
 * */
class ActivityComunes : ActivityPadre() {

    internal lateinit var campoNumUno: EditText
    internal lateinit var campoNumDos: EditText
    internal lateinit var btMCM:Button
    internal lateinit var btMCD:Button

    internal lateinit var txtResul: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunes)

        encontrarElementos()
        establecerEventos()
        registrarEventos()

    }

    private fun registrarEventos() {
        campoNumUno = findViewById<View>(R.id.campoNumUno) as EditText
        campoNumDos = findViewById<View>(R.id.campoNumDos) as EditText
        txtResul = findViewById<View>(R.id.edtContent) as EditText
    }

    private fun establecerEventos() {

        btMCM.setOnClickListener {
            calcularMCM()
        }

        btMCD.setOnClickListener {
            calcularMCD()
        }
    }

    private fun encontrarElementos() {
        btMCM = findViewById<View>(R.id.btMCM) as Button
        btMCD = findViewById<View>(R.id.btMCD) as Button
    }

    /**
     * calcularMCD():Metodo que calcula el Maximo comun divisor entre dos numeros
     * E:Nada
     * S:Nada
     */
    private fun calcularMCD() {

        var camposVacios :Boolean = false
            try{
                var dato1 = Integer.parseInt(campoNumUno.text.toString().trim())
                var dato2 = Integer.parseInt(campoNumDos.text.toString().trim())
                var num1 = dato1
                var num2 = dato2

                while (dato1 != dato2) {
                    if (dato1 > dato2)
                        dato1 -= dato2
                    else
                        dato2 -= dato1
                }

                txtResul.setText("MCD de "+num1.toString()+" y "+num2.toString()+" = " +dato1.toString())
                campoNumUno.setText("")
                campoNumDos.setText("")
            }

            catch (e:Exception){
                camposVacios = true
            }

        if(camposVacios)
            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG).show()


    }


    /**
     * calcularMCM():Metodo que calcula el Minimo comun multiplo entre dos numeros
     * E:Nada
     * S:Nada
     */
    private fun calcularMCM() {

        var camposVacios :Boolean = false

            try{
                var dato1 = Integer.parseInt(campoNumUno.text.toString().trim())
                var dato2 = Integer.parseInt(campoNumDos.text.toString().trim())
                var num1 = dato1
                var num2 = dato2
                var mcd = 1

                var i = 1
                while (i <= dato1 && i <= dato2) {
                    if (dato1 % i == 0 && dato2 % i == 0)
                        mcd = i
                    ++i
                }

                val mcm = dato1 * dato2 / mcd
                txtResul.setText("MCM de "+num1.toString()+" y "+num2.toString()+" = " +mcm.toString())
                campoNumUno.setText("")
                campoNumDos.setText("")
            }
            catch (e:Exception){
                camposVacios = true
            }

            if(camposVacios)
                Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG).show()

    }

    /**
     * camposVacios():Comprueba que los campos de texto de los numeros no esten vacios
     * E:Nada
     * S:Boolean: true si estan vacios y false si no lo están
     */

    private fun camposVacios(): Boolean {
        return try{
            campoNumUno.text.toString() === "" && campoNumDos.text.toString() === ""
        } catch (e :Exception){
            true
        }
    }
}
