/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

import com.javainuse.model.Skill;
import java.util.List;

/**
 *
 * @author agust
 */
public interface ISkillService {
    public void saveSkill(Skill skill);
    public Skill buscarSkill(Long id);
    public List<Skill> verSkills();
}
