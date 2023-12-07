package hkeller.escolacaesguia.atualizarCao.dto;

import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class AtualizarCaoDto {

  private Long id;

  private String email;

  private String nome;

  private int cep;

  private String numero;

  private String complemento;

  // Nova propriedade "endereco" do tipo EnderecoDto
  private EnderecoDto endereco;

  private String telefone;

  private String nomeContatoRecado;

  private String telefoneContatoRecado;

  private String nomeCao;

  private String situacaoCao;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiparasitarioInternoData;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiparasitarioExternoData;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date trocaColeiraScaliborData;

  private String temCadernetaVacinacao;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date ultimaVacinaNobivacDhppiL;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date ultimaVacinaNobivacRaiva;

  private String temBlocoVeterinario;

  private String temCarteirinhaSocializador;
}
