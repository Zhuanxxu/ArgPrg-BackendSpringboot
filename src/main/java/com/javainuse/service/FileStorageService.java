package com.javainuse.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.javainuse.model.FileDB;
import com.javainuse.model.Persona;
import com.javainuse.repository.FileDBRepository;
import java.util.List;

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public List<FileDB> buscarPorPersona(Persona persona){
      return fileDBRepository.findByPersona(persona);
  }
  public List<FileDB> buscarPorLugar(String lugar){
    return  fileDBRepository.findByLugar(lugar);
}
  
  public FileDB store(MultipartFile file,Persona persona) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(),persona);
    
    return fileDBRepository.save(FileDB);
  }
  
  public FileDB storeActualizar(MultipartFile file,Persona persona,FileDB fileDb) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(),persona);
    fileDb.setName(fileName);
    fileDb.setType(file.getContentType());
    fileDb.setImagen(file.getBytes());
    
    return fileDBRepository.save(fileDb);
  }

  public FileDB getFile(Long id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
