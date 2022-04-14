
package com.clase.clase.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "Educacion")
public class Educacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEDUCACION")
    private Long idEDUCACION;
    @Column(name = "instituto")
    private String instituto;
    @Column(name = "fechaIni")
    private LocalDate fechaIni;
    @Column(name = "fechaFin")
    private LocalDate fechaFin;
    
    @ManyToOne
    @JoinColumn(name = "persona_id")
    Persona pers;

    public Educacion(Long idEDUCACION, String instituto, LocalDate fechaIni, LocalDate fechaFin, Persona pers) {
        this.idEDUCACION = idEDUCACION;
        this.instituto = instituto;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pers = pers;
    }

   

    public Educacion() {
    }
    
   
    
}
