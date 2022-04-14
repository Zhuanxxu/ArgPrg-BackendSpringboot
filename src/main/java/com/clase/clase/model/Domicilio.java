package com.clase.clase.model;

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
    @Column(name = "idDOMICILIO")
    private Long idDOMICILIO;
    @Column(name = "direccion")
    private String direccion;
    
    /*@OneToOne
    @JoinColumn(name = "id")
    private Persona pers;*/
    
    @ManyToOne
    @JoinColumn(name = "LocalidadId")
    private Localidad loca;
    
    @OneToOne
    @JoinColumn(name = "personaId")
    private Persona pers;

    public Domicilio(Long idDOMICILIO, String direccion, Localidad loca, Persona pers) {
        this.idDOMICILIO = idDOMICILIO;
        this.direccion = direccion;
        this.loca = loca;
        this.pers = pers;
    }

    

    public Domicilio() {
    }
    
    
}
