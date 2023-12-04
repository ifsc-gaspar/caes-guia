package hkeller.escolacaesguia.vacina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "vacina")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Vacina implements Serializable {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long idVacina;
//
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nomeVacina;


  @Column(nullable = false, length = 255)
  private String tipoVacina;

  @Column
  private Integer numerodeDose;  // Alteração aqui

  @Column(length = 100)
  private String periodoAdministracao;

  @Column(columnDefinition = "TEXT")
  private String observacoes;

  @Column(length = 20)
  private String faixaEtaria;

  @Column
  private Boolean obrigatoriedade;  // Alteração aqui

  @Column
  private Boolean acompanhamentoVeterinario;  // Alteração aqui

  @Column(length = 100)
  private String periodoDeVermifugacao;
}
