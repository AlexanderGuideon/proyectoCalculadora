internal class ConvierteCadenas {
  var noNum = true
  var esSimbolo = false
  var esFun = false
  companion object {
    fun conversion(palabra:String, resul:String):String {
      when (palabra) {
        "cero" -> {
          if (esFun)
          resul += "0)"
          resul += "0"
          noNum = false
        }
        "un", "uno", "mi" -> {
          if (esFun)
          resul += "1)"
          resul += "1"
          noNum = false
        }
        "ve", "bi", "dos" -> {
          if (esFun)
          resul += "2)"
          resul += "2"
          noNum = false
        }
        "tri", "tre" -> {
          if (esFun)
          resul += "3)"
          resul += "3"
          noNum = false
        }
        "cuar", "cuatri", "cuatro" -> {
          if (esFun)
          resul += "4)"
          resul += "4"
          noNum = false
        }
        "quin", "cinco" -> {
          if (esFun)
          resul += "5)"
          resul += "5"
          noNum = false
        }
        "sixti", "seis" -> {
          if (esFun)
          resul += "6)"
          resul += "6"
          noNum = false
        }
        "septi", "set", "siete" -> {
          if (esFun)
          resul += "7)"
          resul += "7"
          noNum = false
        }
        "ochen", "octi", "ocho" -> {
          if (esFun)
          resul += "8)"
          resul += "8"
          noNum = false
        }
        "nona", "nove", "nueve" -> {
          if (esFun)
          resul += "9)"
          resul += "9"
          noNum = false
        }
        else -> noNum = true
      }
      if (noNum)
      {
        when (palabra) {
          "mas" -> {
            resul += "+"
            esSinbolo = true
          }
          "menos" -> {
            resul += "-"
            esSinbolo = true
          }
          "multiplicado" -> {
            resul += "*"
            esSinbolo = true
          }
          "dividido" -> {
            resul += "/"
            esSinbolo = true
          }
          "elevado" -> {
            resul += "^"
            esSinbolo = true
          }
          "raiz" -> {
            resul += "sqrt("
            esFun = true
            esSinbolo = true
          }
          "factorial" -> {
            resul += "!"
            esSinbolo = true
          }
          "seno" -> {
            resul += "sen("
            esSinbolo = true
            esFun = true
          }
          "coseno" -> {
            resul += "cos("
            esSinbolo = true
            esFun = true
          }
          "arcoseno" -> {
            resul += "asen("
            esSinbolo = true
            esFun = true
          }
          "arcocoseno" -> {
            resul += "acos("
            esSinbolo = true
            esFun = true
          }
          "tangente" -> {
            resul += "tan("
            esSinbolo = true
            esFun = true
          }
          "arcotangente" -> {
            resul += "atan("
            esSinbolo = true
            esFun = true
          }
          "con", "coma" -> {
            resul += "."
            esSinbolo = true
            esFun = true
          }
        }
      }
      if (!esSimbolo)
      {
        when (palabra) {
          "diez", "enta", "einte" -> resul += "0"
          "cien" -> resul += "00"
          "mil" -> resul += "000"
          "llon", "millon" -> resul += "000000"
        }
      }
      if (noNum && !esFun && !esSimbolo)
      resul += ""
    }
  }
}
