/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.javainuse.controller;

import com.javainuse.message.ResponseFile;
import com.javainuse.message.ResponseMessage;
import com.javainuse.model.Domicilio;
import com.javainuse.model.Educacion;
import com.javainuse.model.FileDB;
import com.javainuse.model.Localidad;
import com.javainuse.model.Persona;
import com.javainuse.model.Proyecto;
import com.javainuse.model.Skill;
import com.javainuse.model.Tecnologia;
import com.javainuse.model.TecnologiaProyecto;
import com.javainuse.service.FileStorageService;
import com.javainuse.service.IDomicilioService;
import com.javainuse.service.IEducacionService;
import com.javainuse.service.ILocalidadService;
import com.javainuse.service.IPersonaService;
import com.javainuse.service.IProyectoService;
import com.javainuse.service.ISkillService;
import com.javainuse.service.ITecnologiaProyectoService;
import com.javainuse.service.ITecnologiaService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Agustín
 */

@RestController

@CrossOrigin
public class controller {
    
    @Autowired
    private IPersonaService persoServ;
    @Autowired
    private ILocalidadService localServ;
    @Autowired
    private IDomicilioService domicServ;
    @Autowired
    private IEducacionService educaServ;
    @Autowired
    private IProyectoService proyeServ;
    @Autowired
    private ISkillService skillServ;
    @Autowired
    private ITecnologiaService tecnoServ;
    @Autowired
    private ITecnologiaProyectoService tecnoProyeServ;
 
    
    
    
    //Metodos @Get  --->   Path para obtener informacion
    
    @GetMapping("/personaCompleta/{id}")
    public Persona buscarPersonaCompleta(@PathVariable Long id){
        
        
        return persoServ.buscarPersona(id);
        
    }
    
    
    
    @GetMapping("/test/{correo}")
    public Persona buscarPersonaEmail(@PathVariable String correo){
       

        return persoServ.buscarPersonaCorreo(correo).get(0);
    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> obtenerPersonas() {
        return persoServ.verPersonas();
        
        //return ListaPersonas;
    }
    
    @GetMapping("ver/localidades")
    @ResponseBody 
    public List<Localidad> obtenerLocalidades(){
        return localServ.verLocalidades();
    }
    
   
    
    @GetMapping("ver/ss/fotos")
    
    
    
    //Metodos @Post  --->   Path para agregar informacion
    
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona per) {
        //ListaPersonas.add(per);
        persoServ.crearPersona(per);
    }
    
    
    

    @PostMapping("/save/persona")
    public void actualizarPersona(@RequestBody Persona per) {
        //ListaPersonas.add(per);
        persoServ.crearPersona(per);
    }
    
    
    
    //Metodos @Delete ---> Path para borrar informacion
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    
    
    //Metodos @Put  --->   Path para editar registros
    
    @PutMapping ("personas/editar/{id}")
    public Persona actualizarPersona(@PathVariable Long id,
                                     @RequestParam (required = false,name = "nombre") String nuevoNombre,
                                     @RequestParam (required = false,name ="apellido") String nuevoApellido,
                                     @RequestParam (required = false,name ="edad") Integer nuevaEdad,
                                     @RequestParam (required = false,name ="descripcion") String nuevaDescripcion,
                                     @RequestParam (required = false,name ="titulo") String nuevoTitulo,
                                     @RequestParam (required = false,name ="correo") String nuevoCorreo,
                                     @RequestParam (required = false,name ="urlFotoPerfil") String nuevoUrlFotoPerfil,
                                     @RequestParam (required = false,name ="urlFotoPortada") String nuevoUrlFotoPortada){
       Persona perso = persoServ.buscarPersona(id);
       
       if (!(nuevoApellido==null || nuevoApellido.isEmpty())) { perso.setApellido(nuevoApellido);}
       if (!(nuevoNombre==null || nuevoNombre.isEmpty())) { perso.setNombre(nuevoNombre);}
       if (!(nuevaEdad==null)) { perso.setEdad(nuevaEdad);}
       if (!(nuevaDescripcion==null || nuevaDescripcion.isEmpty())) { perso.setDescripcion(nuevaDescripcion);}
       if (!(nuevoTitulo==null || nuevoTitulo.isEmpty())) { perso.setTitulo(nuevoTitulo);}
       if (!(nuevoCorreo==null || nuevoCorreo.isEmpty())) { perso.setCorreo(nuevoCorreo);}
       if (!(nuevoUrlFotoPerfil==null || nuevoUrlFotoPerfil.isEmpty())) { perso.setUrlFotoPerfil(nuevoUrlFotoPerfil);}
       if (!(nuevoUrlFotoPortada==null || nuevoUrlFotoPortada.isEmpty())) { perso.setUrlFotoPortada(nuevoUrlFotoPortada);}
       
       
       persoServ.savePersona(perso);
       
       return perso;
        
    }
    
