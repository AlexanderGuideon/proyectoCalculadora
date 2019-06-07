package com.example.proyectocalculadora;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAnyadirFunciones extends AppCompatActivity {

    EditText txtNombre = findViewById(R.id.edtTitle);
    EditText txtResultado = findViewById(R.id.edtContent);
    Button btn0 = findViewById(R.id.btn0);
    Button btn1 = findViewById(R.id.btn1);
    Button btn2 = findViewById(R.id.btn2);
    Button btn3 = findViewById(R.id.btn3);
    Button btn4 = findViewById(R.id.btn4);
    Button btn5 = findViewById(R.id.btn5);
    Button btn6 = findViewById(R.id.btn6);
    Button btn7 = findViewById(R.id.btn7);
    Button btn8 = findViewById(R.id.btn8);
    Button btn9 = findViewById(R.id.btn9);

    Button btnSumar = findViewById(R.id.btnSuma);
    Button btnRestar = findViewById(R.id.btnResta);
    Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
    Button btnDividir = findViewById(R.id.btnDividir);
    Button btnRadicacion = findViewById(R.id.btnRaiz);

    Button btnSen = findViewById(R.id.btnSen);
    Button btnCos = findViewById(R.id.btnCos);
    Button btnTan = findViewById(R.id.btnTan);
    Button btnASen = findViewById(R.id.btnaSen);
    Button btnACos = findViewById(R.id.btnaCos);
    Button btnATan = findViewById(R.id.btnaTan);
    Button btnPotenciacion = findViewById(R.id.btnPotencia);
    Button btnPunto = findViewById(R.id.btnPunto);
    Button btnParDer = findViewById(R.id.btnParDer);
    Button btnParIzq = findViewById(R.id.btnParIzq);

    Button btnLimpiar = findViewById(R.id.btnLimpiar);

    Button btAnyadir = findViewById(R.id.btAnyadir);

    private View.OnClickListener onClick;
    private View.OnClickListener onClickLimpiar;

    String valorA = "";
    String resul = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadir_funciones);
    }

    private void registrarEventos() {


        onClick = new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                ponerDato(v);
            }

        };


        onClickLimpiar = new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                limpiar(v);
            }

        };


    }

    private void establecerEventos() {


        if(onClick != null){

            //Elementos Numericos
            btn0.setOnClickListener(onClick);
            btn1.setOnClickListener(onClick);
            btn2.setOnClickListener(onClick);
            btn3.setOnClickListener(onClick);
            btn4.setOnClickListener(onClick);
            btn5.setOnClickListener(onClick);
            btn6.setOnClickListener(onClick);
            btn7.setOnClickListener(onClick);
            btn8.setOnClickListener(onClick);
            btn9.setOnClickListener(onClick);

            //Elementos Operadores
            btnPunto.setOnClickListener(onClick);
            btnSumar.setOnClickListener(onClick);
            btnRestar.setOnClickListener(onClick);
            btnDividir.setOnClickListener(onClick);
            btnMultiplicar.setOnClickListener(onClick);
            btnPotenciacion.setOnClickListener(onClick);
            btnParDer.setOnClickListener(onClick);
            btnParIzq.setOnClickListener(onClick);

            //Elementos funcion  
            btnRadicacion.setOnClickListener(onClick);
            btnSen.setOnClickListener(onClick);
            btnCos.setOnClickListener(onClick);
            btnTan.setOnClickListener(onClick);

            btAnyadir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(txtNombre.getText().toString()!="" && txtResultado.getText().toString() != ""){
                        Intent intent = new Intent(getApplicationContext(),ActivityFunciones.class);
                        intent.putExtra("Nombre",txtNombre.getText().toString());
                        intent.putExtra("Expresion",txtResultado.getText().toString());
                        startActivity(intent);
                    }
                    Toast.makeText(getApplicationContext(),"Campos vacios",Toast.LENGTH_LONG).show();

                }
            });

        }


        if(onClickLimpiar != null)
            btnLimpiar.setOnClickListener(onClickLimpiar);

    }


    private void ponerDato(View v) {

         Button dato = (Button) v;

        if(dato.getText().toString() == "n!")
            valorA += "!";
        else
            valorA += dato.getText();

        txtResultado.setText(valorA);
    }



    private void limpiar(View v){
        if(txtResultado.getText().toString()!= ""){
            valorA = "";
            txtResultado.setText(valorA);
            resul = "";
        }
    }

    private void borrar(View v){
        if(txtResultado.getText().toString()!= ""){
            valorA = valorA.substring(0,valorA.length()-1);
            txtResultado.setText(valorA);
            resul = txtResultado.getText().toString();
        }
    }
}
