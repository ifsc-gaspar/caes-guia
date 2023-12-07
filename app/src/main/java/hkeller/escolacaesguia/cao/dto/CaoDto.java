package hkeller.escolacaesguia.cao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CaoDto {
    private Long id;

    private String nome;

    private String cor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    private String sexo;
}
