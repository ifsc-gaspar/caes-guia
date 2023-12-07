package hkeller.escolacaesguia.visita.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoCadastroVisitaDto {
    @NotEmpty(message = "Por favor, preencha o campo Nome da Escola.")
    private String nomeEscola;

    @NotEmpty(message = "Por favor, preencha o campo E-mail.")
    @Email(message = "Por favor, forneça um endereço de e-mail válido.")
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
//    private String numero;
//
//    @NotEmpty(message = "Por favor, preencha o campo Cidade.")
//    private String cidade;
//
//    @NotEmpty(message = "Por favor, preencha o campo Estado.")
//    private String estado;

    // Nova propriedade "endereco" do tipo EnderecoDto
    private EnderecoDto endereco;

    @NotNull(message = "Por favor, preencha o campo Telefone da Escola.")
    private Long telefoneEscola;

    @NotEmpty(message = "Por favor, preencha o campo Nome do(a) professor(a) responsável pela visita.")
    private String nomeResponsavel;

    @NotNull(message = "Por favor, preencha o campo Telefone (whats) do(a) professor(a).")
    private Long telefoneResponsavel;

    @NotNull(message = "Por favor, preencha o campo Número aproximado de alunos.")
    private Integer numeroAlunos;

    @NotEmpty(message = "Por favor, preencha o campo Classe escolar/série.")
    private String serieEscolar;

    @NotNull(message = "Por favor, preencha o campo Idade média dos alunos.")
    private Integer idadeAlunos;

    @NotEmpty(message = "Por favor, preencha o campo Objetivo da escola ao receber a visita da Escola HKeller.")
    private String textoObjetivo;

    @NotNull(message = "Por favor, escolha uma opção para a pergunta.")
    private Integer simNao;

    @NotNull(message = "Por favor, preencha o campo Data sugerida para a visita.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVisita;

    @NotNull(message = "Por favor, preencha o campo Horário sugerido para a visita.")
    private Integer horaVisita;

    @NotEmpty(message = "Por favor, preencha o campo Informacoes Extras.")
    private String informacoesExtras;
}

