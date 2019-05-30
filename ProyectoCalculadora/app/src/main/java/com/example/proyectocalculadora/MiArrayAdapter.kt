package com.example.proyectocalculadora

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MiArrayAdapter : ArrayAdapter<Funcion> {

    constructor(context: Context, funciones: Array<Funcion>) : super(context, 0, funciones) {}

    constructor(context: Context, funciones: List<Funcion>) : super(context, 0, funciones) {}

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position)!!.expresion == null) 1 else 0
    }

    override fun getViewTypeCount(): Int {
        return 2
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val funcion = getItem(position)
        var v: View? = null
        var vh: ViewHolder? = null
        var tvTitulo: TextView? = null
        var tvExpresion: TextView? = null
        if (convertView != null) {
            if ((convertView.tag as ViewHolder).tvExpresion == null && funcion!!.expresion == null) {
                v = convertView
                vh = v.tag as ViewHolder
                vh.tvTitulo!!.text = funcion.nombre
            } else if ((convertView.tag as ViewHolder).tvExpresion != null && funcion!!.expresion != null) {
                v = convertView
                vh = v.tag as ViewHolder
                vh.tvTitulo!!.text = funcion.nombre
                vh.tvExpresion!!.text = funcion.expresion
            }

        } else {
            //  IMPORTANTE : el tercer parametro esta a false porque se veria dos veces ya que el list view ya introduce el elemento por defecto.
            if (funcion!!.expresion == null)
                v = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            else
                v = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)

            vh = ViewHolder()
            tvTitulo = v!!.findViewById<View>(android.R.id.text1) as TextView
            vh.tvTitulo = tvTitulo
            tvTitulo.text = funcion.nombre
            if (funcion.expresion != null) {
                tvExpresion = v.findViewById<View>(android.R.id.text2) as TextView
                vh.tvExpresion = tvExpresion
                tvExpresion.text = funcion.expresion
            } else
                tvExpresion = null

            v.tag = vh
        }



        return v
    }

    //Clase que  sera nuestro viewHolder y que contendra las vistas mas frecuentes.
    private inner class ViewHolder {
        var tvTitulo: TextView? = null
        var tvExpresion: TextView? = null

    }
}
