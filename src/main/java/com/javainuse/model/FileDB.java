package com.javainuse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class FileDB {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  //@GeneratedValue(strategy = GenerationType.AUTO)
  private String id;
  private String name;
  private String lugar;
  private String type;
 
  
  private String path;
  @JsonIgnore
  @Lob
  @Basic(fetch = FetchType.LAZY) 
  @Column(name="datos", columnDefinition="longblob", nullable=true) 
  private byte[] imagen;
  
  @JsonIgnore
  @ManyToOne
  @JoinColumn( nullable = false, updatable = false)
  private Persona persona;
    
  public FileDB() {
  }

  /*public FileDB(String name, String type, byte[] data,Persona persona) {
    
    this.name = name;
    this.type = type;
    this.imagen = data;
    this.persona = persona;
    long Long = 5;
    this.id = Long;
  }*/
  
  public FileDB( String name, String type, byte[] imagen, Persona persona,String lugar) {
        this.name = name;
        this.type = type;
        this.imagen = imagen;
        this.persona = persona;
        this.lugar = lugar;
        this.path = "filesUnico/" + String.valueOf(persona.getId()) +"/"+lugar;
  }

    public String getId() {
        return id;
    }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getImagen() {
    return imagen;
  }

  public void setImagen(byte[] data) {
    this.imagen = data;
  }
  public void setId(String id){
      this.id = id;
  }

    public String getLugar() {
        return lugar;
    }

    public Long getPersonaId() {
        return persona.getId();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
  

}
