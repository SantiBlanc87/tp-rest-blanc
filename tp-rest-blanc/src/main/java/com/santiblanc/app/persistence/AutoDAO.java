package com.santiblanc.app.persistence;

import com.santiblanc.app.entities.Auto;
import com.santiblanc.app.entities.Marca;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blade-Razer on 5/31/2017.
 */

@Repository
public class AutoDAO {
    //Atributos
    private List<Auto> lista;
    static int ultimo_id = 0;

    //Constructor
    public AutoDAO(){
        this.lista = new ArrayList<Auto>();
    }

    //Metodos
    public void guardarAuto(Auto a){
        a.setId(++ultimo_id);
        lista.add(a);
    }

    public List<Auto> getTodos(){
        return lista;
    }

    public Auto getPorId(int id){
        for (Auto a: lista){
            if (id == a.getId()){
                return a;
            }
        }
        return null;
    }

    public Auto getPorPatente(String pat){
        for (Auto a: lista){
            if (pat.equalsIgnoreCase(a.getPatente())){
                return a;
            }
        }
        return null;
    }

    public List<Auto> getByMarca(Marca m){
        List<Auto> resultados = new ArrayList<Auto>();
        for (Auto a: lista){
            if (a.getMarca().equals(m)){
                resultados.add(a);
            }
        }
        return resultados;
    }
}
