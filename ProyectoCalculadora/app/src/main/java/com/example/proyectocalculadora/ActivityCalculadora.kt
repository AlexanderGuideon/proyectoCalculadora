package com.example.proyectocalculadora
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView



class ActivityCalculadora : AppCompatActivity() {

    // TextView para  input y output
    lateinit var tvExpresion: TextView

    // Ultimo numero pulsado
    var banderaNumero: Boolean = false

    // Ultimo stadoError
    var stadoError: Boolean = false

    // Controla el que se ponga mas de un punto
    var banderaPunto: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvExpresion = findViewById(R.id.tvExpresion)
    }

    /**
     * Append del digito al TextView
     */
    fun onDigit(view: View) {
        if (stadoError) {
            //Si el estado actual es un error sustituye el mensaje
            tvExpresion.text = (view as Button).text
            stadoError = false
        } else {
            // Si no se hace append sobre la expresion correcta actual
            tvExpresion.append((view as Button).text)
        }
        // Actualizamos bandera
        banderaNumero = true
    }

    /**
     * Append . al TextView
     */
    fun onDecimalPoint(view: View) {
        if (banderaNumero && !stadoError && !banderaPunto) {
            tvExpresion.append(".")
            banderaNumero = false
            banderaPunto = true
        }
    }

    /**
     * Append +,-,*,/ de los operadores en el TextView
     */
    fun onOperator(view: View) {
        if (banderaNumero && !stadoError) {
            tvExpresion.append((view as Button).text)
            banderaNumero = false
            banderaPunto = false    // Reset the DOT flag
        }
    }


    /**
     * Limpiar TextView
     */
    fun onClear(view: View) {
        this.tvExpresion.text = ""
        banderaNumero = false
        stadoError = false
        banderaPunto = false
    }

    /**
     * Calcular la expresion usando una clase aparte
     */
    fun onEqual(view: View) {
        // If the current state is error, nothing to do.
        // If the last input is a number only, solution can be found.
        if (banderaNumero && !stadoError) {
            // Read the expression
            val txt = tvExpresion.text.toString()
            // Create an Expression (A class from exp4j library)
            BuilderExpresion().evaluate(txt)
            try {
                /* Calcular el resultado y mostrarlo con el TextView
                val result = expression.evaluate()
                tvExpresion.text = result.toString()*/
                banderaPunto = true // Result contains a dot
            } catch (ex: ArithmeticException) {
                // Muestra mensaje de error Aritmetico
                tvExpresion.text = "Error"
                stadoError = true
                banderaNumero = false
            }
        }
    }
}


