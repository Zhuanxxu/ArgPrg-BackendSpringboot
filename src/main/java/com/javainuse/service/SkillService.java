/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;


import com.javainuse.model.Skill;
import com.javainuse.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agust
 */
@Service
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository skillRepo;
    
    @Override
    public Skill buscarSkill(Long id){
        return skillRepo.findById(id).orElse(null);
    }
    
    
    @Override
    public void saveSkill(Skill skill){
        skillRepo.save(skill);
    }
    
    public List<Skill> verSkills(){
        return skillRepo.findAll();
    }
}
