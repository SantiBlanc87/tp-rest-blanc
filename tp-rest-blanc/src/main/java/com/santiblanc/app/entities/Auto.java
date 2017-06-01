package com.santiblanc.app.entities;

/**
 * Created by Blade-Razer on 5/31/2017.
 */
public class Auto {
    //Atributos
    private int id;
    private Marca marca;
    private String modelo;
    private float kilometros;
    private String patente;
    private String anio;

    //Constructores
    public Auto(){}

    public Auto(Marca marca, String modelo, float km, String patente, String anio ){
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setKilometros(km);
        this.setPatente(patente);
        this.setAnio(anio);
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public float getKilometros() {
        return kilometros;
    }

    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
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
