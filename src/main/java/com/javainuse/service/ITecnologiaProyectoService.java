/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.TecnologiaProyecto;

/**
 *
 * @author agust
 */
public interface ITecnologiaProyectoService {
    public TecnologiaProyecto buscarTecnologiaProyecto(Long id);
    public void saveTecnologiaProyecto(TecnologiaProyecto tecnoProye);
}
