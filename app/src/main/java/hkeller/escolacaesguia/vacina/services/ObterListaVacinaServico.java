package hkeller.escolacaesguia.vacina.services;

import hkeller.escolacaesguia.vacina.model.Vacina;
import hkeller.escolacaesguia.vacina.repository.VacinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ObterListaVacinaServico {

  @Autowired
  VacinaRepositorio vacinaRepositorio;

  public Page<Vacina> execute(Integer page, Integer size){
    Page<Vacina> vacina = vacinaRepositorio.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    return vacina;
  }
}
