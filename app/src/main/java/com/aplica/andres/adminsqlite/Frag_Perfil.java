package com.aplica.andres.adminsqlite;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/**
 * A simple {@link} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.

 * create an instance of this fragment.
 */
public class Frag_Perfil extends Activity{
    TextView nomb_est,prog,cod_est;
    EditText email,telf;
    private Editable m;
    private Editable t;
    String nomb,mail, pro,cod, telfo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_frag__perfil);
        nomb_est= (TextView)findViewById(R.id.perf_nombest);
        prog=(TextView) findViewById(R.id.perf_prog);
        cod_est=(TextView) findViewById(R.id.perf_codest);
        email=(EditText) findViewById(R.id.perf_mail);
        telf=(EditText) findViewById(R.id.perf_telf);
        this.llenarCampos("BYRON","byron.moron@unillanos.edu.co","ING SISTEMAS","160003646","3125631248");

    }

    public void llenarCampos(String nomb,String mail, String pro,String cod,String telf){
        this.nomb=nomb;
        this.mail=mail;
        this.pro=pro;
        this.cod=cod;
        this.telfo=telf;

        nomb_est.setText(this.nomb);
        email.setText(this.mail);
        prog.setText(this.pro);
        cod_est.setText(this.cod);
        this.telf.setText(this.telfo);
    }

    public void act(View view) {
         email.setEnabled(false);
         telf.setEnabled(false);
        Toast.makeText(this, "Datos Actualizados", Toast.LENGTH_SHORT).show();
    }
}
