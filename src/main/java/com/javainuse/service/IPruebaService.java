
package com.javainuse.service;

import com.javainuse.model.Prueba;
import java.util.List;

public interface IPruebaService {
    public List<Prueba> verPruebas();
    public void crearPrueba(Prueba pru);
    public void borrarPrueba(int id);
    public Prueba buscarPrueba(int id);
}
