package com.example.proyectocalculadora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MiArrayAdapter extends ArrayAdapter<Funcion> {
    public MiArrayAdapter(Context context, Funcion [] libros){
        super(context, 0, libros);
    }

    public MiArrayAdapter(Context context, List<Funcion> libros){
        super(context, 0, libros);
    }


    @Override
    public int getItemViewType(int position) {
        return (getItem(position).getExpresion() == null ? 1:0);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Funcion l = getItem(position);
        View v = null;
        ViewHolder vh = null;
        TextView tvNombre = null;
        TextView tvExpresion = null;
        if(convertView!=null) {
            if((((ViewHolder)convertView.getTag()).tvExpresion == null) && (l.getExpresion() == null)){
                v = convertView;
                vh = (ViewHolder)v.getTag();
                //tvNombre = vh.tvNombre;
                vh.tvNombre.setText(l.getNombre());
            }
            else if((((ViewHolder)convertView.getTag()).tvExpresion != null) && (l.getExpresion() != null)){
                v = convertView;
                vh = (ViewHolder)v.getTag();
                /*tvExpresion = vh.tvExpresion;
                tvNombre = vh.tvNombre;*/
                vh.tvNombre.setText(l.getNombre());
                vh.tvExpresion.setText(l.getExpresion());
            }

        }
        else {
            //  IMPORTANTE : el tercer parametro esta a false porque se veria dos veces ya que el list view ya introduce el elemento por defecto.
            if(l.getExpresion() == null)
                v = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            else
                v = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);

            vh = new ViewHolder();
            tvNombre = (TextView) v.findViewById(android.R.id.text1);
            vh.tvNombre = tvNombre;
            tvNombre.setText(l.getNombre());
            if(l.getExpresion() != null ){
                tvExpresion = (TextView) v.findViewById(android.R.id.text2);
                vh.tvExpresion = tvExpresion;
                tvExpresion.setText(l.getExpresion());
            }
            else
                tvExpresion=null;

            v.setTag(vh);
        }//getLayoutInflater() ==> layouts



        return v;
    }

    //Clase que  sera nuestro viewHolder y que contendra las vistas mas frecuentes.
    private class ViewHolder{
        public TextView tvExpresion;
        public TextView tvNombre;

    }

}
