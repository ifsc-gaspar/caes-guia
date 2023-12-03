package hkeller.escolacaesguia.evento.model;

import hkeller.escolacaesguia.cao.model.Cao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "evento")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "categoria_evento", nullable = false)
    private Integer categoriaEvento;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @Column
    private boolean notificarTutor;

    @ManyToOne
    @JoinColumn(name = "id_cao")
    private Cao cao;

}
