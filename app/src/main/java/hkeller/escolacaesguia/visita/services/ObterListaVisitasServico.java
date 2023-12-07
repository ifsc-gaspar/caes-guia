package hkeller.escolacaesguia.visita.services;

import hkeller.escolacaesguia.visita.model.Visita;
import hkeller.escolacaesguia.visita.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ObterListaVisitasServico {
    @Autowired
    VisitaRepository visitaRepositorio;

    public Page<Visita> execute(Integer page, Integer size) {
        Page<Visita> visitas = visitaRepositorio.findAll(PageRequest.of(page, size, Sort.by("id").descending()));

        return visitas;
    }

    public List<Visita> getAllVisitas() {
      return this.visitaRepositorio.findAll();
    }
}
