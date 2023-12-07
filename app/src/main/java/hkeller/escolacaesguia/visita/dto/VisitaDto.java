package hkeller.escolacaesguia.visita.dto;

import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
@Builder
public class VisitaDto {
  private String nomeEscola;

  private String email;

//    @NotEmpty(message = "Por favor, preencha o campo CEP.")
//    private String cep;
//
//    @NotEmpty(message = "Por favor, preencha o campo Logradouro.")
//    private String logradouro;
//
//    @NotEmpty(message = "Por favor, preencha o campo Bairro.")
//    private String bairro;
//
//    @NotEmpty(message = "Por favor, preencha o campo Numero.")
    private String numero;
//
//    @NotEmpty(message = "Por favor, preencha o campo Cidade.")
//    private String cidade;
//
//    @NotEmpty(message = "Por favor, preencha o campo Estado.")
//    private String estado;

  // Nova propriedade "endereco" do tipo EnderecoDto
  private EnderecoDto endereco;

  private Long telefoneEscola;

  private String nomeResponsavel;

  private Long telefoneResponsavel;

  private Integer numeroAlunos;

  private String serieEscolar;

  private Integer idadeAlunos;

  private String textoObjetivo;

  private Integer simNao;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dataVisita;

  private Integer horaVisita;

  private String informacoesExtras;

}
