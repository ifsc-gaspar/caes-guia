package hkeller.escolacaesguia.cao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hkeller.escolacaesguia.ninhada.entity.NinhadaEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cao")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "id_ninhada")
    @JsonBackReference
    private NinhadaEntity ninhada;
}
