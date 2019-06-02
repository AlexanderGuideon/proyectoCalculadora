package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception


class ActivityComunes : ActivityPadre() {

    internal lateinit var campoNumUno: EditText
    internal lateinit var campoNumDos: EditText

    internal lateinit var txtResul: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunes)

        val btMCM = findViewById<View>(R.id.btMCM) as Button
        val btMCD = findViewById<View>(R.id.btMCD) as Button

        campoNumUno = findViewById<View>(R.id.campoNumUno) as EditText
        campoNumDos = findViewById<View>(R.id.campoNumDos) as EditText
        txtResul = findViewById<View>(R.id.txtResultado) as EditText


        btMCM.setOnClickListener {
            calcularMCM()
        }

        btMCD.setOnClickListener {
            calcularMCD()
        }

    }

    private fun calcularMCD() {
        //if (!camposVacios()) {
        var camposVacios :Boolean = false
            try{
                var dato1 = Integer.parseInt(campoNumUno.text.toString().trim())
                var dato2 = Integer.parseInt(campoNumDos.text.toString().trim())


                while (dato1 != dato2) {
                    if (dato1 > dato2)
                        dato1 -= dato2
                    else
                        dato2 -= dato1
                }

                txtResul.setText(dato1.toString())
            }

            catch (e:Exception){
                camposVacios = true
            }

        if(camposVacios)
            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG).show()
        //} else Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG)

    }

    private fun calcularMCM() {
        //if (!camposVacios()) {
        var camposVacios :Boolean = false

            try{
                var dato1 = Integer.parseInt(campoNumUno.text.toString().trim())
                var dato2 = Integer.parseInt(campoNumDos.text.toString().trim())

                var mcd = 1

                var i = 1
                while (i <= dato1 && i <= dato2) {
                    if (dato1 % i == 0 && dato2 % i == 0)
                        mcd = i
                    ++i
                }

                val mcm = dato1 * dato2 / mcd
                txtResul.setText(mcm.toString())
            }
            catch (e:Exception){
                camposVacios = true
            }

            if(camposVacios)
                Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG).show()
        //} else Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG)
    }


    private fun camposVacios(): Boolean {
        return try{
            campoNumUno.text.toString() === "" && campoNumDos.text.toString() === ""
        } catch (e :Exception){
            true
        }
    }
}
