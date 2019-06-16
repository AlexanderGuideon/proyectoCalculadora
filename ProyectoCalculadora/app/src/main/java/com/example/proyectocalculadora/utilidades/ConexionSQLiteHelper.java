package com.example.proyectocalculadora.utilidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Clase: ConexionSQLiteHelper
 * Desc: Clase que sirve para conectarse a la bd
 */
public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    public static final int VERSION_BD = 1;
    public static final String NOMBRE_BD = "misfunciones.db";

    public ConexionSQLiteHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilidadesContract.Tabla.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UtilidadesContract.Tabla.BORRAR_ENTRADAS_TABLA);
        onCreate(db);
    }
}
