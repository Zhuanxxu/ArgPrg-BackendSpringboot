
package com.clase.clase.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class TecnologiaProyecto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "tecnologiaId")
    private Tecnologia tecn;
    
    @ManyToOne
    @JoinColumn(name = "proyectoId")
    private Proyecto proy;

    public TecnologiaProyecto(Long id, Tecnologia tecn, Proyecto proy) {
        this.id = id;
        this.tecn = tecn;
        this.proy = proy;
    }

    public TecnologiaProyecto() {
    }
    
    
    
}
