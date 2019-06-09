package com.example.proyectocalculadora

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
        var esParder:Boolean = false
        var esParIzq:Boolean = false
        for (valor :String in array){


            if(pattern.containsMatchIn(valor)){
                when{
                    valor == "he" || valor == "eh" || valor == "e" -> simbolo="π"
                    valor == "pi" -> simbolo="3.1415926535"
                    valor == "con" || valor=="coma" -> operador="."
                    valor == "factorial" -> operador="!"
                    valor == "menos" -> operador = "-"
                    valor == "mas" -> operador = "+"
                    valor == "entre" || valor=="dividido" || valor=="partido" -> operador = "/"
                    valor == "por" || valor == "x" -> operador = "*"
                    valor == "elevado" -> operador = "^"
                    valor == "porciento" || valor == "ciento"-> operador = "%"
                    valor == "raiz"-> operador = "√"
                    valor == "logaritmo"-> funcion= "log("
                    valor == "seno"-> funcion= "sin("
                    valor == "coseno"-> funcion= "cos("
                    valor == "tangente"-> funcion= "tan("
                    valor == "arcoseno"-> funcion= "asin("
                    valor == "arcocoseno"-> funcion= "acos("
                    valor == "arcotangente" -> funcion= "atan("

                }
                if(operador != ""){
                    operacion += operador
                    operador=""
                }
                if(simbolo != ""){
                    operacion += simbolo
                    simbolo=""
                }

            }
            else{
                if(patternNum.containsMatchIn(valor)){
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