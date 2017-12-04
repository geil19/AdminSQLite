package com.aplica.andres.adminsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends Activity {

    private EditText et1,et2,et3,et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et1=(EditText) findViewById(R.id.codigo);
        et2=(EditText) findViewById(R.id.nombre);
        et3=(EditText) findViewById(R.id.contrasena);
        et4=(EditText) findViewById(R.id.celular);

    }

    public void alta(View v) {

        DbHelper admin = new DbHelper(this,"prueba12", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo_es= et1.getText().toString();
        String contrasenna= et3.getText().toString();
        String nombre= et2.getText().toString();
        String telefono= et4.getText().toString();
        ContentValues registro = new ContentValues();
        ContentValues estudio = new ContentValues();
        registro.put("codigo_es", codigo_es);
        registro.put("contrasenna", contrasenna);
        estudio.put("nombre", nombre);
        estudio.put("telefono", telefono);


        //Inserta los datos en la tabla usuario
        bd.insert("login", null, registro);
        bd.insert("estudiante", null, estudio);
        bd.close();
        //Ponemos los campos a vacÃ­o para insertar el siguiente usuario
        et1.setText(""); et3.setText("");
        Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
        Intent nuevoform = new Intent(Registro.this,Login.class);
        startActivity(nuevoform);
    }
}
