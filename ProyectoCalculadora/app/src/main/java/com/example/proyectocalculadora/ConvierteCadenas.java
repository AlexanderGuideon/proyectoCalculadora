class ConvierteCadenas{
  boolean noNum = true;
  boolean esSimbolo = false;
  boolean esFun = false;
  
  public static String conversion(String palabra, String resul){
    switch(palabra){
      case "cero":
        if(esFun)
          resul+="0)";
        resul+="0";
        noNum=false;
        break;
      case "un" :
      case "uno":
      case "mi":
        if(esFun)
          resul+="1)";
        resul+="1";
        noNum = false;
        break;
      case "ve":  
      case "bi":  
      case "dos":
        if(esFun)
          resul+="2)";
        resul+="2";
        noNum = false;
        break;
      case "tri":  
      case "tre":
        if(esFun)
          resul+="3)";
        resul+="3";
        noNum = false;
        break;
      case "cuar":
      case "cuatri":  
      case "cuatro":
        if(esFun)
          resul+="4)";
        resul+="4";
        noNum = false;
        break;
      case "quin":  
      case "cinco":
        if(esFun)
          resul+="5)";
        resul+="5";
        noNum = false;
        break;
      case "sixti":  
      case "seis":
        if(esFun)
          resul+="6)";
        resul+="6";
        noNum = false;
        break;
      case "septi":  
      case "set":
      case "siete":
        if(esFun)
          resul+="7)";
        resul+="7";
        noNum = false;
        break;
      case "ochen":  
      case "octi":
      case "ocho":
        if(esFun)
          resul+="8)";
        resul+="8";
        noNum = false;
        break;
      case "nona":
      case "nove":  
      case "nueve":
        if(esFun)
          resul+="9)";
        resul+="9";
        noNum = false;
        break;
      default:
        noNum=true
    }
    
    if(noNum){
      switch(palabra){
        case "mas":
          resul+="+";
          esSinbolo=true;
          break;
        case "menos":
          resul+="-";
          esSinbolo=true;
          break;
        case "multiplicado":
          resul+="*";
          esSinbolo=true;
          break;
        case "dividido":
          resul+="/";
          esSinbolo=true;
          break;
        case "elevado":
          resul+="^";
          esSinbolo=true;
          break;
        case "raiz":
          resul+="sqrt(";
          esFun=true;
          esSinbolo=true;
          break;
        case "factorial":
          resul+="!";
          esSinbolo=true;
          break;
        case "seno":
          resul+="sen(";
          esSinbolo=true;
          esFun=true;
          break;
        case "coseno":
          resul+="cos(";
          esSinbolo=true;
          esFun=true;
          break;
        case "arcoseno":
          resul+="asen(";
          esSinbolo=true;
          esFun=true;
          break;
        case "arcocoseno":
          resul+="acos(";
          esSinbolo=true;
          esFun=true;
          break;
        case "tangente":
          resul+="tan(";
          esSinbolo=true;
          esFun=true;
          break;
        case "arcotangente":
          resul+="atan(";
          esSinbolo=true;
          esFun=true;
          break;
        case "con":
        case "coma":
          resul+=".";
          esSinbolo=true;
          esFun=true;
          break;
      }
    }
    
    if(!esSimbolo){
      switch(palabra){
        case "diez":
        case "enta":
        case "einte":
          resul += "0";
          break;
        case "cien":
          resul += "00";
          break;
        case "mil":
          resul += "000";
          break;
        case "llon":
        case "millon":  
          resul += "000000";
          break;
      }
    }
    
    if(noNum && !esFun && !esSimbolo)
      resul+="";
  }
}
