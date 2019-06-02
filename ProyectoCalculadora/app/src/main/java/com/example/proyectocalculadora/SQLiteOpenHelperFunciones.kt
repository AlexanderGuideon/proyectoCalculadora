package com.example.proyectocalculadora


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class FuncionesSQLiteHelper(contexto: Context, nombre: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(contexto, nombre, factory, version) {


    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
                ID + " INTEGER PRIMARY KEY," +
                NOMBRE + " TEXT," + EXPRESION + " TEXT);"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun addFuncion(funcion: Funcion): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NOMBRE, funcion.nombre)
        values.put(EXPRESION, funcion.expresion)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        return (Integer.parseInt("$_success") != -1)
    }

    fun getFuncion(_id: Int): Funcion {
        val funcion = Funcion()
        val db = writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $ID = $_id"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            cursor.moveToFirst()
            while (cursor.moveToNext()) {
                funcion.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                funcion.nombre = cursor.getString(cursor.getColumnIndex(NOMBRE))
                funcion.expresion = cursor.getString(cursor.getColumnIndex(EXPRESION))
            }
        }
        cursor.close()
        return funcion
    }

    val funciones: List<Funcion>
        get() {
            val taskList = ArrayList<Funcion>()
            val db = writableDatabase
            val selectQuery = "SELECT  * FROM $TABLE_NAME"
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor != null) {
                cursor.moveToFirst()
                while (cursor.moveToNext()) {
                    val funcion = Funcion()
                    funcion.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                    funcion.nombre = cursor.getString(cursor.getColumnIndex(NOMBRE))
                    funcion.expresion = cursor.getString(cursor.getColumnIndex(EXPRESION))

                    taskList.add(funcion)
                }
            }
            cursor.close()
            return taskList
        }

    fun updateFuncion(funcion: Funcion): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NOMBRE, funcion.nombre)
        values.put(EXPRESION, funcion.expresion)

        val _success = db.update(TABLE_NAME, values, ID + "=?", arrayOf(funcion.id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteFuncion(_id: Int): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(TABLE_NAME, ID + "=?", arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    companion object {

        private val DB_VERSION = 1
        private val DB_NAME = "MisFunciones"
        private val TABLE_NAME = "Funciones"
        private val ID = "Id"
        private val NOMBRE = "Nombre"
        private val EXPRESION = "Expresion"
    }
}
