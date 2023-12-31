package hkeller.escolacaesguia.endereco.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
  private Integer cep;
  private String logradouro;
  private String numero;
  private String bairro;
  private String cidade;
  private String estado;
}
