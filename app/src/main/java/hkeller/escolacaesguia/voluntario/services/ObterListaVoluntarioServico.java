package hkeller.escolacaesguia.voluntario.services;

import hkeller.escolacaesguia.voluntario.model.Voluntario;
import hkeller.escolacaesguia.voluntario.repository.VoluntarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class ObterListaVoluntarioServico {

  @Autowired
  VoluntarioRepositorio voluntarioRepositorio;
  public Page<Voluntario> execute(Integer page, Integer size){
    Page<Voluntario> voluntario = voluntarioRepositorio.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    return voluntario;
  }
}



