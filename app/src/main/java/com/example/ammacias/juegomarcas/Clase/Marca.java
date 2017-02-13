package com.example.ammacias.juegomarcas.Clase;

/**
 * Created by ammacias on 13/02/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Marca {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("nivel")
    @Expose
    private Integer nivel;
    @SerializedName("foto")
    @Expose
    private int foto;
    @SerializedName("acertado")
    @Expose
    private Boolean acertado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Boolean getAcertado() {
        return acertado;
    }

    public void setAcertado(Boolean acertado) {
        this.acertado = acertado;
    }

}
