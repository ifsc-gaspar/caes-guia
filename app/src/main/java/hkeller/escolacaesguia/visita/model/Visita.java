package hkeller.escolacaesguia.visita.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import hkeller.escolacaesguia.endereco.model.Endereco;

@Entity
@Table(name = "visita")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Visita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome_escola", nullable = false)
  private String nomeEscola;

  @Column(nullable = false)
  private String email;

//  @Column(name = "cep")
//  private Integer cep;
//
//  @Column(nullable = false)
//  private String logradouro;
//
  @Column(nullable = false)
  private String numero;
//
//  @Column(nullable = false)
//  private String bairro;
//
//  @Column(nullable = false)
//  private String cidade;
//
//  @Column(nullable = false)
//  private String estado;

  @ManyToOne
  @JoinColumn(name = "cep")   // Adicione isso para indicar a coluna de junção
  private Endereco endereco;  // Assumindo que Endereco seja a classe correta para representar informações de endereço

  @Column(name = "telefone_escola")
  private Long telefoneEscola;

  @Column(name = "nome_responsavel", nullable = false)
  private String nomeResponsavel;

  @Column(name = "telefone_responsavel")
  private Long telefoneResponsavel;

  @Column(name = "numero_alunos")
  private Integer numeroAlunos;

  @Column(name = "serie_escolar", nullable = false)
  private String serieEscolar;

  @Column(name = "idade_alunos")
  private Integer idadeAlunos;

  @Column(name = "texto_objetivo", nullable = false)
  private String textoObjetivo;

  @Column(name = "sim_nao")
  private Integer simNao;

  @Column(name = "data_visita")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dataVisita;

  @Column(name = "hora_visita")
  private Integer horaVisita;

  @Column(name = "informacoes_extras", nullable = false)
  private String informacoesExtras;

}
