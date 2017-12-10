package com.aplica.andres.adminsqlite;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Seleccion extends Activity {
    TextView descrip;
    ListView ser_equ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        descrip=(TextView)findViewById(R.id.selec_descrip);
        ser_equ=(ListView)findViewById(R.id.selesc_lis);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
    }
    public void procesarEvento(int opc){

        switch (opc){
            case R.id.registro:  Intent nuevoform = new Intent(Seleccion.this,MainActivity.class);
                startActivity(nuevoform);
                break;

            case R.id.equipos:  Intent nuevoform2 = new Intent(Seleccion.this,Equipos.class);
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
    public void home_A(View view) {

    }
}
