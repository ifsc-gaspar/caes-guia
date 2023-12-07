package hkeller.escolacaesguia.visita.services;

import hkeller.escolacaesguia.visita.dto.VisitaDto;
import hkeller.escolacaesguia.visita.model.Visita;
import hkeller.escolacaesguia.visita.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.visita.mapper.VisitaMapper.mapToVisitaDto;

@Service
public class ObterVisitaServico {
    @Autowired
    VisitaRepository visitaRepositorio;

    public VisitaDto execute(Long idVisita) {
        Visita visita = visitaRepositorio.findById(idVisita).get();

        return mapToVisitaDto(visita);
    }
}
