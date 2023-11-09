package hkeller.escolacaesguia.endereco.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "cidade")
public class Cidade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String nome;

  @ManyToOne
  @JoinColumn(name = "id_estado")
  private Estado estado;

  @OneToMany(mappedBy = "cidade")
  private List<Endereco> enderecos;
}
