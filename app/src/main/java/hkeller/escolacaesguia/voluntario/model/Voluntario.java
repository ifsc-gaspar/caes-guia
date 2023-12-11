package hkeller.escolacaesguia.voluntario.model;

import hkeller.escolacaesguia.cao.model.Cao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Table(name = "voluntario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity // Adicione a anotação @Entity
public class Voluntario implements Serializable {

//  @ManyToOne
//  @JoinColumn(name = "cao_id") // Nome da coluna de chave estrangeira no banco de dados
//  private Cao cao_id;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "cao_id")
  private String Caoid;

  @Column(nullable = false, length = 255)
  private String nome;

  @Column(nullable = false, length = 255)
  private String nacionalidade;

  @Column(nullable = false, length = 255)
  private String estadoCivil;

  @Column(nullable = false, length = 255)
  private String funcao;

  @Column(nullable = false, length = 20)
  private String identidade; // RG

  @Column(length = 20)
  private String cpf;

  @Column(length = 255)
  private String instagram;

  @Column(length = 255)
  private String facebook;

  @Column(length = 255)
  private String linkedin;

  @Column(length = 255)
  private String formacao;

  @Column(length = 255)
  private String cursoFormacao; // Nome do curso de formação

  @Column(length = 255)
  private String statusFormacao;

  @Column(columnDefinition = "TEXT")
  private String experienciasProfissionais;

  @Column(columnDefinition = "TEXT")
  private String experienciasVoluntariado;

  @Column(length = 255)
  private String tempoDisponivel;

  @Temporal(TemporalType.DATE)
  private Date dataInicio;

  @Temporal(TemporalType.DATE)
  private Date dataFim;

  @Column(columnDefinition = "TEXT")
  private String atividadesRealizar;

  @Column(nullable = false, length = 20)
  private String email;

  @Column(nullable = false, length = 20)
  private String telefone;

  @Column(nullable = false, length = 20)
  private String cao;

  @Column(nullable = false)
  private String rua;

  @Column(nullable = false)
  private String cidade;

  @Column(nullable = false)
  private String estado;

  @Column(nullable = false, length = 20)
  private String cep;

  @Column(nullable = false, length = 20)
  private String numero;



}



