package com.example.proyectocalculadora;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.proyectocalculadora.entidades.Funciones;
import com.example.proyectocalculadora.utilidades.AdaptadorLista;
import com.example.proyectocalculadora.utilidades.ConexionSQLiteHelper;
import com.example.proyectocalculadora.utilidades.FuncionesBD;

import java.util.ArrayList;

/**
 * Activity que muestra un listado de funciones introducidas por el usuario.
 * Por defecto siempre habra 7 en caso de no haber ninguna en la bd.
 */

public class ActivityFunciones extends ActivityPadre{


    ListView listaFunciones;
    ArrayList<Funciones> funciones;
    AdaptadorLista adaptador;
    FuncionesBD gestionBD;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones);
        encontrarElementos();
        cargarLista();
        establecerEventos();

    }

    @Override
    protected void onStart() {
        super.onStart();
        encontrarElementos();
        cargarLista();
        establecerEventos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        encontrarElementos();
        cargarLista();
        establecerEventos();
    }

    private void establecerEventos() {

        listaFunciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                abrirFuncion(parent, view, position, id);
            }
        });

        listaFunciones.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                abrirCompartir(position);
                return true;
            }

        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAgregar(v);
            }
        });

    }

    private void abrirCompartir(int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityFunciones.this);
        builder.setMessage("¿Desea compartirlo?");
        builder.setTitle("ATENCION:");
        final int i = position;
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                compartir(i);
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

    public void compartir(int position){
        try{
            String titulo = funciones.get(position).getTitulo();
            String expresion = funciones.get(position).getExpresion();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Queria compartir mi funcion contigo: Titulo->"+titulo+" Expresion->"+expresion+".");
            startActivity(Intent.createChooser(intent, "Compartir con..."));
        }catch(Exception e){
            Toast.makeText(ActivityFunciones.this,"No se pudo compartir",Toast.LENGTH_LONG).show();
        }
    }

    private void cargarLista() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this);
        gestionBD = new FuncionesBD(conn);

        /* Si ejecuta por primera vez y los datos están vacios se llenan*/
        if (gestionBD.contar() == 0) {
            gestionBD.registarFunciones(this);
        }
        funciones = gestionBD.generar();
        //Si esta vacía la lista se infla el ViewStub
        if(funciones.size() == 0){
            ViewStub stub = findViewById(R.id.stub);
            View inflated = stub.inflate();
        }
        adaptador = new AdaptadorLista(this, funciones);
        listaFunciones.setAdapter(adaptador);
    }

    private void encontrarElementos() {
        agregar = findViewById(R.id.botonAgregar);
        listaFunciones = (ListView) findViewById(R.id.listaFunciones);
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
