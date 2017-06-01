package com.santiblanc.app.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Blade-Razer on 6/1/2017.
 */
public class MarcaWrapper {
    //Propiedades
    @JsonProperty
    String descripcion;
    @JsonProperty
    String pais;

    //Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
