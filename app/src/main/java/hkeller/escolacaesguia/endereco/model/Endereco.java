package hkeller.escolacaesguia.endereco.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {
  @Id
  private int cep;

  @Column(nullable = false)
  private String logradouro;

  private String numero;

  @Column(nullable = false)
  private String bairro;

  @ManyToOne
  @JoinColumn(name = "id_cidade")
  private Cidade cidade;

  @ManyToOne
  @JoinColumn(name = "id_estado")
  private Estado estado;
}
