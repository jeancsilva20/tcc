package com.example.lucca.novopopup;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPopUp = (Button) findViewById(R.id.button);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                AlertDialog.Builder newAlert = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.novo_popup, null);
                ImageView mImagem = (ImageView) findViewById(R.id.imageView);

                newAlert.setView(mView);

                AlertDialog dialog = newAlert.create();
                dialog.show();
            }
        });


    }
}
