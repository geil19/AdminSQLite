package com.aplica.andres.adminsqlite;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
public class MainActivity extends Activity {
    private EditText et1, et2, et3, et4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);

    }
    public void alta(View v) {

        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Codigo= et1.getText().toString();
        String Nombre = et2.getText().toString();
        String Telefono = et3.getText().toString();
        String Direccion = et4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("Codigo", Codigo);
        registro.put("Nombre", Nombre);
        registro.put("Telefono", Telefono);
        registro.put("Direccion", Direccion);

        //Inserta los datos en la tabla usuario
        bd.insert("Estudiante", null, registro);
        bd.close();
        //Ponemos los campos a vacío para insertar el siguiente usuario
        et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
        Toast.makeText(this, "Datos del equipo cargados", Toast.LENGTH_SHORT).show();
    }
    public void consulta(View v) {
        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Codigo = et1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select Nombre, Telefono, Direccion from Estudiante where Codigo=" +Codigo, null);

        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
        } else
            Toast.makeText(this, "No existe ningún equipo con ese dni",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    /* Método para eliminar usuarios*/
    public void baja(View v) {
        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Codigo = et1.getText().toString();
        //Elimina el usuario de la base de datos
        int cant = bd.delete("Estudiante", "Codigo=" + Codigo, null);
        bd.close();
        et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
        if (cant == 1)
            Toast.makeText(this, "equipo eliminado",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe equipo",Toast.LENGTH_SHORT).show();
    }
    public void modificacion(View v) {
        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Codigo = et1.getText().toString();
        String Nombre = et2.getText().toString();
        String Telefono = et3.getText().toString();
        String Direccion = et4.getText().toString();
        //Instancia que representa los datos  guardar
        ContentValues registro = new ContentValues(); //
        // actualizamos con los nuevos datos, la información cambiada
        registro.put("Nombre", Nombre);
        registro.put("Telefono", Telefono);
        registro.put("Direccion", Direccion);
        int cant = bd.update("Estudiante", registro, "Codigo=" + Codigo, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "Datos modificados con éxito", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe equipo",Toast.LENGTH_SHORT).show();
    }
 /* fin del programa */
}