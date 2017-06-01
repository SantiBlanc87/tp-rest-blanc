package com.santiblanc.app.services;

import com.santiblanc.app.entities.Auto;
import com.santiblanc.app.entities.Marca;
import com.santiblanc.app.persistence.AutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Blade-Razer on 6/1/2017.
 */
@Service
public class AutoService {
    //Atributos
    AutoDAO autoDao;

    //Constructor
    @Autowired
    public AutoService(AutoDAO a){
        this.autoDao = a;
    }

    //Metodos
    public void newAuto(Marca marca, String modelo, float km, String patente, String anio) throws ParseException{
        Auto a = new Auto();
        a.setMarca(marca);
        a.setModelo(modelo);
        a.setKilometros(km);
        a.setPatente(patente);
        a.setAnio(anio);
        this.autoDao.guardarAuto(a);
    }

    public List<Auto> getTodos(){
        return autoDao.getTodos();
    }

    public Auto getPorId(int id){
        return autoDao.getPorId(id);
    }

    public Auto getPorPatente(String patente){
        return autoDao.getPorPatente(patente);
    }

    public List<Auto> getPorMarca(Marca m){
        return autoDao.getByMarca(m);
    }
}
