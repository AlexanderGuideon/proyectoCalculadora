package com.example.proyectocalculadora.utilidades;

import android.provider.BaseColumns;

public final class UtilidadesContract {

    private UtilidadesContract(){}

    public static class TablaObra implements BaseColumns {

        public static final String NOMBRE_TABLA = "funciones";
        public static final String CAMPO_TITULO = "titulo";
        public static final String CAMPO_EXPRESION = "expresion";


        public static final String CREAR_TABLA = "CREATE TABLE " + TablaObra.NOMBRE_TABLA + " ("
                + TablaObra._ID + " INTEGER PRIMARY KEY,"
                + TablaObra.CAMPO_TITULO + " TEXT,"
                + TablaObra.CAMPO_EXPRESION + " TEXT)";

        public static final String BORRAR_ENTRADAS_TABLA = "DROP TABLE IF EXISTS " + TablaObra.NOMBRE_TABLA;

    }

}
