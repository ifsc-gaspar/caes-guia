package hkeller.escolacaesguia.socializador.entity;

import hkeller.escolacaesguia.common.enums.EstadoCivilEnum;
import hkeller.escolacaesguia.common.enums.GrauInstrucaoEnum;
import hkeller.escolacaesguia.endereco.model.Endereco;
import hkeller.escolacaesguia.pessoa.PessoaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "socializador")
public class SocializadorEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String rg;

  @Column(name = "orgao_emissor", nullable = false)
  private String orgaoEmissor;

  @ManyToOne
  @JoinColumn(name = "cep")
  private Endereco endereco;

  @Enumerated(EnumType.STRING)
  @Column(name = "grau_instrucao")
  private GrauInstrucaoEnum grauInstrucao;

  private String profissao;

  @Column(name = "local_trabalho")
  private String localTrabalho;

  private boolean estuda;

  @Column(name = "local_estudo")
  private String localEstudo;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_civil")
  private EstadoCivilEnum estadoCivil;

  @OneToOne(optional = false, orphanRemoval = true, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_pessoa", nullable = false)
  private PessoaEntity pessoaEntity;

}
