package com.example.proyectocalculadora;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.proyectocalculadora.entidades.Funciones;
import com.example.proyectocalculadora.utilidades.AdaptadorLista;
import com.example.proyectocalculadora.utilidades.ConexionSQLiteHelper;
import com.example.proyectocalculadora.utilidades.FuncionesBD;

import java.util.ArrayList;

public class ActivityFunciones extends AppCompatActivity {


    ListView listaFunciones;
    ArrayList<Funciones> funciones;
    AdaptadorLista adaptador;
    FuncionesBD gestionBD;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_funciones);

        Intent i = getIntent();
        if(i!=null){
            String mensaje = i.getStringExtra("mensaje");
            if(mensaje != null){
                Toast.makeText(ActivityFunciones.this,mensaje,Toast.LENGTH_LONG).show();
                ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this);
                gestionBD = new FuncionesBD(conn);
                listaFunciones = (ListView) findViewById(R.id.listaObras);
                if (gestionBD.contarObras() == 0) {
                    gestionBD.registarFunciones(this);
                }
                funciones = gestionBD.generarObras();
            }
        }


        agregar = findViewById(R.id.botonAgregar);
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this);
        gestionBD = new FuncionesBD(conn);
        listaFunciones = (ListView) findViewById(R.id.listaObras);

        /* Si ejecuta por primera vez y los datos están vacios se llenan*/
        if (gestionBD.contarObras() == 0) {
            gestionBD.registarFunciones(this);
        }
        funciones = gestionBD.generarObras();
        //Si esta vacía la lista de obras se infla el ViewStub
        if(funciones.size() == 0){
            ViewStub stub = findViewById(R.id.stub);
            View inflated = stub.inflate();
        }

        adaptador = new AdaptadorLista(this, funciones);
        listaFunciones.setAdapter(adaptador);
        listaFunciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(ActivityFunciones.this, "Id: "+position,Toast.LENGTH_LONG).show();
               abrirFuncion(parent, view, position, id);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAgregar(v);
            }
        });



    }

    private void abrirAgregar(View v) {
        try{
            Intent i = new Intent(this, ActivityAgregarFunciones.class);
            startActivity(i);
        }
        catch(Exception e){
            Toast.makeText(ActivityFunciones.this,"Error Agregar",Toast.LENGTH_SHORT).show();
        }

    }


    public void abrirFuncion(AdapterView<?> parent, View view, int position, long id) {


        String titulo = funciones.get(position).getTitulo();
        String expresion = funciones.get(position).getExpresion();
        Funciones funcion = new Funciones(titulo,expresion);



        try{
            Intent i = new Intent(this, ActivityVerFuncion.class);
            i.putExtra("funcion", funcion);



            startActivity(i);

        }catch (Exception e){
            Toast.makeText(ActivityFunciones.this,"No esta:"+ funcion.toString(),Toast.LENGTH_SHORT).show();
        }

    }


}
