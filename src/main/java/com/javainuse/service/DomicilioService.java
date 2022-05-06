/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Domicilio;
import com.javainuse.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService{
    
    @Autowired
    public DomicilioRepository domicRepo;
    
    @Override
    public Domicilio buscarDomicilio(Long id){
        return domicRepo.findById(id).orElse(null);
    }
    
    @Override
    public void saveDomicilio(Domicilio domic){
        domicRepo.save(domic);
    }
    
   
}
