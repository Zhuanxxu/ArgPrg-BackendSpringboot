/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Educacion;
import com.javainuse.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agust
 */
@Service
public class EducacionService implements IEducacionService{
    @Autowired
    public EducacionRepository educaRepo;
    
    
    
    @Override
    public Educacion buscarEducacion(Long id){
        return educaRepo.findById(id).orElse(null);
    }
    
    @Override
    public void saveEducacion(Educacion educa){
        educaRepo.save(educa);
    }
}
