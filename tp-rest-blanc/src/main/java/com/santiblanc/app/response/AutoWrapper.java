package com.santiblanc.app.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.santiblanc.app.entities.Marca;

/**
 * Created by Blade-Razer on 6/1/2017.
 */
public class AutoWrapper {
    //Propiedades
    @JsonProperty
    Marca marca;
    @JsonProperty
    String modelo;
    @JsonProperty
    float km;
    @JsonProperty
    String patente;
    @JsonProperty
    String anio;

    //Getters y Setters
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
