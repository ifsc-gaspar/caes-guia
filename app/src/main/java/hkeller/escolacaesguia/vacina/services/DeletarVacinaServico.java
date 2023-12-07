package hkeller.escolacaesguia.vacina.services;

import hkeller.escolacaesguia.vacina.repository.VacinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarVacinaServico {
  @Autowired
  VacinaRepositorio vacinaRepositorio;
  public void execute(Long idVacina){
    try{
      vacinaRepositorio.deleteById(idVacina);
    }catch (Exception exception){
      // TODO
    }
  }
}



