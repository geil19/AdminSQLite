package com.aplica.andres.adminsqlite;

/**
 * Created by andres on 26/11/2017.
 */
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Equipos extends Activity {
private EditText et5,et6,et7,et8;
//private RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipos);
        et5=(EditText) findViewById(R.id.serial);
        et6=(EditText) findViewById(R.id.marca);
        et7=(EditText) findViewById(R.id.estado);
        et8=(EditText) findViewById(R.id.internet);

    }
    public void alta(View v) {

        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Serial= et5.getText().toString();
        String Marca = et6.getText().toString();
        String Estado = et7.getText().toString();
        String Internet = et8.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("Serial", Serial);
        registro.put("Marca", Marca);
        registro.put("Estado", Estado);
        registro.put("Internet", Internet);

        //Inserta los datos en la tabla usuario
        bd.insert("Equipos", null, registro);
        bd.close();
        //Ponemos los campos a vacío para insertar el siguiente usuario
        et5.setText(""); et6.setText(""); et7.setText(""); et8.setText("");
        Toast.makeText(this, "Datos del equipo cargados", Toast.LENGTH_SHORT).show();
    }
    public void consulta(View v) {
        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Serial = et5.getText().toString();
        Cursor fila = bd.rawQuery(
                "select Marca, Estado, Internet from Equipos where Serial=" +Serial, null);

        if (fila.moveToFirst()) {
            et6.setText(fila.getString(0));
            et7.setText(fila.getString(1));
            et8.setText(fila.getString(2));
        } else
            Toast.makeText(this, "No existe ningún equipo con ese dni",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    /* Método para eliminar usuarios*/
    public void baja(View v) {
        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Serial = et5.getText().toString();
        //Elimina el usuario de la base de datos
        int cant = bd.delete("Equipo", "Serial=" + Serial, null);
        bd.close();
        et5.setText(""); et6.setText(""); et7.setText(""); et8.setText("");
        if (cant == 1)
            Toast.makeText(this, "equipo eliminado",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe equipo",Toast.LENGTH_SHORT).show();
    }
    public void modificacion(View v) {
        AdminSQLite admin = new AdminSQLite(this,"admins", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String Serial = et5.getText().toString();
        String Marca = et6.getText().toString();
        String Estado = et7.getText().toString();
        String Internet = et8.getText().toString();
        //Instancia que representa los datos  guardar
        ContentValues registro = new ContentValues(); //
        // actualizamos con los nuevos datos, la información cambiada
        registro.put("Marca", Marca);
        registro.put("Estado", Estado);
        registro.put("Internet", Internet);
        int cant = bd.update("Equipo", registro, "Serial=" + Serial, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "Datos modificados con éxito", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe equipo",Toast.LENGTH_SHORT).show();
    }
}

