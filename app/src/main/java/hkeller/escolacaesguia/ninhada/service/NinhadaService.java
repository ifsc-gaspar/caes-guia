package hkeller.escolacaesguia.ninhada.service;

import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.cao.mapper.CaoMapper;
import hkeller.escolacaesguia.cao.model.Cao;
import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import hkeller.escolacaesguia.common.mapper.GenericMapper;
import hkeller.escolacaesguia.ninhada.dto.NinhadaDto;
import hkeller.escolacaesguia.ninhada.entity.NinhadaEntity;
import hkeller.escolacaesguia.ninhada.repository.NinhadaEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NinhadaService {

    private final GenericMapper<NinhadaEntity, NinhadaDto> ninhadaGenericMapper;
    private final GenericMapper<Cao, CaoDto> caoGenericMapper;
    private final NinhadaEntityRepository ninhadaRepository;
    private final CaoRepositorio caoRepositorio;

    @Autowired
    public NinhadaService(NinhadaEntityRepository ninhadaRepository, GenericMapper<NinhadaEntity, NinhadaDto> ninhadaGenericMapper, GenericMapper<Cao, CaoDto> caoGenericMapper, CaoRepositorio caoRepositorio) {
        this.ninhadaGenericMapper = ninhadaGenericMapper;
        this.ninhadaRepository = ninhadaRepository;
        this.caoGenericMapper = caoGenericMapper;
        this.caoRepositorio = caoRepositorio;
    }

    public void insertNinhada(NinhadaDto ninhadaDto) {

        NinhadaEntity ninhadaEntity = new NinhadaEntity();
        List<Cao> caoList = caoRepositorio.saveAll(
                ninhadaDto.getFilhotes()
                        .stream()
                        .map(CaoMapper::mapToCao)
                        .toList());
        long[] ids = caoList.stream().mapToLong(Cao::getId).toArray();
        ninhadaEntity.setIds_filhotes(ids);
        ninhadaEntity.setId_mae(ninhadaDto.getId_mae());
        ninhadaEntity.setId_pai(ninhadaDto.getId_pai());
        ninhadaEntity.setData(ninhadaDto.getData());
        ninhadaRepository.saveNinhada(ninhadaEntity.getId_mae(), ninhadaEntity.getId_pai(), ninhadaEntity.getData(), ninhadaEntity.getIds_filhotes());

    }

    public List<CaoDto> listarCaoNomeSexo(String nome, String sexo) {
        return caoRepositorio.findBySexoAndNomeContainsIgnoreCase(sexo, nome).stream().map(cao -> caoGenericMapper.toDto(cao, CaoDto.class)).collect(Collectors.toList());
    }
}
