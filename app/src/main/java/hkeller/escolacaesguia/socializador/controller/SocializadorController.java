package hkeller.escolacaesguia.socializador.controller;

import hkeller.escolacaesguia.common.enums.EstadoCivilEnum;
import hkeller.escolacaesguia.common.enums.GrauInstrucaoEnum;
import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.entity.SocializadorEntity;
import hkeller.escolacaesguia.socializador.services.SocializadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/socializador")
public class SocializadorController {

    @Autowired
    private SocializadorService socializadorService;


    @GetMapping("/cadastro")
    public String cadastrar(Model model) {
        SocializadorDto socializador = new SocializadorDto();
        model.addAttribute("enumGrauInstrucao", GrauInstrucaoEnum.values());
        model.addAttribute("enumEstadoCivil", EstadoCivilEnum.values());
        model.addAttribute("socializador", socializador);
        return "socializador/cadastro";
    }

    @GetMapping("{id}/visualizar")
    public String visualizar(Model model, @PathVariable Long id) {
        SocializadorEntity socializador = socializadorService.find(id);
        model.addAttribute("enumGrauInstrucao", GrauInstrucaoEnum.values());
        model.addAttribute("enumEstadoCivil", EstadoCivilEnum.values());
        model.addAttribute("socializador", socializador);
        return "socializador/visualizar";
    }

    @GetMapping("/listagem")
    public String listar(Model model) {
        List<SocializadorDto> socializadores = socializadorService.findAll();
        model.addAttribute("socializadores", socializadores);
        return "socializador/listagem";
    }

    @PostMapping("/salvar")
    public String salvar(SocializadorDto socializadorDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("socializador", socializadorDto);
            return "socializador/cadastro";
        }
        socializadorService.insert(socializadorDto);
        return "redirect:/socializador/listagem";
    }
    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        socializadorService.delete(id);
        return "redirect:/socializador/listagem";
    }

}
