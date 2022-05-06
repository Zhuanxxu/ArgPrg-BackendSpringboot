/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Agustín
 */
@Getter @Setter
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

   
   
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    @Basic
    private LocalDate fechaNac;
    //la fecha que viene es AAAA/MM/DD
    private String correo;
    private String descripcion;
    private String titulo;
    private int edad;
    private String urlFotoPerfil;
    private String urlFotoPortada;
    
    
    @ManyToOne()
    @JoinColumn()
    private Domicilio domicilio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Educacion> educacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Proyecto> proyectos;
    
    
    @ManyToMany(mappedBy = "personas")
    private List<Skill> skills;
    
    @OneToMany(mappedBy = "persona")
    private List<FileDB> fileDbs;
   
    
    
    public Persona() {
    }

    
}
