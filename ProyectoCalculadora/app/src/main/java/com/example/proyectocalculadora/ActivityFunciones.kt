package com.example.proyectocalculadora

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button

class ActivityFunciones : ActivityPadre() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_funciones)
        val opcAnyadirFunciones = findViewById<View>(R.id.opcAnyadirFunciones) as Button

        opcAnyadirFunciones.setOnClickListener { mostrarAnyadirFunciones()}
    }

    private fun mostrarAnyadirFunciones() {
        val intent = Intent(this, ActivityAnyadirFunciones::class.java)
        startActivityForResult(intent, 0)
    }
}
