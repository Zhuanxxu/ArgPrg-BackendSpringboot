/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase.clase.service;

import com.clase.clase.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agust
 */
@Service
public class TecnologiaService implements ITecnologiaService{
    @Autowired
    public TecnologiaRepository tecnRepo;
}
