package hkeller.escolacaesguia.atualizarCao.dto;

import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoCadastroAtualizarCaoDto {

  @NotEmpty(message = "Por favor informe o email")
  @Email(message = "Por favor informe um email válido")
  private String email;

  @NotEmpty(message = "Por favor informe o nome")
  private String nome;

  private int cep;

 // @NotEmpty(message = "Por favor informe o numero")
  private String numero;

 // @NotEmpty(message = "Por favor informe o complemento")
  private String complemento;

  // Nova propriedade "endereco" do tipo EnderecoDto
  private EnderecoDto endereco;

  @NotEmpty(message = "Por favor informe o telefone")
  //@Pattern(regexp="\\([0-9]{2}\\) [0-9]{4,5}-[0-9]{4}", message="Por favor informe um telefone válido")
  private String telefone;

  @NotEmpty(message = "Por favor informe o nome de contato para recados")
  private String nomeContatoRecado;

  @NotEmpty(message = "Por favor informe o telefone de contato para recados")
  //@Pattern(regexp="\\([0-9]{2}\\) [0-9]{4,5}-[0-9]{4}", message="Por favor informe um telefone de contato para recados válido")
  private String telefoneContatoRecado;

  @NotEmpty(message = "Por favor selecione o cão")
  private String nomeCao;

  @NotNull(message = "Por favor selecione a situação do cão")
  @NotEmpty(message = "Por favor selecione a situação do cão")
  private String situacaoCao;

  @NotNull(message = "Por favor informe a data do último antiparasitário interno")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiparasitarioInternoData;

  @NotNull(message = "Por favor informe a data do último antiparasitário externo")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiparasitarioExternoData;

  @NotNull(message = "Por favor informe a data da última troca de coleira Scalibor")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date trocaColeiraScaliborData;

  @NotNull(message = "Por favor selecione se possui caderneta de vacinação")
  @NotEmpty(message = "Por favor selecione se possui caderneta de vacinação")
  private String temCadernetaVacinacao;

  @NotNull(message = "Por favor informe a data da última vacina Nobivac DHPPI+L (V10)")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date ultimaVacinaNobivacDhppiL;

  @NotNull(message = "Por favor informe a data da última vacina Nobivac Raiva")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date ultimaVacinaNobivacRaiva;

  @NotNull(message = "Por favor selecione se possui bloco veterinário")
  @NotEmpty(message = "Por favor selecione se possui bloco veterinário")
  private String temBlocoVeterinario;

  @NotNull(message = "Por favor selecione se possui carteirinha de socializador")
  @NotEmpty(message = "Por favor selecione se possui carteirinha de socializador")
  private String temCarteirinhaSocializador;
}
