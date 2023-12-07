package hkeller.escolacaesguia.voluntario.controller;


import hkeller.escolacaesguia.voluntario.model.Voluntario;
import hkeller.escolacaesguia.voluntario.services.ObterListaVoluntarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/voluntarios")
public class VoluntarioRestController {
  @Autowired
  ObterListaVoluntarioServico obterListaVoluntarioServico;
  @GetMapping()
  public Page<Voluntario> get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
    return obterListaVoluntarioServico.execute(page, size);
    // TODO
  }

}





