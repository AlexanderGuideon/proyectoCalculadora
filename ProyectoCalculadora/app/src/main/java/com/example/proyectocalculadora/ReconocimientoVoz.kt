package com.example.proyectocalculadora
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.widget.TextView
import android.widget.Toast


class ReconocimentoVoz:AppCompatActivity() {

        var grabar: TextView? = null

        private val RECOGNIZE_SPEECH_ACTIVITY = 1
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            grabar = findViewById(R.id.tvExpresion)


        }

        override fun onActivityResult(requestCode: Int, resultCode: Int,
                                      data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            when (requestCode) {
                RECOGNIZE_SPEECH_ACTIVITY ->

                    if (resultCode == Activity.RESULT_OK && null != data) {

                        val speech = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                        val strSpeech2Text = speech[0]

                        grabar?.setText(strSpeech2Text)
                    }
                else -> {
                }
            }
        }

        fun hablar(v: View) {

            val intentActionRecognizeSpeech = Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

            // Configura el Lenguaje (Español-México)
            intentActionRecognizeSpeech.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-ES")
            try {
                startActivityForResult(intentActionRecognizeSpeech,
                    RECOGNIZE_SPEECH_ACTIVITY)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(applicationContext,
                    "Tú dispositivo no soporta el reconocimiento por voz",
                    Toast.LENGTH_SHORT).show()
            }

        }

}
