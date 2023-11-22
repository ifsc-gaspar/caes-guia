package hkeller.escolacaesguia.vacina.mapper;

import hkeller.escolacaesguia.vacina.dto.RequisicaoCadastroVacinaDto;
import hkeller.escolacaesguia.vacina.dto.VacinaDto;
import hkeller.escolacaesguia.vacina.model.Vacina;

import java.util.ArrayList;
import java.util.List;

public class VacinaMapper {

  public static Vacina mapToVacina(RequisicaoCadastroVacinaDto vacinaDto) {
    Vacina vacina = Vacina.builder()
      .nomeVacina(vacinaDto.getNomeVacina())
      .tipoVacina(vacinaDto.getTipoVacina())
      .numerodeDose(vacinaDto.getNumerodeDose())
      .periodoAdministracao(vacinaDto.getPeriodoAdministracao())
      .observacoes(vacinaDto.getObservacoes())
      .faixaEtaria(vacinaDto.getFaixaEtaria())
      .obrigatoriedade(vacinaDto.getObrigatoriedade())
      .acompanhamentoVeterinario(vacinaDto.getAcompanhamentoVeterinario())
      .periodoDeVermifugacao(vacinaDto.getPeriodoDeVermifugacao())
      .build();

    return vacina;
  }

  public static Vacina mapToVacina(VacinaDto vacinaDto) {
    if (vacinaDto == null) {
      // Trate o caso em que vacinaDto é nulo, talvez lançando uma exceção ou retornando um valor padrão.
    }

    Vacina vacina = Vacina.builder()
      .id((vacinaDto != null) ? vacinaDto.getId() : null)
      .nomeVacina((vacinaDto != null) ? vacinaDto.getNomeVacina() : null)
      .tipoVacina((vacinaDto != null) ? vacinaDto.getTipoVacina() : null)
      .numerodeDose((vacinaDto != null) ? vacinaDto.getNumerodeDose() : null)
      .periodoAdministracao((vacinaDto != null) ? vacinaDto.getPeriodoAdministracao() : null)
      .observacoes((vacinaDto != null) ? vacinaDto.getObservacoes() : null)
      .faixaEtaria((vacinaDto != null) ? vacinaDto.getFaixaEtaria() : null)
      .obrigatoriedade((vacinaDto != null) ? vacinaDto.getObrigatoriedade() : null)
      .acompanhamentoVeterinario((vacinaDto != null) ? vacinaDto.getAcompanhamentoVeterinario() : null)
      .periodoDeVermifugacao((vacinaDto != null) ? vacinaDto.getPeriodoDeVermifugacao() : null)
      .build();

    return vacina;
  }
  public static List<VacinaDto> mapToVacinaDto(List<Vacina> vacinas) {
    List<VacinaDto> vacinasDto = new ArrayList<>();

    for (Vacina vacina : vacinas) {
      vacinasDto.add(
        VacinaDto.builder()
          .id(vacina.getId())
          .nomeVacina(vacina.getNomeVacina())
          .tipoVacina(vacina.getTipoVacina())
          .numerodeDose(vacina.getNumerodeDose())
          .periodoAdministracao(vacina.getPeriodoAdministracao())
          .observacoes(vacina.getObservacoes())
          .faixaEtaria(vacina.getFaixaEtaria())
          .obrigatoriedade(vacina.getObrigatoriedade())
          .acompanhamentoVeterinario(vacina.getAcompanhamentoVeterinario())
          .periodoDeVermifugacao(vacina.getPeriodoDeVermifugacao())
          .build()
      );
    }

    return vacinasDto;
  }

  public static VacinaDto mapToVacinaDto(Vacina vacina) {
    VacinaDto vacinaDto = VacinaDto.builder()
      .id(vacina.getId())
      .nomeVacina(vacina.getNomeVacina())
      .tipoVacina(vacina.getTipoVacina())
      .numerodeDose(vacina.getNumerodeDose())
      .periodoAdministracao(vacina.getPeriodoAdministracao())
      .observacoes(vacina.getObservacoes())
      .faixaEtaria(vacina.getFaixaEtaria())
      .obrigatoriedade(vacina.getObrigatoriedade())
      .acompanhamentoVeterinario(vacina.getAcompanhamentoVeterinario())
      .periodoDeVermifugacao(vacina.getPeriodoDeVermifugacao())
      .build();

    return vacinaDto;
  }
}
