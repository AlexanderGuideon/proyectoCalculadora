package com.example.proyectocalculadora

class EvaluadorExpresiones {


    var resultado :Double = 0.0

    constructor(expresion : String){
         resultado = eval(expresion)
    }



    /**
     * Metodo eval: evalua la expresion matematica recibida como parametro y calcula y devuelve su resultado.
     * Si no es una expresion valida muestra el mensaje correspondiente.
     * E: String str : expresion a evaluar.
     * S: Double x: valor obtenido de calcular la expresion evaluada.
     */
    fun eval(str: String): Double {

        return object : Any() {

            internal var pos = -1
            internal var ch: Int = 0


            internal fun calcularFactorial(x: Double?): Double {
                val num = Math.round(x!!).toDouble()
                var fact = num
                var i = num - 1.0
                while (i > 0.0) {
                    fact = fact * i
                    i--
                }

                return fact
            }


            internal fun nextChar() {

                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            internal fun eat(charToEat: Int): Boolean {

                while (ch == ' '.toInt()) nextChar()

                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            internal fun parse(): Double {

                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Caracter: '" + ch.toChar() + "' inesperado. Error de sintaxis.")
                return x
            }


            internal fun parseExpression(): Double {

                var x = parseTerm()

                while (true) {
                    if (eat('+'.toInt()))
                        x += parseTerm() //suma
                    else if (eat('-'.toInt()))
                        x -= parseTerm() //resta
                    else
                        return x
                }
            }

            internal fun parseTerm(): Double {
                var x = parseFactor()

                while (true) {
                    if (eat('*'.toInt()))
                        x *= parseFactor() //Multiplicacion
                    else if (eat('/'.toInt()))
                        x /= parseFactor() //Division
                    else
                        return x
                }
            }


            internal fun parseFactor(): Double {

                if (eat('+'.toInt())) return parseFactor() //Simbolo suma
                if (eat('-'.toInt())) return -parseFactor() //Simbolo resta

                var x: Double

                val startPos = this.pos

                if (eat('('.toInt())) { //Parentesis
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) { //Numeros
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                    x = java.lang.Double.parseDouble(str.substring(startPos, this.pos))
                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) { //Funciones

                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, this.pos)
                    x = parseFactor()
                    if (func == "sqrt")
                        x = Math.sqrt(x)//Radicación
                    else if (func == "sin")
                        x = Math.sin(Math.toRadians(x))//Seno
                    else if (func == "cos")
                        x = Math.cos(Math.toRadians(x))//Coseno
                    else if (func == "tan")
                        x = Math.tan(Math.toRadians(x))//Tangente
                    else if (func == "asin")
                        x = Math.asin(Math.toRadians(x))//Arcoseno
                    else if (func == "acos")
                        x = Math.acos(Math.toRadians(x))//Arcocoseno
                    else if (func == "atan")
                        x = Math.atan(Math.toRadians(x))//Arcotangente
                    else if (func == "log")
                        x = Math.log(x)//Logaritmo
                    else
                        throw RuntimeException("Funcion desconocida: $func")
                } else {
                    throw RuntimeException("Caracter: '" + ch.toChar() + "' inesperado. Error de sintaxis.")
                }

                if (eat('^'.toInt())) x = Math.pow(x, parseFactor())//Potencia
                if (eat('!'.toInt())) x = calcularFactorial(x)//Factorial
                if (eat('%'.toInt())) x = x * 100 / x//Porcentaje

                return x
            }


        }.parse()
    }



}