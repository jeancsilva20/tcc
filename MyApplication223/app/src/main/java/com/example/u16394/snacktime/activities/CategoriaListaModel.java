package com.example.u16394.snacktime.activities;


import android.net.Uri;

public class CategoriaListaModel {

    private final String mId;
    private final String mName;
    private final String mDescription;
    private final String mTelefone;
    private final Uri mImagem;


    public CategoriaListaModel(String name, String description, String imagem, String Id, String Telefone) {
        mName = name;
        mDescription = description;
        mId = Id;
        mTelefone = Telefone;
        Uri uri = Uri.parse(imagem);
        mImagem = uri;
    }

    public String getId() {
        return mId;
    }

    public String getTelefone() {
        return mTelefone;
    }

    public String getName() {
        return mName;
    }

    public Uri getImagem() {
        return mImagem;
    }

    public String getDescription() {
        return mDescription;
    }


    @Override
    public String toString() {
        return this.getName()+"\n"
                +this.getDescription();
    }
}
