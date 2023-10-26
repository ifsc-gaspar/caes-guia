package hkeller.escolacaesguia.voluntario.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RequisicaoCadastroVoluntarioDto {

  @NotEmpty(message = "Por favor informe o nome")
  private String nome;

  @NotEmpty(message = "Por favor informe a nacionalidade")
  private String nacionalidade;

  @NotEmpty(message = "Por favor informe o estado civil")
  private String estadoCivil;

  @NotEmpty(message = "Por favor informe a função")
  private String funcao;

  @NotEmpty(message = "Por favor informe a identidade")
  private String identidade;

  @NotEmpty(message = "Por favor informe a rua")
  private String rua;

  @NotEmpty(message = "Por favor informe a cidade")
  private String cidade;

  @NotEmpty(message = "Por favor informe o estado")
  private String estado;

  @NotEmpty(message = "Por favor informe o CEP")
  private String cep;

  @NotEmpty(message = "Por favor informe o número")
  private String numero;

  @NotEmpty(message = "Por favor informe o email")
  private String email;

  @NotEmpty(message = "Por favor informe o telefone")
  private String telefone;

  @NotEmpty(message = "Por favor informe o nome do cão")
  private String cao;

}
