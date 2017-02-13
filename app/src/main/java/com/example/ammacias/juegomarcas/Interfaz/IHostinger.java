package com.example.ammacias.juegomarcas.Interfaz;

import com.example.ammacias.juegomarcas.Clase.Result;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by macias on 13/02/2017.
 */

public interface IHostinger {
    String ENDPOINT = "http://juegomarcas.esy.es";

    @GET("/datos.json")
    Call<Result> getDatos();
}
