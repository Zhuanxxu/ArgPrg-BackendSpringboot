/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Proyecto;
import com.javainuse.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agust
 */
@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    public ProyectoRepository proyRepo;
    
    @Override
    public Proyecto buscarProyecto(Long id){
        return proyRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Proyecto> verProyectos(){
        return proyRepo.findAll();
    }
    
    @Override
    public void saveProyecto(Proyecto educa){
        proyRepo.save(educa);
    }
    
    @Override
    public void nuevoProyecto(Proyecto proyecto){
        proyRepo.save(proyecto);
    }
}
