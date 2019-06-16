package com.example.proyectocalculadora.utilidades;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.example.proyectocalculadora.entidades.Funciones;

import java.util.ArrayList;


/**
 * Clase: FuncionesBD
 * Desc: En esta clase estan las operaciones que realizaremos sobre la base de datos.
 */
public class FuncionesBD {

    ConexionSQLiteHelper conn;
    ArrayList<Funciones> funciones;


    public FuncionesBD(ConexionSQLiteHelper conn) {
        this.conn = conn;
        funciones = new ArrayList<>();
    }

    /**
     * Metodo:borrarFuncion
     * Desc: Borra una funcion de la bd.
     * @param nombre
     * @return funcion
     */

    public Funciones borrarFuncion(String nombre){
        Funciones funcion = null;
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            Cursor cursor = db.query(UtilidadesContract.Tabla.NOMBRE_TABLA, null, null, null, null, null, null);

            while (cursor.moveToNext()) {

                String titulo = cursor.getString(1);
                String expr = cursor.getString(2);
                if(titulo.equals(nombre)){
                    funcion = new Funciones(titulo,expr);
                    SQLiteDatabase dbW =conn.getReadableDatabase();
                    String sql = "DELETE FROM "+UtilidadesContract.Tabla.NOMBRE_TABLA+" WHERE "+UtilidadesContract.Tabla.CAMPO_TITULO +"=?";
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


    /**
     * Metodo: registrarFunciones
     * Desc: Introduce las funciones por defecto en  la bd.
     * @param context
     */
    public void registarFunciones(Context context) {

        String[] titulos = datosTitulos();
        String[] expresiones = datosExpre();

        SQLiteDatabase db = conn.getWritableDatabase();


        for (int i = 0; i < titulos.length; i++) {



            String sql = "INSERT INTO " + UtilidadesContract.Tabla.NOMBRE_TABLA + "("
                    + UtilidadesContract.Tabla.CAMPO_TITULO + ","
                    + UtilidadesContract.Tabla.CAMPO_EXPRESION +") VALUES(?,?)";
            SQLiteStatement insert = db.compileStatement(sql);
            insert.clearBindings();
            insert.bindString(1, titulos[i]);
            insert.bindString(2, expresiones[i]);


            insert.executeInsert();
        }
        db.close();


    }


    /**
     * Metodo: obtener
     * Desc: obtiene la funcion que se le ha apasado como parametro
     * @param nombre
     * @return funcion
     */
    public Funciones obtener(String nombre){
        Funciones funcion = null;
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            Cursor cursor = db.query(UtilidadesContract.Tabla.NOMBRE_TABLA, null, null, null, null, null, null);

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


    /**
     * Metodo: generar
     * Desc: genera el ArrayList con funciones de la bd
     * @return funciones
     */
    public ArrayList<Funciones> generar() {
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            Cursor cursor = db.query(UtilidadesContract.Tabla.NOMBRE_TABLA, null, null, null, null, null, null);
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


    /**
     * Metodo: registrarFuncion
     * Desc: Inserta una nueva funcion a la bd
     * @param nombre
     * @param expresion
     */
    public void registrarFuncion(String nombre, String expresion){

        SQLiteDatabase db = conn.getReadableDatabase();
        SQLiteDatabase dbWrite = conn.getWritableDatabase();

        try {

                    Funciones funcion = new Funciones(nombre,expresion);

                    String sql = "INSERT INTO " + UtilidadesContract.Tabla.NOMBRE_TABLA + "("
                            + UtilidadesContract.Tabla.CAMPO_TITULO + ","
                            + UtilidadesContract.Tabla.CAMPO_EXPRESION +") VALUES(?,?)";
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

    /**
     * Metodo: contar
     * Desc: cuenta el numero de funciones de la bd
     * @return
     */
    public int contar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        int cont = 0;
        try {
            Cursor cursor = db.query(UtilidadesContract.Tabla.NOMBRE_TABLA, null, null, null, null, null, null);
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

    /**
     * Datos de titulos
     * @return titulos
     */

    public String[] datosTitulos() {
        String[] titulos = {"Funcion 1", "Suma Resta Divide", "Producto", "Prueba 2", "Mi Funcion", "Potencia", "Seno de 90"};
        return titulos;
    }

    /**
     * Datos de expresiones
     * @return expresiones
     */
    public String[] datosExpre() {
        String[] expresiones = {"4-(5*3)", "(4+6-5)/3", "5*(6+4)", "4/0", "(4*(5^2))/3", "2^10", "sen(90)"};
        return expresiones;
    }
}
