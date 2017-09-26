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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.u16394.snacktime.R;
import java.util.ArrayList;
import java.util.List;


public class NovidadesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView horizontal_recycler_view;
    private RecyclerView vertical_recycler_view;
    private ArrayList<CategoriaModel> horizontalList;
    private ArrayList<CategoriaListaModel> verticalList;
    private NovidadesActivity.HorizontalAdapter horizontalAdapter;
    private NovidadesActivity.VerticalAdapter verticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novidades);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        criarGrid();
    }

    public void criarGrid(){
        String uriImgPath = "android.resource://"+  getPackageName() + "/drawable/";

        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        vertical_recycler_view =(RecyclerView) findViewById(R.id.vertical_recycler_view);

        verticalList=new ArrayList<>();
        horizontalList=new ArrayList<>();

        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalList.add(new CategoriaListaModel("name","description","imagem","Id","Telefone"));
        verticalAdapter= new NovidadesActivity.VerticalAdapter(verticalList);

        horizontalList.add(new CategoriaModel("Pizzas","Teste", uriImgPath+"ic_pizza"));
        horizontalList.add(new CategoriaModel("Lanches","Teste", uriImgPath+"hamburguer"));
        horizontalList.add(new CategoriaModel("Mexicana","Teste", uriImgPath+"mexicana"));
        horizontalList.add(new CategoriaModel("Japones","Teste", uriImgPath+"japones"));
        horizontalList.add(new CategoriaModel("Vegetariano","Teste", uriImgPath+"vegetariano"));
        horizontalList.add(new CategoriaModel("Sorvetes","Teste", uriImgPath+"sorvete"));
        horizontalList.add(new CategoriaModel("Chopperia","Teste", uriImgPath+"chopp"));
        horizontalList.add(new CategoriaModel("Cafeteria","Teste", uriImgPath+"cafe"));
        horizontalList.add(new CategoriaModel("Churrascaria","Teste", uriImgPath+"churras"));

        horizontalAdapter= new NovidadesActivity.HorizontalAdapter(horizontalList);

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

        LinearLayoutManager verLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        vertical_recycler_view.setLayoutManager(verLinearLayoutManager);
        vertical_recycler_view.setAdapter(verticalAdapter);
    }

    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {

        private List<CategoriaListaModel> verticalList;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;
            public TextView txtView2;

            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.textView6);
                txtView2 = (TextView) view.findViewById(R.id.textView7);
            }
        }

        public VerticalAdapter(List<CategoriaListaModel> verticalList) {
            this.verticalList = verticalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item_view, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setText(verticalList.get(position).getName());
            holder.txtView.setTextSize(25);
            holder.txtView2.setText(verticalList.get(position).getDescription());
        }

        @Override
        public int getItemCount() {
            return verticalList.size();
        }
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<CategoriaModel> horizontalList;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;
            public ImageView imagem;

            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);
                imagem = (ImageView) view.findViewById(R.id.imageView4);
            }
        }

        public HorizontalAdapter(List<CategoriaModel> horizontalList) {
            this.horizontalList = horizontalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_item_view, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setText(horizontalList.get(position).getName());
            holder.imagem.setImageURI(horizontalList.get(position).getImagem());
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
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
            AlertDialog.Builder newAlert = new AlertDialog.Builder(NovidadesActivity.this);
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
            Intent it = new Intent(NovidadesActivity.this, MainActivity.class);
            startActivity(it);
        }else if (id == R.id.nav_categorias) {
            Intent it = new Intent(NovidadesActivity.this,NovidadesActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_promocoes) {
            Intent it = new Intent(NovidadesActivity.this,PromocoesActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_filtros) {
            Intent it = new Intent(NovidadesActivity.this,FiltrosActivity.class);
            startActivity(it);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
