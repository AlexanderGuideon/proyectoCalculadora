package com.example.proyectocalculadora
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.speech.RecognizerIntent
import android.widget.TextView
import android.widget.Toast

import android.os.Bundle
import android.view.View
import android.widget.Button

/**
 * ReconocimientoVoz: Recoge las operaciones que el usuario diga por voz y las envia al
 * conversor de cadenas y este a su vez al evaluador de expresiones.
 */
class ReconocimentoVoz:ActivityPadre() {

    lateinit var grabar: TextView
    lateinit var hablar: Button
    lateinit var calcular: Button

    private val RECOGNIZE_SPEECH_ACTIVITY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reconocimiento_voz)
        encontrarElementos()
        establecerEventos()
    }

    private fun establecerEventos() {
        hablar.setOnClickListener { v ->
            accionHablar(v)
        }

        calcular.setOnClickListener { v ->

            accionCalcular(v)

        }
    }

    private fun accionCalcular(v: View) {

        try{

            var texto = grabar.text.toString()
            if(texto != ""){

                var expresion = ConvierteCadenas(texto).resul

                grabar.setText(expresion.toString())

            }
            else{
                Toast.makeText(
                    applicationContext,
                    "Sin texto",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        catch (a: Exception) {
            Toast.makeText(
                applicationContext,
                "Texto invalido",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun accionHablar(v: View) {

        grabar.setText("")
        val intentActionRecognizeSpeech = Intent(
            RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        )
        // Configura el Lenguaje (Español-México)
        intentActionRecognizeSpeech.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-Es"
        )
        try {
            startActivityForResult(
                intentActionRecognizeSpeech,
                RECOGNIZE_SPEECH_ACTIVITY
            )
        } catch (a: ActivityNotFoundException) {
            Toast.makeText(
                applicationContext,
                "Tú dispositivo no soporta el reconocimiento por voz",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun encontrarElementos() {
        grabar = findViewById(R.id.txtGrabarVoz) as TextView
        hablar = findViewById((R.id.btnHablar))
        calcular = findViewById(R.id.btnCalcular)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            RECOGNIZE_SPEECH_ACTIVITY -> if (resultCode == Activity.RESULT_OK && null != data) {
                val speech = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                val strSpeech2Text = speech[0]
                grabar.text = strSpeech2Text
            }
            else -> {
            }
        }
    }

}