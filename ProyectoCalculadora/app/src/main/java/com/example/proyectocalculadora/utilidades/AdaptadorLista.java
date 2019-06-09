package com.example.proyectocalculadora.utilidades;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.proyectocalculadora.R;
import com.example.proyectocalculadora.entidades.Funciones;

import java.util.ArrayList;

public class AdaptadorLista extends ArrayAdapter<Funciones> {

    Context contexto;
    ArrayList<Funciones> listaFunciones;

    public AdaptadorLista(Context contexto, ArrayList<Funciones> listaFunciones) {
        super(contexto, 0, listaFunciones);
        this.contexto = contexto;
        this.listaFunciones = listaFunciones;
    }

    @Override
    public int getCount() {
        return listaFunciones.size();
    }

    @Override
    public Funciones getItem(int position) {
        Log.d("Posicion:",""+position);
        return listaFunciones.get(position);
    }

    @Override
    public long getItemId(int position) { return listaFunciones.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("Posicion3:",""+position);
        Funciones funcion = listaFunciones.get(position);
        View v = convertView;

        ViewHolder holder = new ViewHolder();

        if (v == null) {
            v = LayoutInflater.from(contexto).inflate(R.layout.plantilla_item, null);
            /* -------------------------------------- */
            holder.titulo = (TextView) v.findViewById(R.id.titulo);
            holder.expresion = (TextView) v.findViewById(R.id.expresion);

            /* -------------------------------------- */
            holder.titulo.setText(funcion.getTitulo());
            holder.expresion.setText(funcion.getExpresion());

            v.setTag(holder);
        } else {
            v = convertView;
            holder = (ViewHolder) v.getTag();
            holder.titulo.setText(funcion.getTitulo());
            holder.expresion.setText(funcion.getExpresion());
        }

        return v;
    }

    private class ViewHolder {
        public TextView titulo;
        public TextView expresion;


    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
