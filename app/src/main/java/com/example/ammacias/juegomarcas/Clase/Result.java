package com.example.ammacias.juegomarcas.Clase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ammacias on 13/02/2017.
 */

public class Result {

    @SerializedName("marca")
    @Expose
    private List<Marca> marca = null;

    public List<Marca> getMarca() {
        return marca;
    }

    public void setMarca(List<Marca> marca) {
        this.marca = marca;
    }


}
