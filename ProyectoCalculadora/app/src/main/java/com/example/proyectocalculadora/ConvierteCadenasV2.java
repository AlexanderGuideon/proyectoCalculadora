public class ConvierteCadenas{

  static boolean esNum = false;
  static boolean esSimbolo = false;
  static boolean esFun = false;
  
  public static void main(String[]args){
    String cadena = "ochocientoscincomil doscientos doce";
    
    String palabras [] = cadena.split(" ");
    String resul = "";
    String palabra = "";
    
    for(int i = 0; i<palabras.length;i++){
        resul += conversion(palabras[i]);
    }
    
    if(cadena.endsWith("diez")||cadena.endsWith("enta")||cadena.endsWith("einte"))
  		resul += "0";
  	else if(cadena.endsWith("mil"))
  		resul += "000";
  	else if(cadena.endsWith("millon"))
  	    resul += "000000";
  	    
    System.out.println(resul);
  }
  
  public static String conversion(String cadena){
  
        String resul = "";
        
        boolean esmil
        boolean esciento = false;
        boolean esdecena = false;
        
            
            
            if(cadena.startsWith("dieci")){
                 resul += "1";
                 esdecena = true;
            }
            if(cadena.startsWith("veinti")){
                 resul += "2";
                 esdecena = true;
            }
            if(cadena.startsWith("treinta")){
                 resul += "3";
                 esdecena = true;
            }
            if(cadena.startsWith("cuarenta")){
                 resul += "4";
                 esdecena = true;
            }
            if(cadena.startsWith("cincuenta")){
                 resul += "5";
                 esdecena = true;
            }
            if(cadena.startsWith("sesenta")){
                 resul += "6";
                 esdecena = true;
            }
            if(cadena.startsWith("setenta")){
                 resul += "7";
                 esdecena = true;
            }
            if(cadena.startsWith("ochenta")){
                 resul += "8";
                 esdecena = true;
            }
            if(cadena.startsWith("noventa")){
                 resul += "9";
                 esdecena = true;
            }
            
            
            
  	        if(cadena.contains("un"))
  		          resul += "1"; 
  	        if(cadena.contains("dos"))
  		          resul += "2";
  	        if(cadena.contains("tres"))
  		          resul += "3";
  	        if(cadena.contains("cuatro"))
  		          resul += "4";
  	        if(cadena.contains("cinco"))
  		          resul += "5";
  	        if(cadena.contains("seis"))
  		          resul += "6";
  	        if(cadena.contains("siete"))
  		          resul += "7";
  	        if(cadena.contains("ocho"))
  		          resul += "8";
  	        if(cadena.contains("nueve"))
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
  	   
      return resul;
  }
  
}
