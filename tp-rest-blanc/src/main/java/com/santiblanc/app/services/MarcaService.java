package com.santiblanc.app.services;

import com.santiblanc.app.entities.Marca;
import com.santiblanc.app.persistence.MarcaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Blade-Razer on 6/1/2017.
 */
@Service
public class MarcaService {
    //Atributos
    MarcaDAO marcaDao;

    //Constructor
    @Autowired
    public MarcaService(MarcaDAO md){
        this.marcaDao = md;
    }

    //Metodos
    public void newMarca(String descripcion, String pais) throws ParseException {
        Marca m = new Marca();
        m.setDescripcion(descripcion);
        m.setPais(pais);
        this.marcaDao.guardarMarca(m);
    }

    public List<Marca> getTodas(){
        return marcaDao.getTodas();
    }

    public Marca getPorId(int id){
        return marcaDao.getPorId(id);
    }

    public Marca getPorNombre(String desc){
        return marcaDao.getPorNombre(desc);
    }

    public List<Marca> getPorPais(String pais){
        return marcaDao.getPorPais(pais);
    }
}
