/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Localidad;
import com.javainuse.repository.LocalidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocalidadService implements ILocalidadService{
    @Autowired
    public LocalidadRepository localRepo;
    
    
    @Override
    public Localidad buscarLocalidad(Long id){
        return localRepo.findById(id).orElse(null);
    }
    
    @Override
    public void saveLocalidad(Localidad local){
        localRepo.save(local);
    }
    
    @Override
    public List<Localidad> verLocalidades() {
       return  localRepo.findAll();
    }
    
}
