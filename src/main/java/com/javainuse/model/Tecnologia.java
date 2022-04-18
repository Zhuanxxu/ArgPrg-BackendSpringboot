/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
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

/**
 *
 * @author agust
 */
@Getter @Setter
@Entity
@Table(name = "Tecnologia")
public class Tecnologia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTECNOLOGIAS")
    private Long idTECNOLOGIAS;
    @Column(name = "tecnologias2")
    private String tecnologias;

    
    public Tecnologia() {
    }

    public Tecnologia(Long idTECNOLOGIAS, String tecnologias) {
        this.idTECNOLOGIAS = idTECNOLOGIAS;
        this.tecnologias = tecnologias;
    }

    
    
    
}
