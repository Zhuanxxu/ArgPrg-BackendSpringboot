/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.clase.clase.controller;

import com.clase.clase.model.Persona;
import com.clase.clase.model.Prueba;
import com.clase.clase.service.IPersonaService;
import com.clase.clase.service.IPruebaService;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agustín
 */

@RestController


public class controller {
    
    @Autowired
    private IPersonaService persoServ;
    /*
    List<Persona> ListaPersonas = new ArrayList();
    
    @GetMapping("/jelou/{nombre}/{apellido}/{edad}")
    public String hola(@PathVariable String nombre,
                       @PathVariable String apellido,
                       @PathVariable int edad) {
        return "Bienvenido a springBoot " + nombre +" "+ apellido + "! de" + edad +" años.";
    }
    
    @GetMapping("/adios/")
    public String adios(@RequestParam String nombre,
                       @RequestParam String apellido,
                       @RequestParam int edad) {
        return "Adios " + nombre +" "+ apellido + "! de" + edad +" años.";
    }
    */
    @Autowired
    private IPruebaService prueServ;
    
    
    
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
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> obtenerPersonas() {
        return persoServ.verPersonas();
        
        //return ListaPersonas;
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    @GetMapping("/ver/pruebas")
    @ResponseBody
    public List<Prueba> obtenerPrueba() {
        return prueServ.verPruebas();
        
        //return ListaPersonas;
    }
    
    @PostMapping("/new/prueba")
    public void agregarPrueba(@RequestBody Prueba pru) {
        //ListaPersonas.add(per);
        prueServ.crearPrueba(pru);
    }
    
    /*@PutMapping("/update/persona")
    @ResponseBody
    public String updatePersona(@RequestBody Persona per) {
    //userRepository.save(user);
    
    ListaPersonas.set(ListaPersonas.indexOf(per)+1, per);
    //ListaPersonas.
    return "Updated"; }
    
    */
}
