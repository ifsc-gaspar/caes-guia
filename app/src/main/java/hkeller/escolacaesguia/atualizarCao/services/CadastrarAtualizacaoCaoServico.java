package hkeller.escolacaesguia.atualizarCao.services;

import hkeller.escolacaesguia.atualizarCao.dto.RequisicaoCadastroAtualizarCaoDto;
import hkeller.escolacaesguia.atualizarCao.model.AtualizarCao;
import hkeller.escolacaesguia.atualizarCao.repository.AtualizarCaoRepositorio;
import hkeller.escolacaesguia.endereco.model.Endereco;
import hkeller.escolacaesguia.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static hkeller.escolacaesguia.atualizarCao.mapper.AtualizarCaoMapper.mapToAtualizarCao;
import java.util.Optional;


@Service
public class CadastrarAtualizacaoCaoServico {
    @Autowired
    AtualizarCaoRepositorio atualizarCaoRepositorio;

    @Autowired
    EnderecoRepository enderecoRepositorio;

    public void executar(RequisicaoCadastroAtualizarCaoDto atualizarCaoDto) {
      AtualizarCao atualizarCao = mapToAtualizarCao(atualizarCaoDto);

      Optional<Endereco> resultadoBuscarEnderecoPorCep = enderecoRepositorio.findByCep(atualizarCaoDto.getEndereco().getCep());

      Endereco endereco = resultadoBuscarEnderecoPorCep.orElse(null);

      atualizarCao.setEndereco(endereco);

      atualizarCaoRepositorio.save(atualizarCao);
    }
}
