package com.example.proyectocalculadora
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.speech.RecognizerIntent
import android.widget.TextView
import android.widget.Toast

import android.os.Bundle
import android.widget.Button


class ReconocimentoVoz:ActivityPadre() {

    lateinit var grabar: TextView
    lateinit var hablar: Button
    lateinit var calcular: Button

    private val RECOGNIZE_SPEECH_ACTIVITY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reconocimiento_voz)
        grabar = findViewById(R.id.txtGrabarVoz) as TextView
        hablar = findViewById((R.id.btnHablar))
        calcular = findViewById(R.id.btnCalcular)

        hablar.setOnClickListener { v ->
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

        calcular.setOnClickListener { v ->

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