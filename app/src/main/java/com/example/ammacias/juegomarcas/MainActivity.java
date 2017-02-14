package com.example.ammacias.juegomarcas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.widget.Toast;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.example.ammacias.juegomarcas.Clase.Result;
import com.example.ammacias.juegomarcas.Interfaz.IHostinger;
import com.example.ammacias.juegomarcas.Interfaz.IMarca;

import org.parceler.Parcels;

import java.sql.SQLOutput;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements IMarca{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void onClickMarca(Marca m) {
        Intent intent = new Intent(this, DetalleActivity.class);

        intent.putExtra("marcaID", m.getId());
        startActivity(intent);
    }
}
