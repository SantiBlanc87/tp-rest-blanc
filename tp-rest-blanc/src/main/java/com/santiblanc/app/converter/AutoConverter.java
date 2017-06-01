package com.santiblanc.app.converter;

import com.santiblanc.app.entities.Auto;
import com.santiblanc.app.response.AutoWrapper;

/**
 * Created by Blade-Razer on 6/1/2017.
 */
public class AutoConverter {
    //Constructor
    public AutoConverter(){}

    //Metodos
    public AutoWrapper convert (Auto auto){
        AutoWrapper a = new AutoWrapper();
        a.setMarca(auto.getMarca());
        a.setModelo(auto.getModelo());
        a.setKm(auto.getKilometros());
        a.setPatente(auto.getPatente());
        a.setAnio(auto.getAnio());
        return a;
    }
}
