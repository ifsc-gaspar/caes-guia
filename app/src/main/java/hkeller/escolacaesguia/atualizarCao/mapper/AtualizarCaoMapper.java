package hkeller.escolacaesguia.atualizarCao.mapper;

import hkeller.escolacaesguia.atualizarCao.dto.AtualizarCaoDto;
import hkeller.escolacaesguia.atualizarCao.dto.RequisicaoCadastroAtualizarCaoDto;
import hkeller.escolacaesguia.atualizarCao.model.AtualizarCao;
import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;

import java.util.ArrayList;
import java.util.List;

public class AtualizarCaoMapper {

  public static AtualizarCao mapToAtualizarCao(RequisicaoCadastroAtualizarCaoDto atualizarCaoDto) {
    return AtualizarCao.builder()
      .email(atualizarCaoDto.getEmail())
      .nome(atualizarCaoDto.getNome())
      //.cep(atualizarCaoDto.getEndereco().getCep())
      .numero(atualizarCaoDto.getEndereco().getNumero())
      .complemento(atualizarCaoDto.getComplemento())
      .telefone(atualizarCaoDto.getTelefone())
      .nomeContatoRecado(atualizarCaoDto.getNomeContatoRecado())
      .telefoneContatoRecado(atualizarCaoDto.getTelefoneContatoRecado())
      .nomeCao(atualizarCaoDto.getNomeCao())
      .situacaoCao(atualizarCaoDto.getSituacaoCao())
      .antiparasitarioInternoData(atualizarCaoDto.getAntiparasitarioInternoData())
      .antiparasitarioExternoData(atualizarCaoDto.getAntiparasitarioExternoData())
      .trocaColeiraScaliborData(atualizarCaoDto.getTrocaColeiraScaliborData())
      .temCadernetaVacinacao(atualizarCaoDto.getTemCadernetaVacinacao())
      .ultimaVacinaNobivacDhppiL(atualizarCaoDto.getUltimaVacinaNobivacDhppiL())
      .ultimaVacinaNobivacRaiva(atualizarCaoDto.getUltimaVacinaNobivacRaiva())
      .temBlocoVeterinario(atualizarCaoDto.getTemBlocoVeterinario())
      .temCarteirinhaSocializador(atualizarCaoDto.getTemCarteirinhaSocializador())
      .build();
  }

  public static AtualizarCao mapToAtualizarCao(AtualizarCaoDto atualizarCaoDto) {
    return AtualizarCao.builder()
      .email(atualizarCaoDto.getEmail())
      .nome(atualizarCaoDto.getNome())
      //.cep(atualizarCaoDto.getCep())
      .numero(atualizarCaoDto.getNumero())
      .complemento(atualizarCaoDto.getComplemento())
      .telefone(atualizarCaoDto.getTelefone())
      .nomeContatoRecado(atualizarCaoDto.getNomeContatoRecado())
      .telefoneContatoRecado(atualizarCaoDto.getTelefoneContatoRecado())
      .nomeCao(atualizarCaoDto.getNomeCao())
      .situacaoCao(atualizarCaoDto.getSituacaoCao())
      .antiparasitarioInternoData(atualizarCaoDto.getAntiparasitarioInternoData())
      .antiparasitarioExternoData(atualizarCaoDto.getAntiparasitarioExternoData())
      .trocaColeiraScaliborData(atualizarCaoDto.getTrocaColeiraScaliborData())
      .temCadernetaVacinacao(atualizarCaoDto.getTemCadernetaVacinacao())
      .ultimaVacinaNobivacDhppiL(atualizarCaoDto.getUltimaVacinaNobivacDhppiL())
      .ultimaVacinaNobivacRaiva(atualizarCaoDto.getUltimaVacinaNobivacRaiva())
      .temBlocoVeterinario(atualizarCaoDto.getTemBlocoVeterinario())
      .temCarteirinhaSocializador(atualizarCaoDto.getTemCarteirinhaSocializador())
      .build();
  }

