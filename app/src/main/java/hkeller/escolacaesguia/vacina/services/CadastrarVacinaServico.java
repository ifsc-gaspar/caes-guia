package hkeller.escolacaesguia.vacina.services;

import hkeller.escolacaesguia.vacina.dto.RequisicaoCadastroVacinaDto;
import hkeller.escolacaesguia.vacina.model.Vacina;
import hkeller.escolacaesguia.vacina.repository.VacinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.vacina.mapper.VacinaMapper.mapToVacina;

@Service
public class CadastrarVacinaServico {

  @Autowired
  private VacinaRepositorio vacinaRepositorio;

  public void executar(RequisicaoCadastroVacinaDto requisicaoCadastroVacinaDto) {
    Vacina vacina = mapToVacina(requisicaoCadastroVacinaDto);
    vacinaRepositorio.save(vacina);
  }
}