    @PutMapping ("localidades/editar/{id}")
    public Localidad actualizarLocalidad(@PathVariable Long id,
                                         @RequestParam (required = false,name = "ciudad") String nuevaCiudad,
                                         @RequestParam (required = false,name = "pais") String nuevoPais,
                                         @RequestParam (required = false,name = "provincia") String nuevaProvincia){
        Localidad local = localServ.buscarLocalidad(id);
        
        if (!(nuevaCiudad==null)) {local.setCiudad(nuevaCiudad);}
        if (!(nuevoPais==null)) {local.setPais(nuevoPais);}
        if (!(nuevaProvincia==null)) {local.setProvincia(nuevaProvincia);}
        
        localServ.saveLocalidad(local);
        
        return local;
    }
            
    @PutMapping ("domicilios/editar/{id}")
    public Domicilio actualizarDomicilio(@PathVariable Long id,
                                        @RequestParam (required = false,name = "direccion") String nuevaDireccion,
                                        @RequestParam (required = false,name = "localidad_id") Long nuevoLocalidad_id){
        Domicilio domic = domicServ.buscarDomicilio(id);
        
        if (!(nuevaDireccion==null)) {domic.setDireccion(nuevaDireccion);}
        if (!(nuevoLocalidad_id==null)) {Localidad local = localServ.buscarLocalidad(nuevoLocalidad_id);
                                        domic.setLocalidad(local);}
     
        
        domicServ.saveDomicilio(domic);
        
        return domic;             
    }
    
    @PutMapping("educacion/editar/{id}")
    public Educacion actualizarEducacion(@PathVariable Long id,
                                        @RequestParam (required = false,name = "instituto") String nuevoInstituto,
                                        @RequestParam (required = false,name = "porcentaje_terminacion") String nuevoPorcentaje,
                                        @RequestParam (required = false,name = "titulo") String nuevoTitulo,
                                        @RequestParam (required = false,name = "descripcion") String nuevaDescripcion,
                                        @RequestParam (required = false,name = "persona_id") Long nuevaPersonaId,
                                        @RequestParam (required = false,name = "foto") MultipartFile fotoEducacion) throws IOException{
        Educacion educa = educaServ.buscarEducacion(id);
        
        if (!(nuevaDescripcion==null|| nuevaDescripcion.isEmpty())) {educa.setDescripcion(nuevaDescripcion);}
        if (!(nuevoInstituto==null|| nuevoInstituto.isEmpty())) {educa.setInstituto(nuevoInstituto);}
        if (!(nuevoTitulo==null|| nuevoTitulo.isEmpty())) {educa.setTitulo(nuevoTitulo);}
        
        if (!(nuevaPersonaId==null|| String.valueOf(nuevaPersonaId).isEmpty())) {Persona perso = persoServ.buscarPersona(nuevaPersonaId);
                                        educa.setPersona(perso);}
        
        if (!(fotoEducacion==null|| String.valueOf(fotoEducacion).isEmpty())) {educa.setImagen(fotoEducacion.getBytes());}
       
        educaServ.saveEducacion(educa);
        
        return educa;
    }
    
    @PutMapping("proyecto/editar/{id}")
    public Proyecto actualizarProyecto(@PathVariable Long id,
                                       @RequestParam (required = false,name = "descripcion") String nuevaDescripcion,
                                       @RequestParam (required = false,name = "nombre_proy") String nuevoNombre_proy,
                                       @RequestParam (required = false,name = "url") String nuevoUrl,
                                       @RequestParam (required = false,name = "persona_id") Long nuevaPersonaId){
        Proyecto proye = proyeServ.buscarProyecto(id);
        
        if (!(nuevaDescripcion==null)) {proye.setDescripcion(nuevaDescripcion);}
        if (!(nuevoNombre_proy==null)) {proye.setNombreProy(nuevoNombre_proy);}
        if (!(nuevoUrl==null)) {proye.setUrl(nuevoUrl);}
        if (!(nuevaPersonaId==null)) {Persona perso = persoServ.buscarPersona(nuevaPersonaId);
                                        proye.setPersona(perso);}
        
        proyeServ.saveProyecto(proye);
        
        return proye;
    }
    
