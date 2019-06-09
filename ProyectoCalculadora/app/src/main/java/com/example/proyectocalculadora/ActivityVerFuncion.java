package com.example.proyectocalculadora;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.proyectocalculadora.entidades.Funciones;
import com.example.proyectocalculadora.utilidades.ConexionSQLiteHelper;
import com.example.proyectocalculadora.utilidades.FuncionesBD;


public class ActivityVerFuncion extends AppCompatActivity {

    TextView nombre;
    TextView expresion;
    TextView resultado;
    Funciones funcion;
    Button btBorrar;
    Button btCalcular;
    String textoExpresion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ver_funcion);

        nombre = (TextView)findViewById(R.id.tvTitle);
        expresion = (TextView)findViewById(R.id.tvContent);
        resultado = findViewById(R.id.tvResult);

        btBorrar = findViewById(R.id.ivDelete);
        btCalcular = findViewById(R.id.ivCalcu);

        valoresLayout();

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expr = expresion.getText().toString();
                Double datoResul = new EvaluadorExpresiones(expr).getResultado();
                resultado.setText(datoResul.toString());
            }
        });

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = nombre.getText().toString();
                ConexionSQLiteHelper conn = new ConexionSQLiteHelper(ActivityVerFuncion.this);
                FuncionesBD gestionBD = new FuncionesBD(conn);
                Funciones comprobado = gestionBD.obtener(titulo);

                if(comprobado!=null){
                    gestionBD.borrarFuncion(nombre.getText().toString());

                    String mensaje = "Eliminado Correctamente";

                    Intent i = new Intent(ActivityVerFuncion.this, ActivityFunciones.class);
                    i.putExtra("mensaje", mensaje);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Ese nombre no existe",Toast.LENGTH_LONG).show();

            }
        });

    }

    public void valoresLayout(){
        Intent intent = getIntent();
        funcion = (Funciones)intent.getSerializableExtra("funcion");

        if(funcion != null){
            nombre.setText(funcion.getTitulo());
            expresion.setText(funcion.getExpresion());
        }

        else {
            nombre.setText("Vacio");
            expresion.setText("Vacio");
        }
    }
}
