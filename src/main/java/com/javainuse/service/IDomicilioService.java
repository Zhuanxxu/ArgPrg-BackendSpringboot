/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Domicilio;

/**
 *
 * @author agust
 */
public interface IDomicilioService {
    public Domicilio buscarDomicilio(Long id);
    public void saveDomicilio(Domicilio domic);
}
