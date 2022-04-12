/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase.clase.service;

import com.clase.clase.model.Prueba;
import com.clase.clase.repository.PruebaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaService implements IPruebaService{

    
    @Autowired
    public PruebaRepository PrueRepo;
    
    @Override
    public List<Prueba> verPruebas() {
        return  PrueRepo.findAll();
    }

    @Override
    public void crearPrueba(Prueba pru) {
        PrueRepo.save(pru);
    }

    @Override
    public void borrarPrueba(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prueba buscarPrueba(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
