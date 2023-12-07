package hkeller.escolacaesguia.endereco.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "estado")
@Data
public class Estado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String sigla;
}
