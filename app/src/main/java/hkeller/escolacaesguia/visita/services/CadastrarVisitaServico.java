package hkeller.escolacaesguia.visita.services;

import hkeller.escolacaesguia.visita.dto.RequisicaoCadastroVisitaDto;
import hkeller.escolacaesguia.visita.model.Visita;
import hkeller.escolacaesguia.visita.repository.VisitaRepository;
import hkeller.escolacaesguia.endereco.model.Endereco;
import hkeller.escolacaesguia.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static hkeller.escolacaesguia.visita.mapper.VisitaMapper.mapToVisita;
import java.util.Optional;


@Service
public class CadastrarVisitaServico {
    @Autowired
    VisitaRepository visitaRepositorio;

    @Autowired
    EnderecoRepository enderecoRepositorio;

    public void executar(RequisicaoCadastroVisitaDto visitaDto) {
      Visita visita = mapToVisita(visitaDto);

      Optional<Endereco> resultadoBuscarEnderecoPorCep = enderecoRepositorio.findByCep(visitaDto.getEndereco().getCep());

      Endereco endereco = resultadoBuscarEnderecoPorCep.orElse(null);

      visita.setEndereco(endereco);

      visitaRepositorio.save(visita);
    }
}
