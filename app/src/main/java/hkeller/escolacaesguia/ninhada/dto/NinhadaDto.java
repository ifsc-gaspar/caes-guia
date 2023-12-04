package hkeller.escolacaesguia.ninhada.dto;

import hkeller.escolacaesguia.cao.dto.RequisicaoCadastroCaoDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class NinhadaDto {
    private Long id_mae;
    private Long id_pai;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private List<RequisicaoCadastroCaoDto> filhotes;
}
