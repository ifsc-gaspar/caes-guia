package hkeller.escolacaesguia.vacina.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class RequisicaoCadastroVacinaDto {

  @NotEmpty(message = "Por favor, informe o nome da vacina")
  private String nomeVacina;

  @NotEmpty(message = "Por favor, informe o tipo da vacina")
  private String tipoVacina;

  @NotNull(message = "Por favor, informe o número de doses")
  private Integer numerodeDose;

  @NotEmpty(message = "Por favor, informe o período de administração")
  private String periodoAdministracao;

  private String observacoes;

  @NotEmpty(message = "Por favor, informe a faixa etária")
  private String faixaEtaria;

  @NotNull(message = "Por favor, informe se é obrigatória")
  private Boolean obrigatoriedade;

  @NotNull(message = "Por favor, informe se requer acompanhamento veterinário")
  private Boolean acompanhamentoVeterinario;

  @NotEmpty(message = "Por favor, informe o período de vermifugação")
  private String periodoDeVermifugacao;

  // Adicione os métodos getters para os atributos
  // ...

  // Adicione o construtor com todos os argumentos
  public RequisicaoCadastroVacinaDto(
    String nomeVacina,
    String tipoVacina,
    Integer numerodeDose,
    String periodoAdministracao,
    String observacoes,
    String faixaEtaria,
    Boolean obrigatoriedade,
    Boolean acompanhamentoVeterinario,
    String periodoDeVermifugacao) {
    this.nomeVacina = nomeVacina;
    this.tipoVacina = tipoVacina;
    this.numerodeDose = numerodeDose;
    this.periodoAdministracao = periodoAdministracao;
    this.observacoes = observacoes;
    this.faixaEtaria = faixaEtaria;
    this.obrigatoriedade = obrigatoriedade;
    this.acompanhamentoVeterinario = acompanhamentoVeterinario;
    this.periodoDeVermifugacao = periodoDeVermifugacao;
  }
}
