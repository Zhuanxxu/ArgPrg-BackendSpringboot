/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Localidad;
import java.util.List;

/**
 *
 * @author agust
 */
public interface ILocalidadService {
    public Localidad buscarLocalidad(Long id);
    public void saveLocalidad(Localidad local);
    public List<Localidad> verLocalidades();
    
}
