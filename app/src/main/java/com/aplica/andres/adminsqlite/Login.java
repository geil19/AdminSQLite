package com.aplica.andres.adminsqlite;

        import android.app.Activity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Switch;
        import android.widget.Toast;

public class Login extends AppCompatActivity {

    //reamos la variables locales
    EditText et1, et2;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //emperejamos las variable con el xml
        Button boton = (Button) findViewById(R.id.login);
        //boton.setOnClickListener(this);
        Button btnregistro=(Button)findViewById(R.id.registro);
        //btnregistro.setOnClickListener(this);
        et1 = (EditText) findViewById(R.id.txtusuario);
        et2 = (EditText) findViewById(R.id.txtcontrasena);
    }
public void registradito(View v){
    Intent nuevoform = new Intent(Login.this, Registro.class);
    startActivity(nuevoform);
}
    /*@Override
    public void onClick(View view) {
        ingresar(view.getId());
    }*/

    /*public void eventoLogin(int op) {
        switch (op) {
            case R.id.login:
                ingresar();

                break;
            case R.id.registro:
                Intent nuevoform = new Intent(Login.this, Registro.class);
                startActivity(nuevoform);
        }
    }*/
    //metodo de ingreso
    public void ingresar(View v) {

                AdminSQLite admin = new AdminSQLite(this, "prueba20", null, 1);
                SQLiteDatabase db = admin.getWritableDatabase();
                String codigo_es = et1.getText().toString();
                String contraseña = et2.getText().toString();

                fila = db.rawQuery("select codigo_es,contraseña from login where codigo_es='" + codigo_es + "' and contraseña='" + contraseña + "'", null);
                //preguntamos si el cursor tiene algun valor almacenado

        if(codigo_es.equals("admin") && contraseña.equals("admin")) {
            Intent nuevoform = new Intent(Login.this, Administrador.class);
            startActivity(nuevoform);

        }else if (fila.moveToFirst() == true) {
                    //capturamos los valores del cursos y lo almacenamos en variable
                    String usua = fila.getString(0);
                    String pass = fila.getString(1);
                    //preguntamos si los datos ingresados son iguales



                    if (codigo_es.equals(usua) && contraseña.equals(pass)) {
                        //si son iguales entonces vamos a otra ventana
                        //Menu es una nueva actividad empty
                        Intent nuevoform = new Intent(Login.this, Estudiante.class);
                        startActivity(nuevoform);

                        //limpiamos las las cajas de texto


                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Usuario Invalido", Toast.LENGTH_SHORT).show();
                    }

                }

        }

    }
   /* */


    /*private  void eventoLogin(int op){
        AdminSQLite admin = new AdminSQLite(this, "prueba17", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        switch(op){
            case R.id.login:

                String usuario = ((EditText) findViewById(R.id.txtusuario)).getText().toString();
                String contrasena = ((EditText) findViewById(R.id.txtcontrasena)).getText().toString();

                if(usuario.equals("admin")&&contrasena.equals("admin"))
            {
                Intent nuevoform = new Intent(Login.this,Administrador.class);
                startActivity(nuevoform);
            }
                else if (usuario.equals("estudiante")&&contrasena.equals("estudiante"))
            {
                Intent nuevoform = new Intent(Login.this,Estudiante.class);
                startActivity(nuevoform);
            }
                else
            {
                Toast.makeText(getApplicationContext(),"Usuario Invalido",Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.registro: Intent nuevoform = new Intent(Login.this,Registro.class);
                startActivity(nuevoform);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button boton = (Button) findViewById(R.id.login);
        boton.setOnClickListener(this);
        Button btnregistro=(Button)findViewById(R.id.registro);
        btnregistro.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        eventoLogin(view.getId());
    }*/



