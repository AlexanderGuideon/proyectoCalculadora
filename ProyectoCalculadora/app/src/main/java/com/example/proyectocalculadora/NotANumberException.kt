package com.example.proyectocalculadora



class NotANumberException : Throwable(){

    fun getMensaje() {
        print("Error en la expresion, formato no numerico")
    }
}
