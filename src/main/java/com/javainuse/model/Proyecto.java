/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author agust
 */
@Getter @Setter
@Entity
@Table(name = "Proyecto")
public class Proyecto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPROYECTOS")
    private Long idPROYECTOS;
    @Column(name = "nombre_proyecto")
    private String nombreProy;
    private String descripcion;


    /*@ManyToOne
    @JoinColumn(name = "id")
    Persona pers;*/
    
    @ManyToOne
    @JoinColumn(name = "persona_id")
    Persona pers;
    


    public Proyecto() {
    }

    public Proyecto(Long idPROYECTOS, String nombreProy, String desc, String desc2, Persona pers) {
        this.idPROYECTOS = idPROYECTOS;
        this.nombreProy = nombreProy;
        this.descripcion = desc;
        this.pers = pers;
    }
    
    
    
}
