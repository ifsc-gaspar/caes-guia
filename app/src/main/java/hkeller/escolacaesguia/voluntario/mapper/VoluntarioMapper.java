package hkeller.escolacaesguia.voluntario.mapper;

import hkeller.escolacaesguia.voluntario.dto.RequisicaoCadastroVoluntarioDto;
import hkeller.escolacaesguia.voluntario.dto.VoluntarioDto;
import hkeller.escolacaesguia.voluntario.model.Voluntario;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date; // Importe Date da biblioteca correta



public class VoluntarioMapper {

  public static Voluntario mapToVoluntario(RequisicaoCadastroVoluntarioDto voluntarioDto){
    Voluntario voluntario = Voluntario.builder()
      .nome(voluntarioDto.getNome())
      .nacionalidade(voluntarioDto.getNacionalidade())
      .estadoCivil(voluntarioDto.getEstadoCivil())
      .funcao(voluntarioDto.getFuncao())
      .email(voluntarioDto.getEmail())
      .telefone(voluntarioDto.getTelefone())
      .rua(voluntarioDto.getRua())
      .numero(voluntarioDto.getNumero())
      .cidade(voluntarioDto.getCidade())
      .cep(voluntarioDto.getCep())
      .estado(voluntarioDto.getEstado())
      .identidade(voluntarioDto.getIdentidade()) // RG
      .cpf(voluntarioDto.getCpf()) // CPF
      .instagram(voluntarioDto.getInstagram())
      .facebook(voluntarioDto.getFacebook())
      .linkedin(voluntarioDto.getLinkedin())
      .formacao(voluntarioDto.getFormacao())
      .cursoFormacao(voluntarioDto.getCursoFormacao()) // Nome do curso de formação
      .statusFormacao(voluntarioDto.getStatusFormacao())
      .experienciasProfissionais(voluntarioDto.getExperienciasProfissionais())
      .experienciasVoluntariado(voluntarioDto.getExperienciasVoluntariado())
      .tempoDisponivel(voluntarioDto.getTempoDisponivel())
      .dataInicio(voluntarioDto.getDataInicio())
      .dataFim(voluntarioDto.getDataFim())
      .atividadesRealizar(voluntarioDto.getAtividadesRealizar())
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
      .email(voluntarioDto.getEmail())
      .telefone(voluntarioDto.getTelefone())
      .rua(voluntarioDto.getRua())
      .numero(voluntarioDto.getNumero())
      .cidade(voluntarioDto.getCidade())
      .cep(voluntarioDto.getCep())
      .estado(voluntarioDto.getEstado())
      .identidade(voluntarioDto.getIdentidade()) // RG
      .cpf(voluntarioDto.getCpf()) // CPF
      .instagram(voluntarioDto.getInstagram())
      .facebook(voluntarioDto.getFacebook())
      .linkedin(voluntarioDto.getLinkedin())
      .formacao(voluntarioDto.getFormacao())
      .cursoFormacao(voluntarioDto.getCursoFormacao()) // Nome do curso de formação
      .statusFormacao(voluntarioDto.getStatusFormacao())
      .experienciasProfissionais(voluntarioDto.getExperienciasProfissionais())
      .experienciasVoluntariado(voluntarioDto.getExperienciasVoluntariado())
      .tempoDisponivel(voluntarioDto.getTempoDisponivel())
      .dataInicio(voluntarioDto.getDataInicio())
      .dataFim(voluntarioDto.getDataFim())
      .atividadesRealizar(voluntarioDto.getAtividadesRealizar())
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
          .caoid(voluntario.getCaoid())
          .nome(voluntario.getNome())
          .nacionalidade(voluntario.getNacionalidade())
          .estadoCivil(voluntario.getEstadoCivil())
          .funcao(voluntario.getFuncao())
          .email(voluntario.getEmail())
          .telefone(voluntario.getTelefone())
          .rua(voluntario.getRua())
          .numero(voluntario.getNumero())
          .cidade(voluntario.getCidade())
          .cep(voluntario.getCep())
          .estado(voluntario.getEstado())
          .identidade(voluntario.getIdentidade()) // RG
          .cpf(voluntario.getCpf()) // CPF
          .instagram(voluntario.getInstagram())
          .facebook(voluntario.getFacebook())
          .linkedin(voluntario.getLinkedin())
          .formacao(voluntario.getFormacao())
          .cursoFormacao(voluntario.getCursoFormacao()) // Nome do curso de formação
          .statusFormacao(voluntario.getStatusFormacao())
          .experienciasProfissionais(voluntario.getExperienciasProfissionais())
          .experienciasVoluntariado(voluntario.getExperienciasVoluntariado())
          .tempoDisponivel(voluntario.getTempoDisponivel())
          .dataInicio(voluntario.getDataInicio())
          .dataFim(voluntario.getDataFim())
          .atividadesRealizar(voluntario.getAtividadesRealizar())
          .cao(voluntario.getCao())
          .build()
      );
    }

    return voluntariosDto;
  }

  public static VoluntarioDto mapToVoluntarioDto(Voluntario voluntario) {
    VoluntarioDto voluntarioDto = VoluntarioDto.builder()
      .id(voluntario.getId())
      .caoid(voluntario.getCaoid())
      .nome(voluntario.getNome())
      .nacionalidade(voluntario.getNacionalidade())
      .estadoCivil(voluntario.getEstadoCivil())
      .funcao(voluntario.getFuncao())
      .email(voluntario.getEmail())
      .telefone(voluntario.getTelefone())
      .rua(voluntario.getRua())
      .numero(voluntario.getNumero())
      .cidade(voluntario.getCidade())
      .cep(voluntario.getCep())
      .estado(voluntario.getEstado())
      .identidade(voluntario.getIdentidade()) // RG
      .cpf(voluntario.getCpf()) // CPF
      .instagram(voluntario.getInstagram())
      .facebook(voluntario.getFacebook())
      .linkedin(voluntario.getLinkedin())
      .formacao(voluntario.getFormacao())
      .cursoFormacao(voluntario.getCursoFormacao()) // Nome do curso de formação
      .statusFormacao(voluntario.getStatusFormacao())
      .experienciasProfissionais(voluntario.getExperienciasProfissionais())
      .experienciasVoluntariado(voluntario.getExperienciasVoluntariado())
      .tempoDisponivel(voluntario.getTempoDisponivel())
      .dataInicio(voluntario.getDataInicio())
      .dataFim(voluntario.getDataFim())
      .atividadesRealizar(voluntario.getAtividadesRealizar())
      .cao(voluntario.getCao())
      .build();

    return voluntarioDto;
  }
}
