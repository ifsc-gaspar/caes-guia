package hkeller.escolacaesguia.ninhada.controller;

import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.ninhada.dto.NinhadaDto;
import hkeller.escolacaesguia.ninhada.service.NinhadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninhada")
public class NinhadaController {

    private final NinhadaService ninhadaService;

    @Autowired
    public NinhadaController(NinhadaService ninhadaService) {
        this.ninhadaService = ninhadaService;
    }

    @GetMapping("/cadastro")
    public String cadastrar(Model model){
        NinhadaDto ninhada = new NinhadaDto();
        model.addAttribute("ninhada", ninhada);
        return "ninhada/cadastro";
    }

    //API REST para salvar ninhada
    @ResponseBody
    @PostMapping("/salvar")
    public String salvar(@RequestBody NinhadaDto ninhadaDto) {
        ninhadaService.insertNinhada(ninhadaDto);
        return "redirect:/socializador/cadastrar";
    }

    @ResponseBody
    @GetMapping("/pesquisar-femeas/{nome}")
    public List<CaoDto> pesquisarFemeas(@PathVariable("nome") String term) {
        return ninhadaService.listarCaoNomeSexo(term,"Fêmea");
    }
    @ResponseBody
    @GetMapping("/pesquisar-machos/{nome}")
    public List<CaoDto> pesquisarMachos(@PathVariable("nome") String term) {
        return ninhadaService.listarCaoNomeSexo(term,"Macho");
    }


}
