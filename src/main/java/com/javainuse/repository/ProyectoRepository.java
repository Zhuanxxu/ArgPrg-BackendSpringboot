/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.repository;

import com.javainuse.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author agust
 */

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
