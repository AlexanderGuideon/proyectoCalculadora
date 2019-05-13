import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class CientificaActivity:ActionBarActivity() {

  internal var txtResultado:EditText
  internal var btn0:Button
  internal var btn1:Button
  internal var btn2:Button
  internal var btn3:Button
  internal var btn4:Button
  internal var btn5:Button
  internal var btn6:Button
  internal var btn7:Button
  internal var btn8:Button
  internal var btn9:Button
  internal var btnPunto:Button
  internal var btnSumar:Button
  internal var btnRestar:Button
  internal var btnDividir:Button
  internal var btnMultiplicar:Button
  internal var btnPotenciacion:Button
  internal var btnRadicacion:Button
  internal var btnSen:Button
  internal var btnaSen:Button
  internal var btnCos:Button
  internal var btnaCos:Button
  internal var btnTan:Button
  internal var btnaTan:Button
  internal var btndiv1:Button
  internal var btnFact:Button
  internal var btnIgual:Button
  internal var btnBorrar:Button
  internal var btnLimpiar:Button
  internal var ValorA = ""
  internal var ValorB = ""
  internal var operador = ' '
  internal var cont = ""
  internal var decimal = false

  protected fun onCreate(savedInstanceState:Bundle) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState)
    setContentView(R.layout.cientifica)
    txtResultado = findViewById(R.id.txtResultado) as EditText
    btn0 = findViewById(R.id.btn0) as Button
    btn1 = findViewById(R.id.btn1) as Button
    btn2 = findViewById(R.id.btn2) as Button
    btn3 = findViewById(R.id.btn3) as Button
    btn4 = findViewById(R.id.btn4) as Button
    btn5 = findViewById(R.id.btn5) as Button
    btn6 = findViewById(R.id.btn6) as Button
    btn7 = findViewById(R.id.btn7) as Button
    btn8 = findViewById(R.id.btn8) as Button
    btn9 = findViewById(R.id.btn9) as Button
    btnSumar = findViewById(R.id.btnSuma) as Button
    btnRestar = findViewById(R.id.btnResta) as Button
    btnDividir = findViewById(R.id.btnDividir) as Button
    btnMultiplicar = findViewById(R.id.btnMultiplicar) as Button
    btnPotenciacion = findViewById(R.id.btnPotencia) as Button
    btnRadicacion = findViewById(R.id.btnRaiz) as Button
    btnSen = findViewById(R.id.btnSen) as Button
    btnaSen = findViewById(R.id.btnaSen) as Button
    btnCos = findViewById(R.id.btnCos) as Button
    btnaCos = findViewById(R.id.btnaCos) as Button
    btnTan = findViewById(R.id.btnTan) as Button
    btnaTan = findViewById(R.id.btnaTan) as Button
    btndiv1 = findViewById(R.id.btndiv1) as Button
    btnFact = findViewById(R.id.btnFact) as Button
    btnIgual = findViewById(R.id.btnIgual) as Button
    btnBorrar = findViewById(R.id.btnBorrar) as Button
    btnPunto = findViewById(R.id.btnPunto) as Button
    btnLimpiar = findViewById(R.id.btnLimpiar) as Button
    val onclick = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        ValorA += dato.getText()
        txtResultado.setText(ValorA)
      }
    }
    btn0.setOnClickListener(onclick)
    btn1.setOnClickListener(onclick)
    btn2.setOnClickListener(onclick)
    btn3.setOnClickListener(onclick)
    btn4.setOnClickListener(onclick)
    btn5.setOnClickListener(onclick)
    btn6.setOnClickListener(onclick)
    btn7.setOnClickListener(onclick)
    btn8.setOnClickListener(onclick)
    btn9.setOnClickListener(onclick)
    val onclickPunto = object:View.OnClickListener() {
      internal var hayPunto = false
      fun onClick(v:View) {
        val dato = v as Button
        try
        {
          val a = java.lang.Double.parseDouble(ValorA)
          if (a % 1 == 0.0)
          {
            ValorA += dato.getText()
            txtResultado.setText(ValorA)
          }
          else if (a % 1 != 0.0)
          {
            hayPunto = true
            return
          }
        }
        catch (nfe:NumberFormatException) {
          return
        }
      }
    }
    btnPunto.setOnClickListener(onclickPunto)

    val onclickOper = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        operador = dato.getText().charAt(0)
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
      }
    }
    btnSumar.setOnClickListener(onclickOper)
    btnRestar.setOnClickListener(onclickOper)
    btnDividir.setOnClickListener(onclickOper)
    btnMultiplicar.setOnClickListener(onclickOper)
    btnPotenciacion.setOnClickListener(onclickOper)
    val onclickOper1 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val a:Double
        a = java.lang.Float.parseFloat(ValorB).toDouble()
        val resultado = Math.sqrt(a)
        txtResultado.setText((resultado).toString())
      }
    }
    btnRadicacion.setOnClickListener(onclickOper1)
    val onclickOper2 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val b:Double
        val b1:Double
        b = java.lang.Float.parseFloat(ValorB).toDouble()
        b1 = Math.toRadians(b)
        val resultado = Math.sin(b1)
        txtResultado.setText((resultado).toString())
      }
    }
    btnSen.setOnClickListener(onclickOper2)
    val onclickOper3 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val c:Double
        val c1:Double
        c = java.lang.Float.parseFloat(ValorB).toDouble()
        c1 = Math.toRadians(c)
        val resultado = Math.cos(c1)
        txtResultado.setText((resultado).toString())
      }
    }
    btnCos.setOnClickListener(onclickOper3)
    val onclickOper4 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val d:Double
        val d1:Double
        d = java.lang.Float.parseFloat(ValorB).toDouble()
        d1 = Math.toRadians(d)
        val resultado = Math.tan(d1)
        txtResultado.setText((resultado).toString())
      }
    }
    btnTan.setOnClickListener(onclickOper4)
    val onclickOper5 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val e:Double
        e = java.lang.Float.parseFloat(ValorB).toDouble()
        val resultado = 1 / e
        txtResultado.setText((resultado).toString())
      }
    }
    btndiv1.setOnClickListener(onclickOper5)
    val onclickOper6 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val a:Double
        val a1:Double
        a = java.lang.Float.parseFloat(ValorB).toDouble()
        a1 = Math.toRadians(a)
        val resultado = Math.asin(a1)
        txtResultado.setText((resultado).toString())
      }
    }
    btnaSen.setOnClickListener(onclickOper6)
    val onclickOper7 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val b:Double
        val b1:Double
        b = java.lang.Float.parseFloat(ValorB).toDouble()
        b1 = Math.toRadians(b)
        val resultado = Math.acos(b1)
        txtResultado.setText((resultado).toString())
      }
    }
    btnaCos.setOnClickListener(onclickOper7)
    val onclickOper8 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val c:Double
        val c1:Double
        c = java.lang.Float.parseFloat(ValorB).toDouble()
        c1 = Math.toRadians(c)
        val resultado = Math.atan(c1)
        txtResultado.setText((resultado).toString())
      }
    }
    btnaTan.setOnClickListener(onclickOper8)
    val onclickOper9 = object:View.OnClickListener() {
      fun onClick(v:View) {
        val dato = v as Button
        cont = dato.getText().toString()
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
        val factorial = 1.0
        val numero = java.lang.Float.parseFloat(ValorB).toDouble()
        while (numero != 0.0)
        {
          factorial = factorial * numero
          numero--
        }
        txtResultado.setText((factorial).toString())
      }
    }
    btnFact.setOnClickListener(onclickOper9)
    val onclickResulOper = object:View.OnClickListener() {
      internal var resultado = 0.0
      internal var a:Double = 0.toDouble()
      internal var b:Double = 0.toDouble()
      //Scanner num = new Scanner(System.in);
      fun onClick(v:View) {
        try
        {
          when (operador) {
            '+' -> {
              resultado = (java.lang.Float.parseFloat(ValorB) + java.lang.Float.parseFloat(ValorA)).toDouble()
              //resultado = Integer.parseInt(ValorB) + Integer.parseInt(ValorA);
            }
            '-' -> {
              resultado = (java.lang.Float.parseFloat(ValorB) - java.lang.Float.parseFloat(ValorA)).toDouble()
              //resultado = Integer.parseInt(ValorB) - Integer.parseInt(ValorA);
            }
            '/' -> {
              resultado = (java.lang.Float.parseFloat(ValorB) / java.lang.Float.parseFloat(ValorA)).toDouble()
              //resultado = Integer.parseInt(ValorB) / Integer.parseInt(ValorA);
            }
            '*' -> {
              resultado = (java.lang.Float.parseFloat(ValorB) * java.lang.Float.parseFloat(ValorA)).toDouble()
              //resultado = Integer.parseInt(ValorB) * Integer.parseInt(ValorA);
            }
            '^' -> {
              a = java.lang.Float.parseFloat(ValorB).toDouble()
              b = java.lang.Float.parseFloat(ValorA).toDouble()
              resultado = Math.pow(a, b)
            }
            else -> {}
          }
          txtResultado.setText((resultado).toString())
        }
        catch (e:Exception) {
          txtResultado.setText("Error")
        }
      }
    }
    btnIgual.setOnClickListener(onclickResulOper)
    val onclickborrar = object:View.OnClickListener() {
      fun onClick(v:View) {
        val temporal = ValorB.substring(0, ValorB.length - 1)
        ValorB = temporal
        txtResultado.setText((ValorB).toString())
      }
    }
    btnBorrar.setOnClickListener(onclickborrar)
    val onclicklimpiar = object:View.OnClickListener() {
      fun onClick(v:View) {
        ValorA = ""
        ValorB = ""
        txtResultado.setText("")
      }
    }
    btnLimpiar.setOnClickListener(onclicklimpiar)
  }
}
