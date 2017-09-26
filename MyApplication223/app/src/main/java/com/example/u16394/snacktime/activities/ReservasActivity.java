package com.example.u16394.snacktime.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.u16394.snacktime.R;

import java.util.ArrayList;
import java.util.List;


public class ReservasActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button hora;
    private Button data;
    private Spinner local;
    private String[] array_spinner;
    private String[] array_spinner2;
    private Spinner restaurante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        data = (Button)findViewById(R.id.Data);
        data.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder newAlert = new AlertDialog.Builder(ReservasActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.data, null);
                newAlert.setView(mView);
                AlertDialog dialog = newAlert.create();
                dialog.show();
            }
        });
        hora = (Button)findViewById(R.id.hora);
        hora.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder newAlert = new AlertDialog.Builder(ReservasActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.hora, null);
                newAlert.setView(mView);
                AlertDialog dialog = newAlert.create();
                dialog.show();
            }
        });

        array_spinner=new String[4];
        array_spinner[0]="Parque Dom Pedro";
        array_spinner[1]="Galerias Shopping";
        array_spinner[2]="Iguatemi Campinas";
        array_spinner[3]="Outlet Premium";
        local = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, array_spinner);
        local.setAdapter(adapter);

        array_spinner2=new String[4];
        array_spinner2[0]="Outback";
        array_spinner2[1]="Applebee's";
        array_spinner2[2]="Big Jack";
        array_spinner2[3]="Joe Leo's";
        restaurante = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, array_spinner2);
        restaurante.setAdapter(adapter2);

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
        getMenuInflater().inflate(R.menu.main, menu);
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
            AlertDialog.Builder newAlert = new AlertDialog.Builder(ReservasActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.novo_popup, null);
            ImageView mImagem = (ImageView) findViewById(R.id.imageView);
            newAlert.setView(mView);
            AlertDialog dialog = newAlert.create();
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_main) {
            Intent it = new Intent(ReservasActivity.this, MainActivity.class);
            startActivity(it);
        }else if (id == R.id.nav_categorias) {
            Intent it = new Intent(ReservasActivity.this,NovidadesActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_promocoes) {
            Intent it = new Intent(ReservasActivity.this,PromocoesActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_filtros) {
            Intent it = new Intent(ReservasActivity.this,FiltrosActivity.class);
            startActivity(it);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
