package com.aplica.andres.adminsqlite;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Switch;
        import android.widget.Toast;

public class Login extends Activity implements View.OnClickListener{

    private  void eventoLogin(int op){
        switch(op){
            case R.id.login:
                String usuario = ((EditText) findViewById(R.id.txtusuario)).getText().toString();
                String contrasena = ((EditText) findViewById(R.id.txtcontrasena)).getText().toString();
                if(usuario.equals("admin")&&contrasena.equals("admin"))
            {
                Intent nuevoform = new Intent(Login.this,Administrador.class);
                startActivity(nuevoform);
                Toast.makeText(this,"Inició en Modo Administrador", Toast.LENGTH_SHORT).show();
            }
                else if (usuario.equals("estudiante")&&contrasena.equals("estudiante"))
            {
                Intent nuevoform = new Intent(Login.this,Estudiante.class);
                startActivity(nuevoform);
                Toast.makeText(this,"Inició Sesión Como Estudiante", Toast.LENGTH_SHORT).show();
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
    }
}
