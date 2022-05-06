/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Educacion;

/**
 *
 * @author agust
 */
public interface IEducacionService {
    public void saveEducacion(Educacion educa);
    public Educacion buscarEducacion(Long id);
}
