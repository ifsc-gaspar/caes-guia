package hkeller.escolacaesguia.endereco.services;

import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import hkeller.escolacaesguia.endereco.mapper.EnderecoMapper;
import hkeller.escolacaesguia.endereco.model.Endereco;
import hkeller.escolacaesguia.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarEnderecoPorCepService {
  @Autowired
  private EnderecoRepository enderecoRepository;

  public EnderecoDto execute(int cep) {
    Optional<Endereco> result = enderecoRepository.findByCep(cep);

    Endereco endereco = result.orElse(null);

    EnderecoDto enderecoDto = EnderecoMapper.toDto(endereco);

    return enderecoDto;
  }
}
