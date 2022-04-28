
package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String urlFoto;
    private String porcentajeTerminacion;
    private String titulo;
    
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn( nullable = false, updatable = false)
    private Persona persona;

    public Educacion(Long idEDUCACION, String instituto, LocalDate fechaIni, LocalDate fechaFin, String urlFoto, String porcentajeTerminacion, String titulo, Persona persona) {
        this.idEDUCACION = idEDUCACION;
        this.instituto = instituto;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.urlFoto = urlFoto;
        this.porcentajeTerminacion = porcentajeTerminacion;
        this.titulo = titulo;
        this.persona = persona;
    }

    

   

    public Educacion() {
    }
    
   
    
}
