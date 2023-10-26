package hkeller.escolacaesguia.voluntario.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class VoluntarioDto {
  private Long id;

  private String nome;

  private String nacionalidade;

  private String estadoCivil;

  private String funcao;

  private String identidade;

  private String rua;

  private String cidade;

  private String estado;

  private String cep;

  private String numero;

  private String email;

  private String telefone;

  private String cao;
}
