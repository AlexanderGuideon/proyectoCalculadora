package com.example.proyectocalculadora

/**
 * Clase que convierte la cadena recogida por Reconocimiento voz e interpreta
 * los operadores y las funciones que correspondan.
 */

class ConvierteCadenas {

    var resul:Double = 0.0
    constructor(cadena: String){
        var convertida = conversor(cadena)
        resul = EvaluadorExpresiones(convertida).resultado
    }

    private fun conversor(cadena :String):String{

        var array : List<String> = cadena.toString().split(" ")
        var operacion : String = ""
        var pattern = Regex("[a-zA-Z]")
        var patternNum = Regex("[0-9]")
        var funcion:String = ""
        var operador: String = ""
        var numero:String = ""
        var simbolo:String = ""
        for (valor :String in array){


            if(pattern.containsMatchIn(valor)){
                when{
                    valor == "abre"->operador = "("
                    valor == "cierra"->operador = ")"
                    valor == "con" || valor=="coma" -> operador="."
                    valor == "factorial" -> operador="!"
                    valor == "menos" -> operador = "-"
                    valor == "mas" -> operador = "+"
                    valor == "entre" || valor=="dividido" || valor=="partido" -> operador = "/"
                    valor == "por" || valor == "x" -> operador = "*"
                    valor == "elevado" -> operador = "^"
                    valor == "porciento" || valor == "ciento"-> operador = "%"
                    valor == "raiz" || valor == "raíz"-> funcion = "sqrt("
                    valor == "logaritmo"-> funcion= "log("
                    valor == "seno"-> funcion= "sen("
                    valor == "coseno"-> funcion= "cos("
                    valor == "tangente"-> funcion= "tan("
                    valor == "arcoseno"-> funcion= "asen("
                    valor == "arcocoseno"-> funcion= "acos("
                    valor == "arcotangente" -> funcion= "atan("

                }
                if(operador != ""){
                    operacion += operador
                    operador=""
                }

            }
            else{


                if(patternNum.containsMatchIn(valor)){
                    if(valor.contains(",")){
                        var arraychar = valor.split(",")
                        var StrValor = (arraychar[0]+"."+arraychar[1]).toString()
                        numero = StrValor
                    }
                    else
                        numero = valor



                    if(funcion != ""){
                        numero = funcion + valor +")"
                        funcion = ""
                    }

                    if(operador != ""){
                        operacion += operador
                        operador=""
                    }

                    if(numero != ""){
                        operacion += numero
                        numero = ""
                    }
                }
                else{
                    if(valor == "." ||valor == "%" || valor == "+" || valor == "-" || valor == "/" || valor == "x"){
                        if(valor == "x")
                            operacion+="*"
                        else
                            operacion += valor
                    }

                }
            }
        }
        return operacion
    }
}