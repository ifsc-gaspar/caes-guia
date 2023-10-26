package hkeller.escolacaesguia.voluntario.mapper;

import hkeller.escolacaesguia.voluntario.dto.RequisicaoCadastroVoluntarioDto;
import hkeller.escolacaesguia.voluntario.dto.VoluntarioDto;
import hkeller.escolacaesguia.voluntario.model.Voluntario;

import java.util.ArrayList;
import java.util.List;


public class VoluntarioMapper {

  public static Voluntario mapToVoluntario(RequisicaoCadastroVoluntarioDto voluntarioDto){
    Voluntario voluntario = Voluntario.builder()
      .nome(voluntarioDto.getNome())
      .nacionalidade(voluntarioDto.getNacionalidade())
      .estadoCivil(voluntarioDto.getEstadoCivil())
      .funcao(voluntarioDto.getFuncao())
      .identidade(voluntarioDto.getIdentidade())
      .rua(voluntarioDto.getRua())
      .cidade(voluntarioDto.getCidade())
      .estado(voluntarioDto.getEstado())
      .cep(voluntarioDto.getCep())
      .numero(voluntarioDto.getNumero())
      .email(voluntarioDto.getEmail())
      .telefone(voluntarioDto.getTelefone())
      .cao(voluntarioDto.getCao())
      .build();

    return voluntario;
  }
  public static Voluntario mapToVoluntario(VoluntarioDto voluntarioDto) {
    Voluntario voluntario = Voluntario.builder()
      .id(voluntarioDto.getId())
      .nome(voluntarioDto.getNome())
      .nacionalidade(voluntarioDto.getNacionalidade())
      .estadoCivil(voluntarioDto.getEstadoCivil())
      .funcao(voluntarioDto.getFuncao())
      .identidade(voluntarioDto.getIdentidade())
      .rua(voluntarioDto.getRua())
      .cidade(voluntarioDto.getCidade())
      .estado(voluntarioDto.getEstado())
      .cep(voluntarioDto.getCep())
      .numero(voluntarioDto.getNumero())
      .email(voluntarioDto.getEmail())
      .telefone(voluntarioDto.getTelefone())
      .cao(voluntarioDto.getCao())
      .build();

    return voluntario;
  }

  public static List<VoluntarioDto> mapToVoluntarioDto(List<Voluntario> voluntarios) {
    List<VoluntarioDto> voluntariosDto = new ArrayList<>();

    for (Voluntario voluntario : voluntarios) {
      voluntariosDto.add(
        VoluntarioDto.builder()
          .id(voluntario.getId())
          .nome(voluntario.getNome())
          .nacionalidade(voluntario.getNacionalidade())
          .estadoCivil(voluntario.getEstadoCivil())
          .funcao(voluntario.getFuncao())
          .identidade(voluntario.getIdentidade())
          .rua(voluntario.getRua())
          .cidade(voluntario.getCidade())
          .estado(voluntario.getEstado())
          .cep(voluntario.getCep())
          .numero(voluntario.getNumero())
          .email(voluntario.getEmail())
          .telefone(voluntario.getTelefone())
          .cao(voluntario.getCao())
          .build()
      );
    }

    return voluntariosDto;
  }

  public static VoluntarioDto mapToVoluntarioDto(Voluntario voluntario) {
    VoluntarioDto voluntarioDto = VoluntarioDto.builder()
      .id(voluntario.getId())
      .nome(voluntario.getNome())
      .nacionalidade(voluntario.getNacionalidade())
      .estadoCivil(voluntario.getEstadoCivil())
      .funcao(voluntario.getFuncao())
      .identidade(voluntario.getIdentidade())
      .rua(voluntario.getRua())
      .cidade(voluntario.getCidade())
      .estado(voluntario.getEstado())
      .cep(voluntario.getCep())
      .numero(voluntario.getNumero())
      .email(voluntario.getEmail())
      .telefone(voluntario.getTelefone())
      .cao(voluntario.getCao())
      .build();

    return voluntarioDto;
  }
}
