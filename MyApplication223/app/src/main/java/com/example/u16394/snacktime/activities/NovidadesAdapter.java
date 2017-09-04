package com.example.u16394.snacktime.activities;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jeanc on 27/08/2017.
 */

public class NovidadesAdapter extends RecyclerView.Adapter {

    private List<UserModel> lista;

    public NovidadesAdapter(List<UserModel> livros) {
        this.lista = livros;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
}