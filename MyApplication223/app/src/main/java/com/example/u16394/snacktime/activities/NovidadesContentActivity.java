package com.example.u16394.snacktime.activities;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.u16394.snacktime.R;
import java.util.ArrayList;


public class NovidadesContentActivity extends AppCompatActivity  {
    ListView lista;
    ListView lista2;
    ArrayList<UserModel> objLista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_content_novidades);
        lista = (ListView) findViewById(R.id.teste);
        lista2 = (ListView) findViewById(R.id.teste2);

        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));
        objLista.add(new UserModel("Juca","Teste","teste"));
        objLista.add(new UserModel("Joca","Teste","teste"));

        ArrayAdapter<UserModel> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, objLista);
        lista2.setHasTransientState(true);
        lista.setAdapter(adapter);
        lista2.setAdapter(adapter);

        }
    }

