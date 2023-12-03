package hkeller.escolacaesguia.vacina.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VacinaDto {

  private Long id;

  @JsonProperty("NomeVacina")
  private String nomeVacina;

  @JsonProperty("TipoVacina")
  private String tipoVacina;

  @JsonProperty("NumerodeDose")
  private Integer numerodeDose;  // Alteração aqui

  @JsonProperty("PeriodoAdministracao")
  private String periodoAdministracao;

  @JsonProperty("Observacoes")
  private String observacoes;

  @JsonProperty("FaixaEtaria")
  private String faixaEtaria;

  @JsonProperty("Obrigatoriedade")
  private Boolean obrigatoriedade;  // Alteração aqui

  @JsonProperty("AcompanhamentoVeterinario")
  private Boolean acompanhamentoVeterinario;  // Alteração aqui

  @JsonProperty("PeriodoDeVermifugacao")
  private String periodoDeVermifugacao;
}
