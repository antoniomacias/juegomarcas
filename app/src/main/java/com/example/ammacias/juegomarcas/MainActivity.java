package com.example.ammacias.juegomarcas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.widget.Toast;

import com.example.ammacias.juegomarcas.Clase.Marca;
import com.example.ammacias.juegomarcas.Clase.Result;
import com.example.ammacias.juegomarcas.Interfaz.IHostinger;
import com.example.ammacias.juegomarcas.Interfaz.IMarca;

import java.sql.SQLOutput;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements IMarca{

    Result result;

    public void setResult(Result asd) {
        this.result = asd;
        for (Marca p: result.getMarca()) {
            System.out.println("Todo1: "+p.toString());
        }
    }
    Result getResult() {
        getDatos();
        /*for (Marca p: result.getMarca()) {
            System.out.println("1: "+p.toString());
        }*/
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClickMarca(Marca m) {
        Toast.makeText(this, ""+m.getNombre(), Toast.LENGTH_SHORT).show();
    }

    void getDatos(){
        //RETROFIT
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IHostinger.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IHostinger service = retrofit.create(IHostinger.class);

        //TODO: Traer del buscador
        Call<Result> autocompleteList = service.getDatos();

        autocompleteList.enqueue(new Callback<Result>() {

            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {

                if (response.isSuccess()) {
                    Result r = response.body();

                    for (Marca p: r.getMarca()) {
                        System.out.println("Todo: "+p.toString());
                    }

                    setResult(r);

                } else {
                    System.out.println("Error: " + response.code());
                    Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
                System.out.println("Salgo");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Throw: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Throw: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
