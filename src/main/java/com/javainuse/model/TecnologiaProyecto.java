
package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn()
    private Tecnologia tecnologia;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn()
    private Proyecto proyecto;

    public TecnologiaProyecto(Long id, Tecnologia tecnologia, Proyecto proyecto) {
        this.id = id;
        this.tecnologia = tecnologia;
        this.proyecto = proyecto;
    }

    public TecnologiaProyecto() {
    }
    
    
    
}
