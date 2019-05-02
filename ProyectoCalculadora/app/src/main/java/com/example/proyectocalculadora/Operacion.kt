package com.example.proyectocalculadora

import android.util.Log


class Operacion(num1:Double, num2:Double) {

    var num1:Double = 0.toDouble()
    var num2:Double = 0.toDouble()
    var resultado: Double = 0.toDouble()
    
    fun sum( num1: Double, num2: Double): Double = num1 + num2

    fun rest( num1: Double, num2: Double): Double = num1 - num2

    fun mult( num1: Double, num2: Double): Double = num1 * num2

    fun div( num1: Double, num2: Double): Double? {
        try {

            if(num2 == 0.toDouble())
                throw NotANumberException()
            else
                return num1 / num2
        }
        catch (nan: NotANumberException ){
            Log.d("Operacion", "Indeterminacion")
        }
        return null
    }

    fun fact(a: Int): Double {

            resultado = 1.0

            for(i in a downTo 1)
                resultado = resultado *i

            return resultado
    }

    fun pot( a: Double,  b: Int): Double {

        var result:Double = 1.0

        for(i in 1..b)
            result = result*a

        return result
    }

    fun exp( x: Double): Double{

        var result:Double = 0.0

        for(n in 0..40){
            val anterior = result
            result = result+(pot(x,n)/fact(n))
            if (anterior == result) break
        }

        return result
    }

    fun sin( x: Double): Double{
        var result:Double = 0.0
        for(n in 0..40){
            val anterior = result
            result = result+(pot(-1.0,n)/fact(2*n+1)*pot(x,2*n+1))
            if (anterior == result) break
        }
        return result
    }

    fun cos( x: Double): Double{
        var result:Double = 0.0
        for(n in 0..40){
            val anterior = result
            result = result+(pot(-1.0,n)/fact(2*n)*pot(x,2*n))
            if (anterior == result) break
        }
        return result
    }
}



