package com.example.u16394.snacktime.activities;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.u16394.snacktime.R;

import java.util.ArrayList;


public class NovidadesContentActivity extends AppCompatActivity  {

    ArrayList<UserModel> lista;
    RecyclerView listaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_content_novidades);;
        listaView = (RecyclerView)findViewById(R.id.list_novidades);
        listaView.setAdapter(new NovidadesAdapter(lista));
    }

    /*private void setupRecycler() {
        // Para criar um layout de uma lista.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        String uriPath = "android.resource://"+  getPackageName() + "/drawable/ic_pizza";
        listaA.add(new UserModel("teste","teste",uriPath));
        listaA.add(new UserModel("teste2","teste2",uriPath));
        listaA.add(new UserModel("teste3","teste3",uriPath));
        mAdapter = new CardAdapter(listaA);
        mRecyclerView.setAdapter(mAdapter);

    }*/

}
