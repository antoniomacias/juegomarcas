package com.example.ammacias.juegomarcas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class DetalleActivity extends AppCompatActivity {

    int contador = 0;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pista "+contador+": .....", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                contador++;
            }
        });

        Marca marca = (Marca) Parcels.unwrap(getIntent().getParcelableExtra("marca"));

        i = (ImageView)findViewById(R.id.imageView);

        Picasso.with(this)
                .load(("http://juegomarcas.esy.es/images/"+marca.getFoto()))
                .resize(250, 250)
                .centerCrop()
                .into(i);
    }

}
