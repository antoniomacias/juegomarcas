package com.example.ammacias.juegomarcas.localdb;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "MARCA_DB".
 */
@Entity
public class MarcaDB {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String nombre;
    private int nivel;

    @NotNull
    private String foto;
    private boolean acertado;

    @Generated
    public MarcaDB() {
    }

    public MarcaDB(Long id) {
        this.id = id;
    }

    @Generated
    public MarcaDB(Long id, String nombre, int nivel, String foto, boolean acertado) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.foto = foto;
        this.acertado = acertado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getNombre() {
        return nombre;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @NotNull
    public String getFoto() {
        return foto;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setFoto(@NotNull String foto) {
        this.foto = foto;
    }

    public boolean getAcertado() {
        return acertado;
    }

    public void setAcertado(boolean acertado) {
        this.acertado = acertado;
    }

}
