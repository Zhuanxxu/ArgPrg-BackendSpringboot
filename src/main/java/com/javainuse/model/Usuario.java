
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
@Table(name = "Usuario")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUSUARIO")
    private Long idUSUARIO;
    @Column(name = "nombre_usu")
    private String nombre_usu;
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @ManyToOne
    @JoinColumn(name = "id")
    Persona pers;

    public Usuario() {
    }

    public Usuario(Long idUSUARIO, String nombre_usu, String contrasenia, Persona pers) {
        this.idUSUARIO = idUSUARIO;
        this.nombre_usu = nombre_usu;
        this.contrasenia = contrasenia;
        this.pers = pers;
    }
    
    
}