  public static List<AtualizarCaoDto> mapToAtualizarCaoDto(List<AtualizarCao> atualizacaoCaes) {
    List<AtualizarCaoDto> atualizarCaesDto = new ArrayList<AtualizarCaoDto>();

    for(AtualizarCao atualizarCao : atualizacaoCaes) {
      atualizarCaesDto.add(
        AtualizarCaoDto.builder()
          .email(atualizarCao.getEmail())
          .nome(atualizarCao.getNome())
          //.cep(atualizarCao.getCep())
          .endereco(EnderecoDto.builder().cep(atualizarCao.getEndereco().getCep())
            .numero(atualizarCao.getNumero())
            .bairro(atualizarCao.getEndereco().getBairro())
            .cidade(atualizarCao.getEndereco().getCidade().getNome())
            .estado(atualizarCao.getEndereco().getEstado().getNome())
            .logradouro(atualizarCao.getEndereco().getLogradouro()).build())
          .numero(atualizarCao.getNumero())
          .complemento(atualizarCao.getComplemento())
          .telefone(atualizarCao.getTelefone())
          .nomeContatoRecado(atualizarCao.getNomeContatoRecado())
          .nomeCao(atualizarCao.getNomeCao())
          .telefoneContatoRecado(atualizarCao.getTelefoneContatoRecado())
          .situacaoCao(atualizarCao.getSituacaoCao())
          .antiparasitarioInternoData(atualizarCao.getAntiparasitarioInternoData())
          .antiparasitarioExternoData(atualizarCao.getAntiparasitarioExternoData())
          .trocaColeiraScaliborData(atualizarCao.getTrocaColeiraScaliborData())
          .temCadernetaVacinacao(atualizarCao.getTemCadernetaVacinacao())
          .ultimaVacinaNobivacDhppiL(atualizarCao.getUltimaVacinaNobivacDhppiL())
          .ultimaVacinaNobivacRaiva(atualizarCao.getUltimaVacinaNobivacRaiva())
          .temBlocoVeterinario(atualizarCao.getTemBlocoVeterinario())
          .temCarteirinhaSocializador(atualizarCao.getTemCarteirinhaSocializador())
          .build()
      );
    };

    return atualizarCaesDto;
  }

  public static AtualizarCaoDto mapToAtualizarCaoDto(AtualizarCao atualizarCao) {
    AtualizarCaoDto atualizarCaoDto = AtualizarCaoDto.builder()
      .email(atualizarCao.getEmail())
      .nome(atualizarCao.getNome())
      .endereco(EnderecoDto.builder().cep(atualizarCao.getEndereco().getCep())
                                     .numero(atualizarCao.getNumero())
                                     .bairro(atualizarCao.getEndereco().getBairro())
                                     .cidade(atualizarCao.getEndereco().getCidade().getNome())
                                     .estado(atualizarCao.getEndereco().getEstado().getNome())
                                     .logradouro(atualizarCao.getEndereco().getLogradouro()).build())
      //.cep(atualizarCao.getCep())
      .numero(atualizarCao.getNumero())
      .complemento(atualizarCao.getComplemento())
      .telefone(atualizarCao.getTelefone())
      .nomeContatoRecado(atualizarCao.getNomeContatoRecado())
      .telefoneContatoRecado(atualizarCao.getTelefoneContatoRecado())
      .nomeCao(atualizarCao.getNomeCao())
      .situacaoCao(atualizarCao.getSituacaoCao())
      .antiparasitarioInternoData(atualizarCao.getAntiparasitarioInternoData())
      .antiparasitarioExternoData(atualizarCao.getAntiparasitarioExternoData())
      .trocaColeiraScaliborData(atualizarCao.getTrocaColeiraScaliborData())
      .temCadernetaVacinacao(atualizarCao.getTemCadernetaVacinacao())
      .ultimaVacinaNobivacDhppiL(atualizarCao.getUltimaVacinaNobivacDhppiL())
      .ultimaVacinaNobivacRaiva(atualizarCao.getUltimaVacinaNobivacRaiva())
      .temBlocoVeterinario(atualizarCao.getTemBlocoVeterinario())
      .temCarteirinhaSocializador(atualizarCao.getTemCarteirinhaSocializador())
      .build();

    return atualizarCaoDto;
  }

}
