
package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    private Long id;
    private String instituto;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private String urlFoto;
    private String porcentajeTerminacion;
    private String titulo;
    private String descripcion;
    
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn( nullable = false, updatable = false)
    private Persona persona;
    
    @JsonIgnore
    @Lob
    @Basic(fetch = FetchType.LAZY) 
    @Column(name="datos", columnDefinition="longblob", nullable=true) 
    private byte[] imagen;

    public Educacion(Long id, String instituto, LocalDate fechaIni, LocalDate fechaFin, String urlFoto, String porcentajeTerminacion, String titulo, String descripcion, Persona persona, byte[] imagen) {
        this.id = id;
        this.instituto = instituto;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.urlFoto = urlFoto;
        this.porcentajeTerminacion = porcentajeTerminacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.persona = persona;
        this.imagen = imagen;
    }

    

    

   

    public Educacion() {
    }
    
   
    
}
