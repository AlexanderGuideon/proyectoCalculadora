package com.example.proyectocalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Float.parseFloat

/**
 * ActivityEcuacion: resuelve las ecuaciones de primer grado y segundo grado con los datos introducidos
 */
class ActivityEcuacion : ActivityPadre() {


    private lateinit var txtA :EditText
    private lateinit var txtB :EditText
    private lateinit var txtC :EditText
    private lateinit var txtEcuacion:EditText
    private lateinit var btPrimerGrado:Button
    private lateinit var btSegundoGrado:Button
    private lateinit var btResolver:Button

    private var esPrimerGrado = false
    private var ecuacionSelecionada = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuacion)

        encontrarElementos()
        establecerEventos()

    }

    private fun establecerEventos() {

        btPrimerGrado.setOnClickListener {
            resolverPrimerGrado()
        }

        btSegundoGrado.setOnClickListener {
            resolverSegundoGrado()
        }

        btResolver.setOnClickListener {
            resolver()
        }

    }

    private fun resolver() {
        if(ecuacionSelecionada){
            if(esPrimerGrado)
                calcularPrimerGrado()
            else
                calcularSegundoGrado()
        }
        else
            Toast.makeText(this,"No seleccionaste ecuacion",Toast.LENGTH_LONG).show()
    }

    private fun resolverSegundoGrado() {

        txtEcuacion.setText("Ax^2 + Bx + C")
        txtA.visibility = View.VISIBLE
        txtB.visibility = View.VISIBLE
        txtC.visibility = View.VISIBLE
        esPrimerGrado = false
        ecuacionSelecionada = true
    }

    private fun resolverPrimerGrado() {

        txtEcuacion.setText("Ax + B")
        txtA.visibility = View.VISIBLE
        txtB.visibility = View.VISIBLE
        txtC.visibility = View.INVISIBLE
        esPrimerGrado=true
        ecuacionSelecionada = true
    }

    private fun encontrarElementos() {

        txtEcuacion = findViewById<View>(R.id.txtEcuacion) as EditText
        txtA = findViewById(R.id.txtA)
        txtB = findViewById(R.id.txtB)
        txtC = findViewById(R.id.txtC)

        txtA.visibility = View.INVISIBLE
        txtB.visibility = View.INVISIBLE
        txtC.visibility = View.INVISIBLE

        btPrimerGrado = findViewById<Button>(R.id.btPrimerGrado)
        btSegundoGrado = findViewById<Button>(R.id.btSegundoGrado)
        btResolver = findViewById<Button>(R.id.btResolver)

    }

    private fun calcularPrimerGrado() {

        if(!txtA.text.toString().equals("")||!txtB.text.toString().equals("")){
            var numA = parseFloat(txtA.text.toString()).toDouble()
            var numB = parseFloat(txtB.text.toString()).toDouble()
            var resul = (-numB)/numA
            txtEcuacion.setText(resul.toString())
            txtA.setText("")
            txtB.setText("")
        }
        else
            Toast.makeText(this,"Datos vacios",Toast.LENGTH_LONG).show()
    }

    private fun calcularSegundoGrado() {

        if(!txtA.text.toString().equals("")||!txtB.text.toString().equals("")||!txtC.text.toString().equals("")){
            var numA = parseFloat(txtA.text.toString()).toDouble()
            var numB = parseFloat(txtB.text.toString()).toDouble()
            var numC = parseFloat(txtC.text.toString()).toDouble()

            var expresion = (numB*numB-4*numA*numC)


            if(numB*numB<4*numA*numC){
                txtEcuacion.setText("Solucion con numeros complejos.");
            }
            else if(numA!=0.0 && (numB*numB)>(4*numA*numC)){
                txtEcuacion.setText("R1: "+(-numB+Math.sqrt(expresion))/(2*numA)+"\n")
                txtEcuacion.append("R2: "+(-numB-Math.sqrt(expresion))/(2*numA))
            }

            txtA.setText("")
            txtB.setText("")
            txtC.setText("")
        }
        else
            Toast.makeText(this,"Datos vacios",Toast.LENGTH_LONG).show()


    }
}
