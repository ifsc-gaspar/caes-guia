package hkeller.escolacaesguia.visita.mapper;

import hkeller.escolacaesguia.visita.dto.VisitaDto;
import hkeller.escolacaesguia.visita.dto.RequisicaoCadastroVisitaDto;
import hkeller.escolacaesguia.visita.model.Visita;
import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;

import java.util.ArrayList;
import java.util.List;

public class VisitaMapper {

  public static Visita mapToVisita(RequisicaoCadastroVisitaDto visitaDto) {
    return Visita.builder()
      .nomeEscola(visitaDto.getNomeEscola())
      .email(visitaDto.getEmail())
      .numero(visitaDto.getEndereco().getNumero())
      .telefoneEscola(visitaDto.getTelefoneEscola())
      .nomeResponsavel(visitaDto.getNomeResponsavel())
      .telefoneResponsavel(visitaDto.getTelefoneResponsavel())
      .numeroAlunos(visitaDto.getNumeroAlunos())
      .serieEscolar(visitaDto.getSerieEscolar())
      .idadeAlunos(visitaDto.getIdadeAlunos())
      .textoObjetivo(visitaDto.getTextoObjetivo())
      .simNao(visitaDto.getSimNao())
      .dataVisita(visitaDto.getDataVisita())
      .horaVisita(visitaDto.getHoraVisita())
      .informacoesExtras(visitaDto.getInformacoesExtras())
      .build();
  }

  public static Visita mapToVisita(VisitaDto visitaDto) {
    return Visita.builder()
      .nomeEscola(visitaDto.getNomeEscola())
      .email(visitaDto.getEmail())
      .telefoneEscola(visitaDto.getTelefoneEscola())
      .nomeResponsavel(visitaDto.getNomeResponsavel())
      .telefoneResponsavel(visitaDto.getTelefoneResponsavel())
      .numeroAlunos(visitaDto.getNumeroAlunos())
      .serieEscolar(visitaDto.getSerieEscolar())
      .idadeAlunos(visitaDto.getIdadeAlunos())
      .textoObjetivo(visitaDto.getTextoObjetivo())
      .simNao(visitaDto.getSimNao())
      .dataVisita(visitaDto.getDataVisita())
      .horaVisita(visitaDto.getHoraVisita())
      .informacoesExtras(visitaDto.getInformacoesExtras())
      .build();
  }

  public static List<VisitaDto> mapToVisitaDto(List<Visita> visitas) {
    List<VisitaDto> visitasDto = new ArrayList<VisitaDto>();

    for(Visita visita : visitas) {
      visitasDto.add(
        VisitaDto.builder()
          .nomeEscola(visita.getNomeEscola())
          .email(visita.getEmail())
          //.cep(visita.getCep())
          .endereco(EnderecoDto.builder().cep(visita.getEndereco().getCep())
            .numero(visita.getNumero())
            .bairro(visita.getEndereco().getBairro())
            .cidade(visita.getEndereco().getCidade().getNome())
            .estado(visita.getEndereco().getEstado().getNome())
            .logradouro(visita.getEndereco().getLogradouro()).build())
          .telefoneEscola(visita.getTelefoneEscola())
          .nomeResponsavel(visita.getNomeResponsavel())
          .telefoneResponsavel(visita.getTelefoneResponsavel())
          .numeroAlunos(visita.getNumeroAlunos())
          .serieEscolar(visita.getSerieEscolar())
          .idadeAlunos(visita.getIdadeAlunos())
          .textoObjetivo(visita.getTextoObjetivo())
          .simNao(visita.getSimNao())
          .dataVisita(visita.getDataVisita())
          .horaVisita(visita.getHoraVisita())
          .informacoesExtras(visita.getInformacoesExtras())
          .build()
      );
    };

    return visitasDto;
  }

  public static VisitaDto mapToVisitaDto(Visita visita) {
    VisitaDto visitaDto = VisitaDto.builder()
      .nomeEscola(visita.getNomeEscola())
      .email(visita.getEmail())
      .endereco(EnderecoDto.builder().cep(visita.getEndereco().getCep())
        .numero(visita.getNumero())
        .bairro(visita.getEndereco().getBairro())
        .cidade(visita.getEndereco().getCidade().getNome())
        .estado(visita.getEndereco().getEstado().getNome())
        .logradouro(visita.getEndereco().getLogradouro()).build())
      //.cep(visita.getCep())
      .telefoneEscola(visita.getTelefoneEscola())
      .nomeResponsavel(visita.getNomeResponsavel())
      .telefoneResponsavel(visita.getTelefoneResponsavel())
      .numeroAlunos(visita.getNumeroAlunos())
      .serieEscolar(visita.getSerieEscolar())
      .idadeAlunos(visita.getIdadeAlunos())
      .textoObjetivo(visita.getTextoObjetivo())
      .simNao(visita.getSimNao())
      .dataVisita(visita.getDataVisita())
      .horaVisita(visita.getHoraVisita())
      .informacoesExtras(visita.getInformacoesExtras())
      .build();

    return visitaDto;
  }

}
