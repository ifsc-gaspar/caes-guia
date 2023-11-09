package hkeller.escolacaesguia.voluntario.services;


import hkeller.escolacaesguia.voluntario.dto.VoluntarioDto;
import hkeller.escolacaesguia.voluntario.model.Voluntario;
import hkeller.escolacaesguia.voluntario.repository.VoluntarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.voluntario.mapper.VoluntarioMapper.mapToVoluntario;

@Service
public class EditarVoluntarioServico {
  @Autowired
  VoluntarioRepositorio voluntarioRepositorio;
  public void execute(VoluntarioDto voluntarioDto){
   Voluntario voluntario = mapToVoluntario(voluntarioDto);
   voluntarioRepositorio.save(voluntario);
  }
}

