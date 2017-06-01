package com.santiblanc.app.persistence;

import com.santiblanc.app.entities.Marca;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blade-Razer on 5/31/2017.
 */

@Repository
public class MarcaDAO {
    //Atributos
    private List<Marca> lista;
    static int ultimo_id = 0;

    //Constructor
    public MarcaDAO(){
        this.lista = new ArrayList<Marca>();
    }

    //Metodos
    public void guardarMarca(Marca m){
        m.setId(++ultimo_id);
        lista.add(m);
    }

    public List<Marca> getTodas(){
        return lista;
    }

    public Marca getPorId(int id){
        for (Marca m: lista){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public Marca getPorNombre(String desc){
        for (Marca m: lista){
            if (m.getDescripcion().equalsIgnoreCase(desc)){
                return m;
            }
        }
        return null;
    }

    public List<Marca> getPorPais(String pais){
        List<Marca> resultados = new ArrayList<Marca>();
        for (Marca m: lista){
            if (m.getPais().equalsIgnoreCase(pais)){
                resultados.add(m);
            }
        }
        return resultados;
    }
}
