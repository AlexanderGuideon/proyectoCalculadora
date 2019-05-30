package com.example.proyectocalculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class ActivityComunes : AppCompatActivity() {

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

        btMCM.setOnClickListener { calcularMCM() }

        btMCD.setOnClickListener { calcularMCD() }
    }

    private fun calcularMCD() {
        if (!camposVacios()) {
            var dato1 = Integer.parseInt(campoNumUno.text.toString())
            var dato2 = Integer.parseInt(campoNumUno.text.toString())
            var resto:Int
            var numDiv1 = dato1
            var numDiv2 = dato2
            try
            {
                do
                {
                    resto = numDiv1 % numDiv2
                    numDiv1 = numDiv2
                    if (resto != 0)
                        numDiv2 = resto
                }
                while (resto != 0)

                txtResul.setText(numDiv2)
            }
            catch (e:Exception) {
                Toast.makeText(this, "Error en cálculo de MCD: ", Toast.LENGTH_LONG)
                txtResul.setText("")
            }
        } else
            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG)

    }

    private fun calcularMCM() {
        if (!camposVacios()) {
            var dato1 = Integer.parseInt(campoNumUno.text.toString())
            var dato2 = Integer.parseInt(campoNumUno.text.toString())

            var multiplo: Int

            try{
                if (dato1 > dato2)
                    multiplo = dato1
                else
                    multiplo = dato2

                while (multiplo % dato1 !== 0 || multiplo % dato2 !== 0)
                    multiplo++

                txtResul.setText(multiplo)
            }
            catch (e:Exception) {
                Toast.makeText(this, "Error en cálculo de MCM: ", Toast.LENGTH_LONG)
                txtResul.setText("")
            }


        } else
            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_LONG)
    }


    private fun camposVacios(): Boolean {
        return campoNumUno.text.toString() === " " && campoNumDos.text.toString() === " "
    }
}
