package hkeller.escolacaesguia.voluntario.services;

import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import hkeller.escolacaesguia.voluntario.repository.VoluntarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarVoluntarioServico {
  @Autowired
  VoluntarioRepositorio voluntarioRepositorio;
  public void execute(Long id){
    try{
      voluntarioRepositorio.deleteById(id);
    }catch (Exception exception){
      // TODO
    }
  }
}

