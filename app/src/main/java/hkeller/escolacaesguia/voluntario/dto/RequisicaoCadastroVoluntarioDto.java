package hkeller.escolacaesguia.voluntario.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RequisicaoCadastroVoluntarioDto {

  @NotEmpty(message = "Por favor, informe o nome")
  private String nome;

  @NotEmpty(message = "Por favor, informe a nacionalidade")
  private String nacionalidade;

  @NotEmpty(message = "Por favor, informe o estado civil")
  private String estadoCivil;

  @NotEmpty(message = "Por favor, informe a função")
  private String funcao;

  @NotEmpty(message = "Por favor, informe o email")
  @Email(message = "O email fornecido não é válido")
  private String email;

  @NotEmpty(message = "Por favor, informe o telefone")
  @Size(min = 10, max = 20, message = "O telefone deve ter entre 10 e 20 caracteres")
  private String telefone;

  @NotEmpty(message = "Por favor, informe a rua")
  private String rua;

  @NotEmpty(message = "Por favor, informe o número")
  private String numero;

  @NotEmpty(message = "Por favor, informe a cidade")
  private String cidade;

  @NotEmpty(message = "Por favor, informe o CEP")
  private String cep;

  @NotEmpty(message = "Por favor, informe o estado")
  private String estado;

  @NotEmpty(message = "Por favor, informe o RG")
  private String identidade;

  @NotEmpty(message = "Por favor, informe o CPF")
  private String cpf;

  @NotEmpty(message = "Por favor, informe o Instagram")
  private String instagram;

  @NotEmpty(message = "Por favor, informe o Facebook")
  private String facebook;

  @NotEmpty(message = "Por favor, informe o LinkedIn")
  private String linkedin;

  @NotEmpty(message = "Por favor, informe a formação")
  private String formacao;

  @NotEmpty(message = "Por favor, informe o curso de formação")
  private String cursoFormacao;

  @NotEmpty(message = "Por favor, informe o status de formação")
  private String statusFormacao;

  @NotEmpty(message = "Por favor, informe as experiências profissionais")
  private String experienciasProfissionais;

  @NotEmpty(message = "Por favor, informe as experiências de voluntariado")
  private String experienciasVoluntariado;

  @NotEmpty(message = "Por favor, informe o tempo de disponibilidade")
  private String tempoDisponivel;

  @NotNull(message = "Por favor, informe a data de início")
  private Date dataInicio;

  @NotNull(message = "Por favor, informe a data de fim")
  private Date dataFim;

  @NotEmpty(message = "Por favor, informe as atividades a serem realizadas")
  private String atividadesRealizar;

  @NotEmpty(message = "Por favor, selecione o nome do cão")
  private String cao;

  //aqui

  //private int caoId;

}
