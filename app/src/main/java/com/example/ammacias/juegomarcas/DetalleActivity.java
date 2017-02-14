package com.example.ammacias.juegomarcas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.example.ammacias.juegomarcas.localdb.DatabaseConnection;
import com.example.ammacias.juegomarcas.localdb.MarcaDB;
import com.example.ammacias.juegomarcas.localdb.MarcaDBDao;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class DetalleActivity extends AppCompatActivity {

    int contador = 0;
    ImageView i;
    EditText editText;
    MarcaDBDao marcaDBDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        i = (ImageView)findViewById(R.id.imageView);
        editText = (EditText)findViewById(R.id.nombre);
        marcaDBDao = DatabaseConnection.getMarcaDBDao(this);

        Picasso.with(this)
                .load(("http://juegomarcas.esy.es/images/"+marcaDBDao
                        .load(getIntent().getLongExtra("marcaID",0))
                        .getFoto()))
                .resize(250, 200)
                .into(i);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText.getText().toString().equalsIgnoreCase(marcaDBDao.load(getIntent().getLongExtra("marcaID",0)).getNombre())){
                    Toast.makeText(DetalleActivity.this, "CORRECTO", Toast.LENGTH_SHORT).show();
                    //TODO: Machaco el booleano
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pista "+contador+": .....", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                contador++;
            }
        });




    }

}
