package com.aplica.andres.adminsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="centroTic.sqlite";
    private static final int DB_SCHEME_VERSION=1;

    public DbHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //aquÃ­ creamos la tabla de usuario (dni, nombre, ciudad, numero)
        //db.execSQL("create table equipo(id varchar(20) primary key, estado text, sede text, sala integer)");
        db.execSQL("CREATE TABLE estudiante ( codigo TEXT , nombre TEXT NOT NULL , telefono TEXT NOT NULL )");
        db.execSQL("CREATE TABLE login ( codigo_es TEXT NOT NULL , contrasenna TEXT NOT NULL,FOREIGN KEY (codigo) REFERENCES estudiante(codigo) , PRIMARY KEY (codigo) ) ");
        db.execSQL("CREATE TABLE prestamo ( cod_prestamo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , f_ingreso TEXT NOT NULL , f_salida TEXT NOT NULL )");
        db.execSQL("CREATE TABLE equipos ( serial NUMERIC NOT NULL , marca TEXT NOT NULL , estado TEXT NOT NULL , internet TEXT NOT NULL , PRIMARY KEY(serial))");
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
        db.execSQL("CREATE TABLE login ( codigo_es TEXT NOT NULL , contrasena TEXT NOT NULL , PRIMARY KEY(codigo_es))");
        db.execSQL("CREATE TABLE estudiante ( codigo TEXT , nombre TEXT NOT NULL , telefono TEXT NOT NULL , FOREIGN KEY (codigo) REFERENCES login(codigo_es), PRIMARY KEY(codigo))");
        db.execSQL("CREATE TABLE prestamo ( cod_prestamo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , f_ingreso TEXT NOT NULL , f_salida TEXT NOT NULL )");
        db.execSQL("CREATE TABLE equipos ( serial NUMERIC NOT NULL , marca TEXT NOT NULL , estado TEXT NOT NULL , internet TEXT NOT NULL , PRIMARY KEY(serial))");
        db.execSQL("CREATE TABLE sala ( aula INTEGER NOT NULL , equipamiento TEXT NOT NULL , PRIMARY KEY(aula))");

    }
    public void Abrir(){
        this.getWritableDatabase();
    }
    public void cerrar(){
        this.close();
    }
}