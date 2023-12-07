package hkeller.escolacaesguia.visita.controller;

import hkeller.escolacaesguia.visita.model.Visita;
import hkeller.escolacaesguia.visita.dto.VisitaDto;
import hkeller.escolacaesguia.visita.dto.RequisicaoCadastroVisitaDto;
import hkeller.escolacaesguia.visita.services.CadastrarVisitaServico;
import hkeller.escolacaesguia.visita.services.ObterVisitaServico;
import hkeller.escolacaesguia.visita.services.ObterListaVisitasServico;
import hkeller.escolacaesguia.visita.services.VisitaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.List;

@Controller
@RequestMapping("/visitas")
public class VisitaController {
    private final VisitaService visitaService;
    @Autowired
    public VisitaController(VisitaService visitaService) {
    this.visitaService = visitaService;
  }

  @Autowired
  CadastrarVisitaServico visitaServico;

  @Autowired
  ObterListaVisitasServico obterListaVisitasServico;

  @Autowired
  ObterVisitaServico obterVisitaServico;

  @GetMapping()
  public String listVisitas(Model model) {
//    List<Visita> visitas = visitaService.getAllVisitas();
    List<Visita> visitas = obterListaVisitasServico.getAllVisitas();
    model.addAttribute("visitas", visitas);
    return "visita/listagem";
  }

  @GetMapping("/cadastro")
  public String cadastroVisita(Model model) {
    RequisicaoCadastroVisitaDto visitas = new RequisicaoCadastroVisitaDto();
    model.addAttribute("visitas", visitas);

    Visita visita = new Visita();
    model.addAttribute("visita", visita);
    return "visita/cadastro";
  }

  @PostMapping("/cadastro")
//  public String saveVisita(@ModelAttribute("visita") Visita visita) {
//    visitaService.save(visita);
//    return "redirect:/visitas";
//  }
  public String post(@Valid @ModelAttribute("visita") RequisicaoCadastroVisitaDto visita, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("visita", visita);
      return "visita/cadastro";
    }

    visitaServico.executar(visita);

    return "redirect:/visitas";
  }

  @GetMapping("{id}/editar")
  public String editarVisita(@PathVariable Long id, Model model) {
    Visita visita = visitaService.getVisitaById(id);
    model.addAttribute("visita", visita);
    return "visita/editar";
  }

//  @GetMapping("{id}/visualizar")
//  public String visualizarVisita(@PathVariable Long id, Model model) {
//    Visita visita = visitaService.getVisitaById(id);
//    model.addAttribute("visita", visita);
//    return "visita/visualizar";
//  }
  @GetMapping("{id}/visualizar")
  public String visualizar(@PathVariable("id") Long id, Model model) {
    VisitaDto visitaDto = obterVisitaServico.execute(id);

    model.addAttribute("visita", visitaDto);

    return "visita/visualizar";
  }
}
