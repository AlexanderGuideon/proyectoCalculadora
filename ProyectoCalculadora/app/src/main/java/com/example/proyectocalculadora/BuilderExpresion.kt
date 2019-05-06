package com.example.proyectocalculadora

class BuilderExpresion(txt: String) {


    fun evaluate(expr:String){

        if (expr.isEmpty()) throw IllegalArgumentException("La expresion no puede estar vacía")
        println("Para la expresion = $expr\n")
        val tokens = expr.split(' ').filter { it != "" }
        val stack = mutableListOf<Double>()
        for (token in tokens) {
            val d = token.toDoubleOrNull()
            if (d != null) {
                stack.add(d)
                println(" $d   Pone el numero al principio del stack  $stack")
            }
            else if ((token.length > 1) || (token !in "+-*/^")) {
                throw IllegalArgumentException("$token no es un valor valido")
            }
            else if (stack.size < 2) {
                throw IllegalArgumentException("El stack contiene demasiados operandos")
            }
            else {
                val d1 = stack.removeAt(stack.lastIndex)
                val d2 = stack.removeAt(stack.lastIndex)
                stack.add(when (token) {
                    "+"  -> d2 + d1
                    "-"  -> d2 - d1
                    "*"  -> d2 * d1
                    "/"  -> d2 / d1
                    else -> Math.pow(d2, d1)
                })
                println(" $token Aplica al principio del stack   $stack")
            }
        }
    }

}
