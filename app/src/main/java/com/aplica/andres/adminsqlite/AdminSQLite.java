package com.aplica.andres.adminsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class AdminSQLite extends SQLiteOpenHelper {
    public AdminSQLite(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }
    @Override
    public void onConfigure(SQLiteDatabase db){
        db.setForeignKeyConstraintsEnabled(true);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //aquí creamos la tabla de usuario (dni, nombre, ciudad, numero)
        //db.execSQL("create table equipo(id varchar(20) primary key, estado text, sede text, sala integer)");

        db.execSQL("CREATE TABLE login ( codigo_es TEXT NOT NULL , contraseña TEXT NOT NULL , PRIMARY KEY(codigo_es))");
        db.execSQL("CREATE TABLE estudiante ( codigo TEXT , nombre TEXT NOT NULL , telefono TEXT NOT NULL , FOREIGN KEY (codigo) REFERENCES login(codigo_es) ON DELETE CASCADE , PRIMARY KEY(codigo))");
        db.execSQL("CREATE TABLE prestamo ( cod_prestamo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , f_ingreso TEXT NOT NULL , f_salida TEXT NOT NULL , FOREIGN KEY(cod_prestamo) REFERENCES estudiante(codigo) ON DELETE CASCADE, FOREIGN KEY(cod_prestamo) REFERENCES equipos(serial) ON DELETE CASCADE)");
        db.execSQL("CREATE TABLE equipos ( serial TEXT NOT NULL , marca TEXT NOT NULL , estado TEXT NOT NULL , internet TEXT NOT NULL , PRIMARY KEY(serial))");
        db.execSQL("CREATE TABLE sala ( aula INTEGER NOT NULL , equipamiento TEXT NOT NULL , PRIMARY KEY(aula))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists login");
        db.execSQL("drop table if exists estudiante");
        db.execSQL("drop table if exists prestamo");
        db.execSQL("drop table if exists equipos");
        db.execSQL("drop table if exists sala");
        //db.execSQL("create table equipo(id integer primary key, estado text, sede text, sala integer)");

        db.execSQL("CREATE TABLE login ( codigo_es TEXT NOT NULL , contraseña TEXT NOT NULL , PRIMARY KEY(codigo_es))");
        db.execSQL("CREATE TABLE estudiante ( codigo TEXT , nombre TEXT NOT NULL , telefono TEXT NOT NULL , FOREIGN KEY (codigo) REFERENCES login(codigo_es) ON DELETE CASCADE , PRIMARY KEY(codigo))");
        db.execSQL("CREATE TABLE prestamo ( cod_prestamo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , f_ingreso TEXT NOT NULL , f_salida TEXT NOT NULL , FOREIGN KEY(cod_prestamo) REFERENCES estudiante(codigo) ON DELETE CASCADE)");
        db.execSQL("CREATE TABLE equipos ( serial TEXT NOT NULL , marca TEXT NOT NULL , estado TEXT NOT NULL , internet TEXT NOT NULL , PRIMARY KEY(serial))");
        db.execSQL("CREATE TABLE sala ( aula INTEGER NOT NULL , equipamiento TEXT NOT NULL , PRIMARY KEY(aula))");

    }
    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "SELECT * FROM estudiante";
        Cursor registros = db.rawQuery(q,null);
        if(registros.moveToFirst()){
            do{
                String nombre= registros.getString(0) + " " + registros.getString(1);
                lista.add(nombre);
                //lista.add(registros.getString(1));
            }while(registros.moveToNext());
        }
        return lista;

    }

}