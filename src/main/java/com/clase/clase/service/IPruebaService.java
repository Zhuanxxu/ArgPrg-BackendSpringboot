
package com.clase.clase.service;

import com.clase.clase.model.Prueba;
import java.util.List;

public interface IPruebaService {
    public List<Prueba> verPruebas();
    public void crearPrueba(Prueba pru);
    public void borrarPrueba(int id);
    public Prueba buscarPrueba(int id);
}
