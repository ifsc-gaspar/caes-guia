package hkeller.escolacaesguia.ninhada.entity;

import hkeller.escolacaesguia.cao.model.Cao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "ninhada")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NinhadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long id_mae;
    @NotNull
    private Long id_pai;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ninhada")
    private List<Cao> filhotes;
}
