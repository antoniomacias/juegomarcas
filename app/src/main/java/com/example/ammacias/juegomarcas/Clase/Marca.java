package com.example.ammacias.juegomarcas.Clase;

/**
 * Created by ammacias on 13/02/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Marca {

    public Marca() {
    }

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("nivel")
    @Expose
    private Integer nivel;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("acertado")
    @Expose
    private Boolean acertado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getAcertado() {
        return acertado;
    }

    public void setAcertado(Boolean acertado) {
        this.acertado = acertado;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", foto='" + foto + '\'' +
                ", acertado=" + acertado +
                '}';
    }

    public Marca(String foto) {
        this.foto = foto;
    }
}
