package com.example.u16394.snacktime.activities;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.u16394.snacktime.R;
import java.util.ArrayList;
import java.util.List;


public class NovidadesContentActivity extends AppCompatActivity  {
    private ListView lista;
    private ArrayList<UserModel> objLista = new ArrayList<>();
    private RecyclerView horizontal_recycler_view;
    private ArrayList<String> horizontalList;
    private HorizontalAdapter horizontalAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_content_novidades);
        lista = (ListView) findViewById(R.id.teste);


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


        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        horizontalList=new ArrayList<>();
        horizontalList.add("horizontal 1");
        horizontalList.add("horizontal 2");
        horizontalList.add("horizontal 3");
        horizontalList.add("horizontal 4");
        horizontalList.add("horizontal 5");
        horizontalList.add("horizontal 6");
        horizontalList.add("horizontal 7");
        horizontalList.add("horizontal 8");
        horizontalList.add("horizontal 9");
        horizontalList.add("horizontal 10");
        horizontalAdapter=new HorizontalAdapter(horizontalList);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(NovidadesContentActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

        ArrayAdapter<UserModel> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, objLista);
        lista.setAdapter(adapter);

        }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<String> horizontalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;

            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);

            }
        }

        public HorizontalAdapter(List<String> horizontalList) {
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
            holder.txtView.setText(horizontalList.get(position));

            holder.txtView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(NovidadesContentActivity.this,holder.txtView.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }




    }

