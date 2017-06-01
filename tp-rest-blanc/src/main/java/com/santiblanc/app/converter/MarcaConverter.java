package com.santiblanc.app.converter;

import com.santiblanc.app.entities.Marca;
import com.santiblanc.app.response.MarcaWrapper;

/**
 * Created by Blade-Razer on 6/1/2017.
 */
public class MarcaConverter {
    //Constructor
    public MarcaConverter(){}

    //Metodos
    public MarcaWrapper convert(Marca marca){
        MarcaWrapper m = new MarcaWrapper();
        m.setDescripcion(marca.getDescripcion());
        m.setPais(marca.getPais());
        return m;
    }
}
