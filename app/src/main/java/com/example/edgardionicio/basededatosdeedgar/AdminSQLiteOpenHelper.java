package com.example.edgardionicio.basededatosdeedgar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Owner on 21/04/2015.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
        // Creamos el constructor
        public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
    // Se crea la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table estudiantes (id_numero _de_control integer primary key unique, carrera text, semestre integer, nombre text, apellido_p text, apellido_m text) ");

    }
    // borrar la tabla y crear la nueva tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists estudiantes");
        db.execSQL("create table estudiantes (id_numero _de_control integer primary key unique, carrera text, semestre integer, nombre text, apellido_p text, apellido_m text, actividad text) ");

    }
}
