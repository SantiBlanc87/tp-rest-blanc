package com.santiblanc.app.entities;

/**
 * Created by Blade-Razer on 5/31/2017.
 */
public class Marca {
    //Atributos
    private int id;
    private String descripcion;
    private String pais;

    //Constructores
    public Marca(){}

    public Marca(String desc, String pais){
        this.setDescripcion(desc);
        this.setPais(pais);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if ((obj==null)|| (this.getClass()!=obj.getClass())){
            return false;
        }
        Marca comp = (Marca) obj;
        if (this.descripcion.equalsIgnoreCase(comp.getDescripcion())){
            return true;
        } else {
            return false;
        }
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
