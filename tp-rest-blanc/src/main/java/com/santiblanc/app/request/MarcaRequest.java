package com.santiblanc.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Blade-Razer on 6/1/2017.
 */
public class MarcaRequest {
    //Propiedades
    @JsonProperty("nombre")
    String descripcion;
    @JsonProperty("origen")
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
