/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.TecnologiaProyecto;
import com.javainuse.repository.TecnologiaProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agust
 */
@Service
public class TecnologiaProyectoService implements ITecnologiaProyectoService{
    @Autowired
    public TecnologiaProyectoRepository tecnProyRepo;
    
    @Override
    public TecnologiaProyecto buscarTecnologiaProyecto(Long id){
        return tecnProyRepo.findById(id).orElse(null);
    }
    
    @Override
    public void saveTecnologiaProyecto(TecnologiaProyecto tecnoProye){
        tecnProyRepo.save(tecnoProye);
    };
}
