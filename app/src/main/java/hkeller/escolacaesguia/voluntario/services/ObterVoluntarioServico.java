package hkeller.escolacaesguia.voluntario.services;

import hkeller.escolacaesguia.voluntario.model.Voluntario;
import hkeller.escolacaesguia.voluntario.repository.VoluntarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObterVoluntarioServico {

  @Autowired
  VoluntarioRepositorio voluntarioRepositorio;

  public Voluntario execute(Long idVoluntario) {
    // Verifique se o voluntário com o ID fornecido existe
    if (voluntarioRepositorio.existsById(idVoluntario)) {
      return voluntarioRepositorio.findById(idVoluntario).orElse(null);
    } else {
      // Trate o caso em que o voluntário não é encontrado, por exemplo, lançando uma exceção personalizada.
      System.out.println("");
//      throw new VoluntarioNaoEncontradoException("Voluntário com ID " + idVoluntario + " não encontrado.");
    }
      return null;
  }
}
