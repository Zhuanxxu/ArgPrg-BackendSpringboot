package com.javainuse.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Domicilio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String direccion;
    
    /*@OneToOne
    @JoinColumn(name = "id")
    private Persona pers;*/
    
    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;
    
    

    public Domicilio(Long id, String direccion, Localidad localidad) {
        this.id = id;
        this.direccion = direccion;
        this.localidad = localidad;
        
    }

    

    public Domicilio() {
    }
    
    
}
