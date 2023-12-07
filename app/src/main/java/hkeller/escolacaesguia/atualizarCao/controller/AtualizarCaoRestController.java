package hkeller.escolacaesguia.atualizarCao.controller;


import hkeller.escolacaesguia.atualizarCao.model.AtualizarCao;
import hkeller.escolacaesguia.atualizarCao.services.ObterListaAtualizacoesCaesServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("rest/atualizarCaes")
public class AtualizarCaoRestController {
    @Autowired
    ObterListaAtualizacoesCaesServico obterListaAtualizacoesCaesServico;

    @GetMapping()
    public Page<AtualizarCao> get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return obterListaAtualizacoesCaesServico.execute(page, size);
    }
}
