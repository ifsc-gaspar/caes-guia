package hkeller.escolacaesguia.vacina.services;

import hkeller.escolacaesguia.vacina.model.Vacina;
import hkeller.escolacaesguia.vacina.repository.VacinaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObterVacinaServico {

  @Autowired
  VacinaRepositorio vacinaRepositorio;

  public Vacina execute(Long idVacina) {
    // Verifique se o voluntário com o ID fornecido existe
    if (vacinaRepositorio.existsById(idVacina)) {
      return vacinaRepositorio.findById(idVacina).orElse(null);
    } else {
      // Trate o caso em que o voluntário não é encontrado, por exemplo, lançando uma exceção personalizada.
      System.out.println("");
//      throw new VoluntarioNaoEncontradoException("Voluntário com ID " + idVoluntario + " não encontrado.");
    }
    return null;
  }
}
