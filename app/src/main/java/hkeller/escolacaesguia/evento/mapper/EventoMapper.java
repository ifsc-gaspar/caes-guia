package hkeller.escolacaesguia.evento.mapper;

import hkeller.escolacaesguia.evento.dto.RequisicaoCadastroEventoDto;
import hkeller.escolacaesguia.evento.model.Evento;

public class EventoMapper {
    public static Evento mapToEvento(RequisicaoCadastroEventoDto eventoDto) {
        Evento evento = Evento.builder()
            .titulo(eventoDto.getTitulo())
            .descricao(eventoDto.getDescricao())
            .categoriaEvento(eventoDto.getCategoriaEvento())
            .data(eventoDto.getData())
            .notificarTutor(eventoDto.isNotificarTutor())
            .build();

        return evento;
    }
}
