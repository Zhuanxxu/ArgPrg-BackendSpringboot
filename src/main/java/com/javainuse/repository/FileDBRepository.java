package com.javainuse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.FileDB;
import com.javainuse.model.Persona;
import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
    List<FileDB> findByPersona(Persona persona);
    List<FileDB> findByLugar(String lugar);
}
