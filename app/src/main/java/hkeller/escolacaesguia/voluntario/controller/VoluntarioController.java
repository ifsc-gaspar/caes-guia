package hkeller.escolacaesguia.voluntario.controller;

import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import hkeller.escolacaesguia.voluntario.dto.RequisicaoCadastroVoluntarioDto;
import hkeller.escolacaesguia.voluntario.dto.VoluntarioDto;
import hkeller.escolacaesguia.voluntario.model.Voluntario;
import hkeller.escolacaesguia.voluntario.repository.VoluntarioRepositorio;
import hkeller.escolacaesguia.voluntario.services.CadastrarVoluntarioServico;
import hkeller.escolacaesguia.voluntario.services.DeletarVoluntarioServico;
import hkeller.escolacaesguia.voluntario.services.EditarVoluntarioServico;
import hkeller.escolacaesguia.voluntario.services.ObterVoluntarioServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voluntarios")
public class VoluntarioController {

  private final CaoRepositorio caoRepository;
  private final CadastrarVoluntarioServico cadastrarVoluntarioServico;
  private final DeletarVoluntarioServico deletarVoluntarioServico;
  private final ObterVoluntarioServico obterVoluntarioServico;
  private final EditarVoluntarioServico editarVoluntarioServico;
  private final VoluntarioRepositorio voluntarioRepositorio;

  public VoluntarioController(
    CaoRepositorio caoRepository,
    CadastrarVoluntarioServico cadastrarVoluntarioServico,
    DeletarVoluntarioServico deletarVoluntarioServico,
    ObterVoluntarioServico obterVoluntarioServico,
    EditarVoluntarioServico editarVoluntarioServico,
    VoluntarioRepositorio voluntarioRepositorio) {
    this.caoRepository = caoRepository;
    this.cadastrarVoluntarioServico = cadastrarVoluntarioServico;
    this.deletarVoluntarioServico = deletarVoluntarioServico;
    this.obterVoluntarioServico = obterVoluntarioServico;
    this.editarVoluntarioServico = editarVoluntarioServico;
    this.voluntarioRepositorio = voluntarioRepositorio;
  }

  // Envia o usuário para a tela de listagem dos voluntários
  @GetMapping
  public String findAll(Model model) {
    List<Voluntario> voluntarios = voluntarioRepositorio.findAll();
    model.addAttribute("voluntarios", voluntarios);
    return "voluntario/listagem";
  }

  // Envia o usuário para a tela de cadastro dos voluntários
  @GetMapping("/cadastro")
  public String getFormularioCadastro(Model model) {
    RequisicaoCadastroVoluntarioDto voluntario = new RequisicaoCadastroVoluntarioDto();
    model.addAttribute("voluntario", voluntario);
    model.addAttribute("caes", caoRepository.findAll());
    return "voluntario/cadastro";
  }

  // Mapeia o envio do formulário para cadastrar um novo voluntário
  @PostMapping("/cadastro")
  public String postCadastro(@ModelAttribute("voluntario") RequisicaoCadastroVoluntarioDto voluntarioDto) {
    // Validação de dados (pode usar anotações de validação)

    // Chama o serviço para cadastrar o voluntário
    cadastrarVoluntarioServico.executar(voluntarioDto);

    // Redireciona para a página de listagem de voluntários após o cadastro bem-sucedido
    return "redirect:/voluntarios";
  }

  @GetMapping("/{idVoluntario}/deletar")
  public String delete(@PathVariable("idVoluntario") Long id) {
    deletarVoluntarioServico.execute(id);
    return "redirect:/voluntarios";
  }

  @GetMapping("/{idVoluntario}/editar")
  public String formEditar(@PathVariable("idVoluntario") Long idVoluntario, Model model) {
    Voluntario voluntarioDto = obterVoluntarioServico.execute(idVoluntario);
    model.addAttribute("voluntario", voluntarioDto);
    return "voluntario/editar";
  }

  @PostMapping("/{idVoluntario}/editar")
  public String editar(@PathVariable("idVoluntario") Long idVoluntario,
                       @ModelAttribute("voluntario") VoluntarioDto voluntarioDto) {
    voluntarioDto.setId(idVoluntario);
    editarVoluntarioServico.execute(voluntarioDto);
    return "redirect:/voluntarios";
  }

  @GetMapping("/{idVoluntario}/templatePDF")
  public String visualizar(@PathVariable("idVoluntario") Long idVoluntario, Model model) {
    // Obtenha o voluntário com base no ID
    Voluntario voluntarioDto = obterVoluntarioServico.execute(idVoluntario);

    // Adicione o voluntário ao modelo para que ele possa ser acessado no template
    model.addAttribute("voluntario", voluntarioDto);

    return "voluntario/templatePDF";
  }

}
