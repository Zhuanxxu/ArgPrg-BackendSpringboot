
package com.javainuse.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "Localidad")
public class Localidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLOCALIDAD")
    private Long idLOCALIDAD;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "pais")
    private String pais;
    

    public Localidad() {
    }

    public Localidad(Long idLOCALIDAD, String ciudad, String provincia, String pais) {
        this.idLOCALIDAD = idLOCALIDAD;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }
    
    
}
