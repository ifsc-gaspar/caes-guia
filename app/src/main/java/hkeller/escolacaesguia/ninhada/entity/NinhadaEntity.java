package hkeller.escolacaesguia.ninhada.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "ninhada")
@Setter
@Getter
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
    @NotNull
    @ElementCollection
    @Column(name = "ids_filhotes", columnDefinition = "bigint[]")
    private long[] ids_filhotes;

}
