/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    private Long id;
    private String nombreProy;
    private String descripcion;
    private String url;
    
    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "proyectos_tecnologias",
            joinColumns = {@JoinColumn(name = "tecnologia_id")},
            inverseJoinColumns = {@JoinColumn(name = "proyecto_id")}
    )
    private List<Tecnologia> tecnologias;

    /*@ManyToOne
    @JoinColumn(name = "id")
    Persona pers;*/
    @JsonIgnore
    @ManyToOne
    @JoinColumn()
    Persona persona;
    
    

    public Proyecto() {
    }

    public Proyecto(Long id, String nombreProy, String desc, String desc2, Persona persona) {
        this.id = id;
        this.nombreProy = nombreProy;
        this.descripcion = desc;
        this.persona = persona;
    }
    
    
    
}
