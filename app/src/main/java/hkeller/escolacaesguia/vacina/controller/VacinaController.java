package hkeller.escolacaesguia.vacina.controller;


import hkeller.escolacaesguia.vacina.dto.RequisicaoCadastroVacinaDto;
import hkeller.escolacaesguia.vacina.dto.VacinaDto;
import hkeller.escolacaesguia.vacina.model.Vacina;
import hkeller.escolacaesguia.vacina.repository.VacinaRepositorio;
import hkeller.escolacaesguia.vacina.services.CadastrarVacinaServico;
import hkeller.escolacaesguia.vacina.services.DeletarVacinaServico;
import hkeller.escolacaesguia.vacina.services.EditarVacinaServico;
import hkeller.escolacaesguia.vacina.services.ObterVacinaServico;
import hkeller.escolacaesguia.voluntario.model.Voluntario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vacinas")
public class VacinaController {

  private final CadastrarVacinaServico cadastrarVacinaServico;
  private final DeletarVacinaServico deletarVacinaServico;
  private final ObterVacinaServico obterVacinaServico;
  private final EditarVacinaServico editarVacinaServico;
  private final VacinaRepositorio vacinaRepositorio;

  public VacinaController(
    CadastrarVacinaServico cadastrarVacinaServico,
    DeletarVacinaServico deletarVacinaServico,
    ObterVacinaServico obterVacinaServico,
    EditarVacinaServico editarVacinaServico,
    VacinaRepositorio vacinaRepositorio) {
    this.cadastrarVacinaServico = cadastrarVacinaServico;
    this.deletarVacinaServico = deletarVacinaServico;
    this.obterVacinaServico = obterVacinaServico;
    this.editarVacinaServico = editarVacinaServico;
    this.vacinaRepositorio = vacinaRepositorio;
  }

  @GetMapping
  public String findAll(Model model) {
    List<Vacina> vacinas = vacinaRepositorio.findAll();
    model.addAttribute("vacinas", vacinas);
    return "vacina/listagem";
  }



//@GetMapping("/cadastro")
//public String getFormularioCadastro(org.springframework.ui.Model model){
//    RequisicaoCadastroVacinaDto vacina = new RequisicaoCadastroVacinaDto();
//    model.addAttribute("vacina", vacina);
//    return "vacina/cadastro";
//}
//
//
//  @PostMapping("/cadastro")
//  public String postCadastro(@Valid @ModelAttribute("vacina") RequisicaoCadastroVacinaDto vacinaDto, BindingResult result) {
//    if (result.hasErrors()) {
//      return "vacina/cadastro";
//    }
//
//    cadastrarVacinaServico.executar(vacinaDto);
//
//    return "redirect:/vacinas";
//  }


  @GetMapping("/cadastro")
  public String getFormularioCadastro(org.springframework.ui.Model model) {
    RequisicaoCadastroVacinaDto vacina = new RequisicaoCadastroVacinaDto();
    model.addAttribute("vacina", vacina);
    return "vacina/cadastro";
  }

  @PostMapping("/cadastro")
  public String postCadastro(@Valid @ModelAttribute("vacina") RequisicaoCadastroVacinaDto vacinaDto, BindingResult result) {
    if (result.hasErrors()) {
      return "vacina/cadastro";
    }

    // Agora você precisa fornecer os valores necessários ao criar uma instância de RequisicaoCadastroVacinaDto
    RequisicaoCadastroVacinaDto vacina = new RequisicaoCadastroVacinaDto(
      vacinaDto.getNomeVacina(),
      vacinaDto.getTipoVacina(),
      vacinaDto.getNumerodeDose(),
      vacinaDto.getPeriodoAdministracao(),
      vacinaDto.getObservacoes(),
      vacinaDto.getFaixaEtaria(),
      vacinaDto.getObrigatoriedade(),
      vacinaDto.getAcompanhamentoVeterinario(),
      vacinaDto.getPeriodoDeVermifugacao()
    );

    cadastrarVacinaServico.executar(vacina);

    return "redirect:/vacinas";
  }




  @GetMapping("/{idVacina}/excluir")
  public String delete(@PathVariable("idVacina") Long id) {
    deletarVacinaServico.execute(id);
    return "redirect:/vacinas";
  }









  @GetMapping("/{idVacina}/editar")
  public String formEditar(@PathVariable("idVacina") Long idVacina, org.springframework.ui.Model model){
    Vacina vacinaDto = obterVacinaServico.execute(idVacina);
    model.addAttribute("vacina", vacinaDto);
    return "vacina/editar";
  }



  @PostMapping("/{idVacina}/editar")
  public String editar(@PathVariable("idVacina") Long idVacina,
                       @ModelAttribute("vacina") VacinaDto vacinaDto) {
    vacinaDto.setId(idVacina);
    editarVacinaServico.execute(vacinaDto);
    return "redirect:/vacinas";
  }
}
