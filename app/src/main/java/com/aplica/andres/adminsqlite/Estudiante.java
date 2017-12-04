package com.aplica.andres.adminsqlite;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Estudiante extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setFragment(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.estudiante, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Mensaje();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new FragHome()).commit();
        } else if (id == R.id.nav_perfil) {
            startActivity(new Intent(Estudiante.this, Frag_Perfil.class));
        } else if (id == R.id.nav_hist) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new Frag_Historial()).commit();
        } else if (id == R.id.nav_horario) {
            Intent broswerIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/uc?export=download&id=1yurvsuXxo0bp5OjzeCOJ-vC0n012nJ3N"));
            startActivity(broswerIntent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.out_sesion) {
            Mensaje();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setFragment(int pos){
        android.support.v4.app.FragmentTransaction fragmentTransaction;
        switch (pos){
            case 0:
                fragmentTransaction= fragmentManager.beginTransaction();
                FragHome inboxFragHome= new FragHome();
                fragmentTransaction.replace(R.id.contenedor,inboxFragHome);
                fragmentTransaction.commit();
        }
    }
    public void Mensaje(){
        AlertDialog a1;
        a1= new AlertDialog.Builder(this).create();
        a1.setTitle("Cerrar Sesión");
        a1.setMessage("¿Esta Seguro que Desea Salir?");
        a1.setButton("ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent nuevoform = new Intent(Estudiante.this,Login.class);
                startActivity(nuevoform);
            }
        });
        a1.setButton2("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        a1.show();
    }
}
