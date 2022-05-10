/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Skill {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String descripcion;
    String urlFoto;
    int porcentajeCompleto;
    String tipo;
    
    
    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "personas_skills",
            joinColumns = {@JoinColumn(name = "skill_id")},
            inverseJoinColumns = {@JoinColumn(name = "persona_id")}
    )
    private List<Persona> personas;

    public Skill() {
    }

    public Skill(Long id, String descripcion, String urlFoto, int porcentajeCompleto,String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.porcentajeCompleto = porcentajeCompleto;
        this.tipo = tipo;
        
    }

    
    
    
    
    
    
    
}
