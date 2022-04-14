
package com.clase.clase.model;

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
    @Column(name = "idEXPERIENCIA_LABORAL")
    private Long idEXPERIENCIA_LABORAL;
    @Column(name = "empleo")
    private String empleo;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "descripcion_actividad")
    private String descripcion_actividad;
    
    @ManyToOne
    @JoinColumn(name = "persona_id")
    Persona pers;

    public Experiencia(Long idEXPERIENCIA_LABORAL, String empleo, String empresa, String descripcion_actividad, Persona pers) {
        this.idEXPERIENCIA_LABORAL = idEXPERIENCIA_LABORAL;
        this.empleo = empleo;
        this.empresa = empresa;
        this.descripcion_actividad = descripcion_actividad;
        this.pers = pers;
    }

    

    public Experiencia() {
    }
    
    
}
