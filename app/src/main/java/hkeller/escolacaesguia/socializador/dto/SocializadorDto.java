package hkeller.escolacaesguia.socializador.dto;

import hkeller.escolacaesguia.common.enums.EstadoCivilEnum;
import hkeller.escolacaesguia.common.enums.GrauInstrucaoEnum;
import hkeller.escolacaesguia.pessoa.PessoaDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocializadorDto {
  private String email;
  private String rg;
  private String orgaoEmissor;
  private String endereco;
  private EstadoCivilEnum grauInstrucao;
  private String profissao;
  private String localTrabalho;
  private boolean estuda;
  private String localEstudo;
  private GrauInstrucaoEnum estadoCivil;
  private PessoaDto pessoa;

}
