package com.example.proyectocalculadora;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.proyectocalculadora.entidades.Funciones;
import com.example.proyectocalculadora.utilidades.ConexionSQLiteHelper;
import com.example.proyectocalculadora.utilidades.FuncionesBD;

/**
 * ActivityVerFuncion: muestra informacion de la funcion que ha seleccionado el usuario.
 * Permite calcular la expresion y borrarla de la bd.
 */

public class ActivityVerFuncion extends ActivityPadre {

    TextView nombre;
    TextView expresion;
    TextView resultado;
    Funciones funcion;
    Button btBorrar;
    Button btCalcular;

    private View.OnClickListener onClickCalcular;
    private View.OnClickListener onClickBorrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_funcion);

        obtenerElementos();
        valoresLayout();
        establecerEventos();
        registrarEventos();

    }

    private void metodoBorrado(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityVerFuncion.this);
        builder.setMessage("¿Desea borrarlo?");
        builder.setTitle("ATENCION:");
        final View vista = v;
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                borrar(vista);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog  = builder.create();
        dialog.show();
    }

    private void establecerEventos() {

        onClickCalcular = new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                calcular(v);
            }

        };

        onClickBorrar = new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                metodoBorrado(v);
            }

        };
    }

    private void registrarEventos() {
        btCalcular.setOnClickListener(onClickCalcular);
        btBorrar.setOnClickListener(onClickBorrar);
    }

    private void obtenerElementos() {

        nombre = (TextView)findViewById(R.id.tvTitle);
        expresion = (TextView)findViewById(R.id.tvContent);
        resultado = findViewById(R.id.tvResult);
        btBorrar = findViewById(R.id.ivDelete);
        btCalcular = findViewById(R.id.ivCalcu);
    }

    private void borrar(View v) {
        String titulo = nombre.getText().toString();
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(ActivityVerFuncion.this);
        FuncionesBD gestionBD = new FuncionesBD(conn);
        Funciones comprobado = gestionBD.obtener(titulo);

        if(comprobado!=null){
            gestionBD.borrarFuncion(nombre.getText().toString());
            Toast.makeText(getApplicationContext(),"Eliminado Correctamente",Toast.LENGTH_LONG).show();
            finish();
        }
        else
            Toast.makeText(getApplicationContext(),"Ese nombre no existe",Toast.LENGTH_LONG).show();
    }


    public void calcular(View v){
        try{
            String expr = expresion.getText().toString();
            Double datoResul = new EvaluadorExpresiones(expr).getResultado();
            resultado.setText(datoResul.toString());
        }
        catch (Exception e){
            Toast.makeText(ActivityVerFuncion.this, "Expresion Invalida", Toast.LENGTH_LONG).show();
        }
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
