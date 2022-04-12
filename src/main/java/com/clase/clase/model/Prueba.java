package com.clase.clase.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Agustín
 */
@Getter @Setter
@Entity
public class Prueba  implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int nota_examen;

    public Prueba() {
    }

    public Prueba(int id, int nota_examen) {
        this.id = id;
        this.nota_examen = nota_examen;
    }
    
}
