package hkeller.escolacaesguia.voluntario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "voluntario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity // Adicione a anotação @Entity
public class Voluntario implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String nacionalidade;

  @Column(nullable = false)
  private String estadoCivil;

  @Column(nullable = false)
  private String funcao;

  @Column(nullable = false)
  private String identidade;

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

  @Column(nullable = false, length = 255)
  private String email;

  @Column(nullable = false, length = 20)
  private String telefone;

  @Column(nullable = false, length = 20)
  private String cao;
}
