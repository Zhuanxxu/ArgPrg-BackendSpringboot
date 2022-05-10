/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Tecnologia;
import java.util.List;

/**
 *
 * @author agust
 */
public interface ITecnologiaService {
    public Tecnologia buscarTecnologia(Long id);
    public void saveTecnologia(Tecnologia tecno);
    public List<Tecnologia> verTecnologias() ;
}
