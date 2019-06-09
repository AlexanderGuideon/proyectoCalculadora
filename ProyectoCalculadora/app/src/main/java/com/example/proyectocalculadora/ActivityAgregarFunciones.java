package com.example.proyectocalculadora;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.proyectocalculadora.entidades.Funciones;
import com.example.proyectocalculadora.utilidades.ConexionSQLiteHelper;
import com.example.proyectocalculadora.utilidades.FuncionesBD;

public class ActivityAgregarFunciones extends AppCompatActivity {


    EditText txtNombre;
    EditText txtResultado;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnSumar;
    Button btnRestar;
    Button btnMultiplicar;
    Button btnDividir;
    Button btnRadicacion;

    Button btnSen;
    Button btnCos;
    Button btnTan;
    Button btnASen;
    Button btnACos;
    Button btnATan;
    Button btnPotenciacion;
    Button btnPunto;
    Button btnParDer;
    Button btnParIzq;

    Button btnLimpiar;

    Button btAnyadir;

    private View.OnClickListener onClick;
    private View.OnClickListener onClickLimpiar;

    String valorA = "";
    String resul = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_agregar_funciones);


        obtenterElementos();
        registrarEventos();
        establecerEventos();
    }

    private void obtenterElementos() {

        txtNombre = findViewById(R.id.edtTitle);
        txtResultado = findViewById(R.id.edtContent);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnSumar = findViewById(R.id.btnSuma);
        btnRestar = findViewById(R.id.btnResta);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnRadicacion = findViewById(R.id.btnRaiz);

        btnSen = findViewById(R.id.btnSen);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        btnASen = findViewById(R.id.btnaSen);
        btnACos = findViewById(R.id.btnaCos);
        btnATan = findViewById(R.id.btnaTan);
        btnPotenciacion = findViewById(R.id.btnPotencia);
        btnPunto = findViewById(R.id.btnPunto);
        btnParDer = findViewById(R.id.btnParDer);
        btnParIzq = findViewById(R.id.btnParIzq);

        btnLimpiar = findViewById(R.id.btnLimpiar);

        btAnyadir = findViewById(R.id.btAnyadir);
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
            btnASen.setOnClickListener(onClick);
            btnACos.setOnClickListener(onClick);
            btnATan.setOnClickListener(onClick);

            btAnyadir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombre = txtNombre.getText().toString();
                    String resultado = txtResultado.getText().toString();

                    if(resultado!="" && nombre != ""){
                        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(ActivityAgregarFunciones.this);
                        FuncionesBD gestionBD = new FuncionesBD(conn);
                        Funciones comprobado = gestionBD.obtener(nombre);

                        if(comprobado==null){
                            gestionBD.registrarFuncion(txtNombre.getText().toString(),txtResultado.getText().toString());
                            String mensaje = "Agregado Correctamente";
                            Intent i = new Intent(ActivityAgregarFunciones.this, ActivityFunciones.class);
                            i.putExtra("mensaje", mensaje);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Ese nombre ya existe",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Campos Vacios"+resultado,Toast.LENGTH_LONG).show();


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
}
