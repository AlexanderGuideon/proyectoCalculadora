package com.example.proyectocalculadora.utilidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.example.proyectocalculadora.entidades.Funciones;

import java.util.ArrayList;

public class FuncionesBD {

    ConexionSQLiteHelper conn;
    ArrayList<Funciones> funciones;


    public FuncionesBD(ConexionSQLiteHelper conn) {
        this.conn = conn;
        funciones = new ArrayList<>();
    }

    public Funciones borrarFuncion(String nombre){
        Funciones funcion = null;
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            Cursor cursor = db.query(UtilidadesContract.TablaObra.NOMBRE_TABLA, null, null, null, null, null, null);

            while (cursor.moveToNext()) {

                String titulo = cursor.getString(1);
                String expr = cursor.getString(2);
                if(titulo.equals(nombre)){
                    funcion = new Funciones(titulo,expr);
                    SQLiteDatabase dbW =conn.getReadableDatabase();
                    String sql = "DELETE FROM "+UtilidadesContract.TablaObra.NOMBRE_TABLA+" WHERE "+UtilidadesContract.TablaObra.CAMPO_TITULO +"=?";
                    SQLiteStatement delete = dbW.compileStatement(sql);
                    delete.clearBindings();
                    delete.bindString(1, funcion.getTitulo());
                    delete.executeUpdateDelete();
                    dbW.close();
                    cursor.close();
                    db.close();
                }
            }
            cursor.close();
            db.close();
            return funcion;

        } catch (Exception e) {
            db.close();
            return null;
        }

    }

    public void registarFunciones(Context context) {

        String[] titulos = datosTitulos();
        String[] expresiones = datosFechas();

        SQLiteDatabase db = conn.getWritableDatabase();


        for (int i = 0; i < titulos.length; i++) {



            String sql = "INSERT INTO " + UtilidadesContract.TablaObra.NOMBRE_TABLA + "("
                    + UtilidadesContract.TablaObra.CAMPO_TITULO + ","
                    + UtilidadesContract.TablaObra.CAMPO_EXPRESION +") VALUES(?,?)";
            SQLiteStatement insert = db.compileStatement(sql);
            insert.clearBindings();
            insert.bindString(1, titulos[i]);
            insert.bindString(2, expresiones[i]);


            insert.executeInsert();
        }
        db.close();


    }

    public Funciones obtener(String nombre){
        Funciones funcion = null;
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            Cursor cursor = db.query(UtilidadesContract.TablaObra.NOMBRE_TABLA, null, null, null, null, null, null);

            while (cursor.moveToNext()) {

                String titulo = cursor.getString(1);
                String expr = cursor.getString(2);
                if(titulo.equals(nombre)){
                    funcion = new Funciones(titulo,expr);
                }
            }
            cursor.close();
            db.close();
            return funcion;

        } catch (Exception e) {
            db.close();
            return null;
        }
    }

    public ArrayList<Funciones> generarObras() {
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            Cursor cursor = db.query(UtilidadesContract.TablaObra.NOMBRE_TABLA, null, null, null, null, null, null);
            while (cursor.moveToNext()) {

                String tit = cursor.getString(1);
                String date = cursor.getString(2);
                funciones.add(new Funciones(tit, date));

            }
            cursor.close();
            db.close();
            return funciones;
        } catch (Exception e) {
            db.close();
            return null;
        }
    }

    public void registrarFuncion(String nombre, String expresion){

        SQLiteDatabase db = conn.getReadableDatabase();
        SQLiteDatabase dbWrite = conn.getWritableDatabase();

        try {

                    Funciones funcion = new Funciones(nombre,expresion);

                    String sql = "INSERT INTO " + UtilidadesContract.TablaObra.NOMBRE_TABLA + "("
                            + UtilidadesContract.TablaObra.CAMPO_TITULO + ","
                            + UtilidadesContract.TablaObra.CAMPO_EXPRESION +") VALUES(?,?)";
                    SQLiteStatement insert = dbWrite.compileStatement(sql);
                    insert.clearBindings();
                    insert.bindString(1, funcion.getTitulo());
                    insert.bindString(2, funcion.getExpresion());
                    insert.executeInsert();
                    db.close();


        } catch (Exception e) {
            db.close();

        }
    }


    public int contarObras() {
        SQLiteDatabase db = conn.getReadableDatabase();
        int cont = 0;
        try {
            Cursor cursor = db.query(UtilidadesContract.TablaObra.NOMBRE_TABLA, null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                cont++;
            }
            cursor.close();
            db.close();
            return cont;
        } catch (Exception e) {
            db.close();
            return 0;
        }
    }


    public String[] datosTitulos() {
        String[] titulos = {"Funcion 1", "Suma Resta Divide", "Producto", "Prueba 2", "Mi Funcion", "Potencia", "Seno de 90"};
        return titulos;
    }

    public String[] datosFechas() {
        String[] expresiones = {"4-(5*3)", "(4+6-5)/3", "5*(6+4)", "4/0", "(4*(5^2))/3", "2^10", "sen(90)"};
        return expresiones;
    }
}
