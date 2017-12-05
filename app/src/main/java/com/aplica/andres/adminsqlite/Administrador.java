package com.aplica.andres.adminsqlite;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Administrador extends Activity implements View.OnClickListener  {



    public void procesarEvento(int opc){

        switch (opc){
            case R.id.registro:  Intent nuevoform = new Intent(Administrador.this,MainActivity.class);
                startActivity(nuevoform);
                break;

            case R.id.equipos:  Intent nuevoform2 = new Intent(Administrador.this,Equipos.class);
                startActivity(nuevoform2);
                break;

            case R.id.sala:  Intent nuevoform3 = new Intent(Administrador.this,Salas.class);
                startActivity(nuevoform3);
                break;
            case R.id.prest:  Intent nuevoform4 = new Intent(Administrador.this,Prestamo.class);
                startActivity(nuevoform4);
                break;

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        Button botones = (Button) findViewById(R.id.registro);
        botones.setOnClickListener(this);
        Button btn= (Button) findViewById(R.id.equipos);
        btn.setOnClickListener(this);
        Button btn2=(Button)findViewById(R.id.sala);
        btn2.setOnClickListener(this);
        Button btn3=(Button)findViewById(R.id.prest);
        btn3.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
procesarEvento(view.getId());
    }
}
