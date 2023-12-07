package hkeller.escolacaesguia.ninhada.service;

import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.cao.mapper.CaoMapper;
import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import hkeller.escolacaesguia.common.mapper.GenericMapper;
import hkeller.escolacaesguia.ninhada.dto.NinhadaDto;
import hkeller.escolacaesguia.ninhada.dto.RequisicaoNinhadaDto;
import hkeller.escolacaesguia.ninhada.entity.NinhadaEntity;
import hkeller.escolacaesguia.ninhada.repository.NinhadaEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NinhadaService {

    private final GenericMapper<NinhadaEntity, RequisicaoNinhadaDto> requisicaoNinhadaDtoGenericMapper;
    private final GenericMapper<NinhadaEntity, NinhadaDto> ninhadaGenericMapper;
    private final NinhadaEntityRepository ninhadaRepository;
    private final CaoRepositorio caoRepositorio;

    @Autowired
    public NinhadaService(NinhadaEntityRepository ninhadaRepository, GenericMapper<NinhadaEntity, RequisicaoNinhadaDto> requisicaoNinhadaDtoGenericMapper, GenericMapper<NinhadaEntity, NinhadaDto> ninhadaGenericMapper, CaoRepositorio caoRepositorio) {
        this.requisicaoNinhadaDtoGenericMapper = requisicaoNinhadaDtoGenericMapper;
        this.ninhadaRepository = ninhadaRepository;
        this.ninhadaGenericMapper = ninhadaGenericMapper;
        this.caoRepositorio = caoRepositorio;
    }

    public void insertNinhada(RequisicaoNinhadaDto requisicaoNinhadaDto) {
        NinhadaEntity ninhadaEntity = requisicaoNinhadaDtoGenericMapper.toEntity(requisicaoNinhadaDto, NinhadaEntity.class);
        ninhadaEntity.setFilhotes(requisicaoNinhadaDto.getFilhotes().stream().map(CaoMapper::mapToCao).collect(Collectors.toList()));
        ninhadaEntity.getFilhotes().forEach(cao -> cao.setNinhada(ninhadaEntity));
        ninhadaRepository.save(ninhadaEntity);
    }

    public NinhadaDto findNinhada(Long id) {
        NinhadaEntity ninhadaEntity = ninhadaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ninhada não encontrada"));
        NinhadaDto ninhadaDto = ninhadaGenericMapper.toDto(ninhadaEntity, NinhadaDto.class);
        ninhadaDto.setFilhotes(ninhadaEntity.getFilhotes().stream().map(CaoMapper::mapToCaoDto).collect(Collectors.toList()));
        return ninhadaDto;
    }

    public NinhadaDto findFilhotes(CaoDto caoDto) {
        NinhadaEntity ninhadaEntity = caoDto.getSexo().equals("Macho")? ninhadaRepository.findById_pai(caoDto.getId()) : ninhadaRepository.findById_mae(caoDto.getId());
        NinhadaDto ninhadaDto = ninhadaGenericMapper.toDto(ninhadaEntity, NinhadaDto.class);
        ninhadaDto.setFilhotes(ninhadaEntity.getFilhotes().stream().map(CaoMapper::mapToCaoDto).collect(Collectors.toList()));
        return ninhadaDto;
    }

    public List<CaoDto> listarCaoNomeSexo(String nome, String sexo) {
        return caoRepositorio.findBySexoAndNomeContainsIgnoreCase(sexo, nome).stream().map(CaoMapper::mapToCaoDto).collect(Collectors.toList());
    }
}
