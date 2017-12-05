package com.aplica.andres.adminsqlite;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText et1, et2, et3, et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.codigo);
        et2 = (EditText) findViewById(R.id.nombre);
        et3 = (EditText) findViewById(R.id.contraseña);
        et4 = (EditText) findViewById(R.id.telefono);

    }
    public void carga(View v) {


        AdminSQLite admin = new AdminSQLite(this, "prueba20", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo_es = et1.getText().toString();
        String contraseña = et3.getText().toString();
        String nombre = et2.getText().toString();
        String telefono = et4.getText().toString();
        ContentValues registro = new ContentValues();
        ContentValues estudio = new ContentValues();
        registro.put("codigo_es", codigo_es);
        registro.put("contraseña", contraseña);
        estudio.put("nombre", nombre);
        estudio.put("telefono", telefono);
        estudio.put("codigo",codigo_es);


        //Inserta los datos en la tabla usuario
        bd.insert("login", null, registro);
        bd.insert("estudiante", null, estudio);
        bd.close();
        //Ponemos los campos a vacÃ­o para insertar el siguiente usuario
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this, "Datos del equipo cargados", Toast.LENGTH_SHORT).show();
    }
    public void consultar(View v) {
        AdminSQLite admin = new AdminSQLite(this,"prueba20", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo_es = et1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select contraseña from login where codigo_es=" + codigo_es, null);
        Cursor fila2=bd.rawQuery(
                "select nombre,telefono from estudiante where codigo="+"'"+codigo_es+"'",null);
         if (fila2.moveToFirst()){
             et2.setText(fila2.getString(0));
             et4.setText(fila2.getString(1));
         }

        if (fila.moveToFirst()) {
            et3.setText(fila.getString(0));

        } else
            Toast.makeText(this, "No existe ningún equipo con ese dni",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    /* Método para eliminar usuarios*/
    public void eliminado(View v) {
        AdminSQLite admin = new AdminSQLite(this,"prueba20", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo_es = et1.getText().toString();
        //String contraseña = et3.getText().toString();
        //Elimina el usuario de la base de datos
        //int cant =
       // bd.execSQL(
         //       "delete from login where codigo_es=" +"'"+codigo_es+"'",null);

                bd.delete("login", "codigo_es=" +"'"+codigo_es+"'", null);
        bd.close();
        et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
        /*if (cant == 1)
            Toast.makeText(this, "equipo eliminado",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe equipo",Toast.LENGTH_SHORT).show();*/
    }
    public void actualizar(View v) {
        AdminSQLite admin = new AdminSQLite(this,"prueba20", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo_es = et1.getText().toString();
        String nombre = et2.getText().toString();
        String contraseña = et3.getText().toString();
        String telefono = et4.getText().toString();
        //Instancia que representa los datos  guardar
        ContentValues registro = new ContentValues(); //
        ContentValues estudio = new ContentValues();
        // actualizamos con los nuevos datos, la información cambiada

        registro.put("contraseña", contraseña);
        estudio.put("nombre", nombre);
        estudio.put("telefono", telefono);
        estudio.put("codigo",codigo_es);

        int cant = bd.update("login", registro, "codigo_es=" +"'"+codigo_es+"'", null);
        bd.update("estudiante", estudio, "codigo=" +"'"+codigo_es+"'", null);

        bd.close();
        if (cant == 1)
            Toast.makeText(this, "Datos modificados con éxito", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe equipo",Toast.LENGTH_SHORT).show();
    }

    public void reportadito(View view){
        Intent nuevoform3 = new Intent(MainActivity.this,Lista.class);
        startActivity(nuevoform3);
    }



}