package com.example.u16394.snacktime.activities;


import android.net.Uri;

import static com.example.u16394.snacktime.activities.MainActivity.*;

public class CategoriaModel {

    private final String mName;
    private final String mDescription;
    private final Uri mimagem;


    public CategoriaModel(String name, String description, String imagem) {
        mName = name;
        mDescription = description;
        Uri uri = Uri.parse(imagem);
        mimagem = uri;
    }

    public String getName() {
        return mName;
    }

    public Uri getImagem() {
        return mimagem;
    }

    public String getDescription() {
        return mDescription;
    }


    @Override
    public String toString() {
        return this.mDescription+this.mName;
    }
}