    @PutMapping("skill/editar/{id}")
    public Skill actualizarSkill(@PathVariable Long id,
                                @RequestParam (required = false,name = "descripcion") String nuevaDescripcion,
                                @RequestParam (required = false,name = "porcentaje_completo") Integer nuevoPorcentaje_completo,
                                @RequestParam (required = false,name = "url_foto") String nuevaUrl_foto,
                                @RequestParam (required = false,name = "personaId") Long nuevaPersonaId){
        
        Skill skill = skillServ.buscarSkill(id);
        
        if (!(nuevaDescripcion==null || nuevaDescripcion.isEmpty())) {skill.setDescripcion(nuevaDescripcion);}
        if (!(nuevoPorcentaje_completo==null)) {skill.setPorcentajeCompleto(nuevoPorcentaje_completo);}
        if (!(nuevaUrl_foto==null || nuevaUrl_foto.isEmpty())) {skill.setUrlFoto(nuevaUrl_foto);}
        if (!(nuevaPersonaId==null || nuevaPersonaId.toString().isEmpty())) {Persona perso = persoServ.buscarPersona(nuevaPersonaId);
            if (!skill.getPersonas().contains(perso) && perso != null){
                skill.getPersonas().add(perso);
            }
        }
        
        skillServ.saveSkill(skill);
        
        return skill;
    }
    
    @PutMapping("tecnologia/editar/{id}")
    public Tecnologia actualizarTecnologia(@PathVariable Long id,
                                           @RequestParam (required = false,name = "tecnologia") String nuevaTecnologia){
        
        Tecnologia tecno = tecnoServ.buscarTecnologia(id);
        
        if (!(nuevaTecnologia==null)) {tecno.setTecnologias(nuevaTecnologia);}
        
        tecnoServ.saveTecnologia(tecno);
        
        return tecno;
        
    }
    
    @PutMapping("tecnologia_proyecto/editar/{id}")
    public TecnologiaProyecto actualizarTecnologiaProyecto(@PathVariable Long id,
                                                            @RequestParam (required = false,name = "proyectoId") Long nuevoProyetoId,
                                                            @RequestParam (required = false,name = "tecnologiaId") Long nuevoTecnologiaId){
        
        TecnologiaProyecto tecnoProye = tecnoProyeServ.buscarTecnologiaProyecto(id);
        
        if (!(nuevoTecnologiaId==null)) {
            Tecnologia tecno = tecnoServ.buscarTecnologia(nuevoTecnologiaId);
            tecnoProye.setTecnologia(tecno);         
        }
        if (!(nuevoProyetoId==null)) {
            Proyecto proye = proyeServ.buscarProyecto(nuevoProyetoId);
            tecnoProye.setProyecto(proye);
        }
        
        tecnoProyeServ.saveTecnologiaProyecto(tecnoProye);
        
        return tecnoProye;
        
    }
    
    //Metodos para fotos
    
    @Autowired
  private FileStorageService storageService;
    
    @PutMapping("/editarfoto/{id}")
  public ResponseEntity<ResponseMessage> editFoto(@RequestParam("file") MultipartFile file,@PathVariable Long id,
                                                    @RequestParam("lugar") String lugar) {
      Persona persona = persoServ.buscarPersona(id);
      List<FileDB> fileDbs = storageService.buscarPorPersona(persona);
      FileDB fileDb = new FileDB();
      for(FileDB iterador :fileDbs) {
          if (iterador.getLugar() == null ? lugar == null : iterador.getLugar().equals(lugar)) {
              fileDb=iterador;
              break;
          }
      }
      
      String message = "";
    try {
      storageService.storeActualizar(file,persona,fileDb,lugar);
      message = "Foto actualizada correctamente: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
      
  }
  
  @PostMapping("/upload/{id}")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable Long id,
                                                    @RequestParam("lugar") String lugar) {
    String message = "";
    Persona persona = persoServ.buscarPersona(id);
    try {
      storageService.store(file,persona,lugar);
      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
 
  
/*
  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/filesUnico/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getImagen().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }*/

  @GetMapping("/filesUnico/{idPerso}/{lugar}")
  public ResponseEntity<byte[]> getFile(@PathVariable Long idPerso,@PathVariable String lugar) {
      Persona persona = persoServ.buscarPersona(idPerso);
      List<FileDB> fileDbs = storageService.buscarPorPersona(persona);
      //storageService.buscarPorPersona(persona).get(0);
       //FileDB fileDB = fileDbs.buscarPorLugar(lugar).get(0);
       FileDB fileDB = new FileDB();
       for(FileDB iterador :fileDbs) {
          if (iterador.getLugar() == null ? lugar == null : iterador.getLugar().equals(lugar)) {
              fileDB=iterador;
              break;
          }
      }
       
       
       System.out.println(fileDB);
       FileDB entrega = new FileDB();
       entrega.setId(fileDB.getId());
       return getImagenPath(fileDB.getId());
    /*return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(entrega);*/
  }
  
  //@GetMapping("/imagen/{id}")
  public ResponseEntity<byte[]> getImagenPath( String id) {
      FileDB fileDB = storageService.getFile(id);
      
      
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getImagen());
  }
  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListaNueva() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/filesUnico/")
          .path(String.valueOf(dbFile.getPersonaId()))
          .path("/")
          .path(dbFile.getLugar())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getImagen().length,
          dbFile.getPersonaId(),
          dbFile.getLugar());
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }
  
}
