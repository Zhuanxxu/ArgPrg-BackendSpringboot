/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Proyecto;
import java.util.List;

/**
 *
 * @author agust
 */
public interface IProyectoService {
    public Proyecto buscarProyecto(Long id);
    public void saveProyecto(Proyecto educa);
    public void nuevoProyecto(Proyecto proyecto);
    public List<Proyecto> verProyectos();
}
