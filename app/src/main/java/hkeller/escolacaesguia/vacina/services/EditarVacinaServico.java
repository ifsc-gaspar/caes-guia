package hkeller.escolacaesguia.vacina.services;

import hkeller.escolacaesguia.vacina.dto.VacinaDto;
import hkeller.escolacaesguia.vacina.model.Vacina;
import hkeller.escolacaesguia.vacina.repository.VacinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.vacina.mapper.VacinaMapper.mapToVacina;

@Service
public class EditarVacinaServico {
  @Autowired
  VacinaRepositorio vacinaRepositorio;
  public void execute(VacinaDto vacinaDto){
    Vacina vacina = mapToVacina(vacinaDto);
    vacinaRepositorio.save(vacina);
  }
}
