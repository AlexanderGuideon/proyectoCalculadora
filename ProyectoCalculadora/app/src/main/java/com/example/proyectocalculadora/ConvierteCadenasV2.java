class ConvierteCadenas{

  static boolean esNum = false;
  static boolean esSimbolo = false;
  static boolean esFun = false;
  
  public static void main(String[]args){
    String cadena = "ochomil doscientos doce";
    
    String palabras [] = cadena.split(" ");
    String resul = "";
   
    for(int i = 0; i<palabras.length;i++){
    	String palabra = palabras[i]; 
       	resul = conversion(palabra,resul);    	
 
    }
    
  }
  
  public static String conversion(String cadena, String resul){
  
    if(cadena.endsWith("diez")||cadena.endsWith("enta")||cadena.endsWith("einte"))
  		resul += "0";
  	else if(cadena.endsWith("mil"))
  		resul += "000";
  	else if(cadena.endsWith("millon"))
  		resul += "000000";
    
    else{
  
  	if(cadena.contains("un")||cadena.startsWith("dieci")||cadena.startsWith("ciento"))
  		resul += "1"; 
  	if(cadena.contains("dos")||cadena.startsWith("veinti")||cadena.startsWith("dosciento"))
  		resul += "2";
  	if(cadena.contains("tres")||cadena.startsWith("treinta")||cadena.startsWith("tresciento"))
  		resul += "3";
  	if(cadena.contains("cuatro")||cadena.startsWith("cuarenta")||cadena.startsWith("cuatrociento"))
  		resul += "4";
  	if(cadena.contains("cinco")||cadena.startsWith("cincuenta")||cadena.startsWith("quiniento"))
  		resul += "5";
  	if(cadena.contains("seis")||cadena.startsWith("sesenta")||cadena.startsWith("seiciento"))
  		resul += "6";
  	if(cadena.contains("siete")||cadena.startsWith("setenta")||cadena.startsWith("seteciento"))
  		resul += "7";
  	if(cadena.contains("ocho")||cadena.startsWith("ochenta")||cadena.startsWith("ochocientos"))
  		resul += "8";
  	if(cadena.contains("nueve")||cadena.startsWith("noventa")||cadena.startsWith("novecientos"))
  		resul += "9";
  	if(cadena.contains("once"))
  		resul += "11";
  	if(cadena.contains("doce"))
  		resul += "12";
  	if(cadena.contains("trece"))
  		resul += "13";
  	if(cadena.contains("catorce"))
  		resul += "14";
  	if(cadena.contains("quince"))
  		resul += "15";
  	
  	}
  	
  		
      return resul;
  }
}
