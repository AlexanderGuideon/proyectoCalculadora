package com.example.proyectocalculadora;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class ActivityFunciones extends ActivityPadre {

    private MiArrayAdapter aa;
    private SQLiteHelper helper;
    private SQLiteDatabase bd;
    private ArrayList<Funcion> funciones;
    private ListView lista;
    private Button opcAnyadirFunciones;
    private String nombre;
    private String expresion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones);
        opcAnyadirFunciones = findViewById(R.id.opcAnyadirFunciones);

        abrirBD();

        Intent intent = getIntent();
        if(intent != null){

            nombre = intent.getStringExtra("Nombre");
            expresion = intent.getStringExtra("Expresion");
            startActivity(intent);

            agregar();
        }


        funciones = cargarLista();


        if(funciones != null){
            establecerLista();
        }


        opcAnyadirFunciones.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityAnyadirFunciones.class);
                startActivity(intent);
            }
        });


    }

    private void agregar() {
        if(bd != null){
            bd.execSQL("Insert into funciones values(nombre,expresion)");
        }
    }

    private void establecerLista() {
        lista = (ListView) findViewById(R.id.lista);
        //ArrayAdapter <Integer> aa = new ArrayAdapter<Integer>(this, R.layout.item_basico, array);
        //ArrayAdapter<Integer> aa = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, array);//en android.r hay layouts predefinidos
        aa = new MiArrayAdapter(this, funciones);
        lista.setAdapter(aa);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Pulsado ítem: "+ i, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Pulsado largo ítem: "+ i, Toast.LENGTH_SHORT).show();

                ListView lista = (ListView) findViewById(R.id.lista);
                /*Funcion lib = ((MiArrayAdapter)lista.getAdapter()).getItem(i);
                ((MiArrayAdapter)lista.getAdapter()).remove(lib);*/
                Funcion lib = (Funcion)aa.getItem(i);
                aa.remove(lib);

                return true;
            }
        });


        lista.setEmptyView((findViewById(R.id.vacia)));
    }

    private ArrayList<Funcion> cargarLista() {
        if(bd != null){
            ArrayList<Funcion> lista = new ArrayList<Funcion>();
            String[] valores_recuperar = {"nombre", "expresion"};
            Cursor c = bd.query("contactos", valores_recuperar,
                    null, null, null, null, null, null);
            c.moveToFirst();
            do {
                Funcion funcion= new Funcion(c.getString(0), c.getString(1));
                lista.add(funcion);
            } while (c.moveToNext());
            c.close();
            return lista;
        }
        return null;
    }

    private void abrirBD() {

        try{
            //Abrimos la base de datos 'DBFunciones' en modo escritura
            helper = new SQLiteHelper(this, "DBFunciones", null, 1);

            bd = helper.getWritableDatabase();

        }catch(Exception e){
            Toast.makeText(this,"Error al abrir bd",Toast.LENGTH_LONG).show();
        }

    }

    private void cerrarBD() {

        if(bd != null)
            bd.close();
        else
            Toast.makeText(this,"Error al cerrar bd",Toast.LENGTH_LONG).show();
    }


}
