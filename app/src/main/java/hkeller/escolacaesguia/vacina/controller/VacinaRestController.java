package hkeller.escolacaesguia.vacina.controller;


import hkeller.escolacaesguia.vacina.model.Vacina;
import hkeller.escolacaesguia.vacina.services.ObterListaVacinaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/vacinas")
public class VacinaRestController {

  @Autowired
  ObterListaVacinaServico obterListaVacinaServico;
  @GetMapping()
  public Page<Vacina> get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
    return obterListaVacinaServico.execute(page, size);
    // TODO
  }

}
