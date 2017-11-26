package com.aplica.andres.adminsqlite;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by andres on 12/11/2017.
 */

public class Login extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button boton = (Button) findViewById(R.id.login);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = ((EditText) findViewById(R.id.txtusuario)).getText().toString();
                String contraseña = ((EditText) findViewById(R.id.txtcontraseña)).getText().toString();
                if(usuario.equals("admin")&&contraseña.equals("admin"))
                {
                    Intent nuevoform = new Intent(Login.this,Administrador.class);
                    startActivity(nuevoform);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario Invalido",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
