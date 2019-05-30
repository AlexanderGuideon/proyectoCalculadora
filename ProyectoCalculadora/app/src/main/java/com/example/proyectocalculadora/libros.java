package com.example.proyectocalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;

public class libros extends AppCompatActivity {


    private MiArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones);

        ListView lista = (ListView) findViewById(R.id.lista);
        obtenerFunciones(lista);




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

                Funcion funcion = (Funcion)aa.getItem(i);
                aa.remove(funcion);

                return true;
            }
        });


        //lista.setEmptyView((ImageView)findViewById(R.id.vacia));

        aa.sort(
                new Comparator<Funcion>() {
                    @Override
                    public int compare(Funcion funcion1, Funcion funcion2) {
                        return funcion1.getFecha().toString().compareToIgnoreCase(funcion2.getFecha().toString());
                    }
                }
        );
    }

    private void obtenerFunciones(ListView lista) {
        ArrayList<Funcion> funciones = new ArrayList<Funcion>();
        funciones.add(new Funcion());





        aa = new MiArrayAdapter(this, funciones);
        lista.setAdapter(aa);
    }



}
