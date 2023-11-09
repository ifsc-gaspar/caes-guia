package hkeller.escolacaesguia.voluntario.services;

import hkeller.escolacaesguia.voluntario.dto.RequisicaoCadastroVoluntarioDto;
import hkeller.escolacaesguia.voluntario.model.Voluntario;
import hkeller.escolacaesguia.voluntario.repository.VoluntarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.voluntario.mapper.VoluntarioMapper.mapToVoluntario;

@Service
public class CadastrarVoluntarioServico {
  @Autowired
  VoluntarioRepositorio voluntarioRepositorio;


  public void executar(RequisicaoCadastroVoluntarioDto voluntarioDto){
    Voluntario voluntario = mapToVoluntario(voluntarioDto);
    voluntarioRepositorio.save(voluntario);

  }
}


