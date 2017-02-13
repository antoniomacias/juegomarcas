package com.example.ammacias.juegomarcas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.example.ammacias.juegomarcas.Interfaz.IMarca;

public class MainActivity extends AppCompatActivity implements IMarca{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClickMarca(Marca m) {
        Toast.makeText(this, ""+m.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
