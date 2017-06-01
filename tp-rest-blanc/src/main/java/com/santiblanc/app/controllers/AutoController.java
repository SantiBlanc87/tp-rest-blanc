package com.santiblanc.app.controllers;

import com.santiblanc.app.converter.AutoConverter;
import com.santiblanc.app.converter.MarcaConverter;
import com.santiblanc.app.entities.Auto;
import com.santiblanc.app.entities.Marca;
import com.santiblanc.app.request.AutoRequest;
import com.santiblanc.app.request.MarcaRequest;
import com.santiblanc.app.response.AutoWrapper;
import com.santiblanc.app.response.MarcaWrapper;
import com.santiblanc.app.services.AutoService;
import com.santiblanc.app.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blade-Razer on 5/31/2017.
 */

@Controller
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AutoController {
    //Atributos
    @Autowired
    AutoService autoService;
    @Autowired
    MarcaService marcaService;
    @Autowired
    AutoConverter autoConverter;
    @Autowired
    MarcaConverter marcaConverter;

    //Metodos

    /*Marcas*/
    //Agregar Marca
    @RequestMapping(value = "/marca", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMarca(@RequestBody MarcaRequest request) {
        try {
            marcaService.newMarca(request.getDescripcion(), request.getPais());
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mostrar todas las Marcas
    @RequestMapping(value = "/marcas/", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<MarcaWrapper>> getTodas(){
        List<Marca> result = marcaService.getTodas();
        if (result.size()>0) {
            return new ResponseEntity<List<MarcaWrapper>>(this.convertListMarcas(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<MarcaWrapper>>(HttpStatus.NO_CONTENT);
        }
    }

/*----------------------------------------------------------------------------------------------------------------*/

    /*Autos*/
    //Agregar Auto
    @RequestMapping(value = "/auto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAuto(@RequestBody AutoRequest requestA) {
        try {
            Marca m = marcaService.getPorNombre(requestA.getMarca());
            autoService.newAuto(m, requestA.getModelo(), requestA.getKm(),
                    requestA.getPatente(), requestA.getAnio());
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Buscar todos los Autos
    @RequestMapping(value = "/autos/", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<AutoWrapper>> getTodos(){
        List<Auto> result = autoService.getTodos();
        if (result.size()>0) {
            return new ResponseEntity<List<AutoWrapper>>(this.convertListAutos(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<AutoWrapper>>(HttpStatus.NO_CONTENT);
        }
    }

    //Buscar Auto por ID univoco
    @RequestMapping(value = "/autos/id", method = RequestMethod.GET)
    public ResponseEntity<AutoWrapper> getPorId(@RequestParam("id") int id) {
        Auto a = autoService.getPorId(id);
        if (a!=null) {
            return new ResponseEntity<AutoWrapper>(this.autoConverter.convert(a), HttpStatus.OK);
        } else {
            return new ResponseEntity<AutoWrapper>(HttpStatus.NO_CONTENT);
        }
    }

    //Buscar Auto por Patente
    @RequestMapping(value = "/autos/pat", method = RequestMethod.GET)
    public ResponseEntity<AutoWrapper> getPorPatente(@RequestParam("patente") String pat) {
        Auto a = autoService.getPorPatente(pat);
        if (a!=null) {
            return new ResponseEntity<AutoWrapper>(this.autoConverter.convert(a), HttpStatus.OK);
        } else {
            return new ResponseEntity<AutoWrapper>(HttpStatus.NO_CONTENT);
        }
    }

    //Buscar Autos por Marca
    @RequestMapping(value = "/autos/byMarca", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<AutoWrapper>> getPorMarca(@RequestParam("descripcion") String request){
        Marca m = marcaService.getPorNombre(request);
        List<Auto> result = autoService.getPorMarca(m);
        if (result.size()>0) {
            return new ResponseEntity<List<AutoWrapper>>(this.convertListAutos(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<AutoWrapper>>(HttpStatus.NO_CONTENT);
        }
    }

    //Adicionales
    private List<AutoWrapper> convertListAutos(List<Auto> autos){
        List<AutoWrapper> autoWrapperList = new ArrayList<AutoWrapper>();
        for (Auto a: autos) {
            autoWrapperList.add(autoConverter.convert(a));
        }
        return autoWrapperList;
    }

    private List<MarcaWrapper> convertListMarcas(List<Marca> marcas){
        List<MarcaWrapper> marcaWrapperList = new ArrayList<MarcaWrapper>();
        for (Marca m: marcas) {
            marcaWrapperList.add(marcaConverter.convert(m));
        }
        return marcaWrapperList;
    }
}
