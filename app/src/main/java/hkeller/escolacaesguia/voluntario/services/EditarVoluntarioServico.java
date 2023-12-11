package hkeller.escolacaesguia.voluntario.services;


import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.cao.model.Cao;
import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import hkeller.escolacaesguia.voluntario.dto.VoluntarioDto;
import hkeller.escolacaesguia.voluntario.model.Voluntario;
import hkeller.escolacaesguia.voluntario.repository.VoluntarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.cao.mapper.CaoMapper.mapToCao;
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

