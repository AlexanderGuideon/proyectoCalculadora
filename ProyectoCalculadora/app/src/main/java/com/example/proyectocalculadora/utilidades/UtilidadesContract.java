package com.example.proyectocalculadora.utilidades;

import android.provider.BaseColumns;

public final class UtilidadesContract {

    private UtilidadesContract(){}

    /**
     * Datos de nuestra tabla en la bd.
     */
    public static class Tabla implements BaseColumns {

        public static final String NOMBRE_TABLA = "funciones";
        public static final String CAMPO_TITULO = "titulo";
        public static final String CAMPO_EXPRESION = "expresion";


        public static final String CREAR_TABLA = "CREATE TABLE " + Tabla.NOMBRE_TABLA + " ("
                + Tabla._ID + " INTEGER PRIMARY KEY,"
                + Tabla.CAMPO_TITULO + " TEXT,"
                + Tabla.CAMPO_EXPRESION + " TEXT)";

        public static final String BORRAR_ENTRADAS_TABLA = "DROP TABLE IF EXISTS " + Tabla.NOMBRE_TABLA;

    }

}
