package com.example.proyectocalculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window

class ActivityFunciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_funciones)
    }
}
