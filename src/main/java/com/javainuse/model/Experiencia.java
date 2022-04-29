
package com.javainuse.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "Experiencia")
public class Experiencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String empleo;
    private String empresa;
    private String descripcion_actividad;
    
    @ManyToOne
    @JoinColumn()
    Persona pers;

    public Experiencia(Long id, String empleo, String empresa, String descripcion_actividad, Persona pers) {
        this.id = id;
        this.empleo = empleo;
        this.empresa = empresa;
        this.descripcion_actividad = descripcion_actividad;
        this.pers = pers;
    }

    

    public Experiencia() {
    }
    
    
}
