package hkeller.escolacaesguia.socializador.services;

import hkeller.escolacaesguia.common.mapper.GenericMapper;
import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import hkeller.escolacaesguia.endereco.mapper.EnderecoMapper;
import hkeller.escolacaesguia.endereco.model.Endereco;
import hkeller.escolacaesguia.pessoa.PessoaDto;
import hkeller.escolacaesguia.pessoa.PessoaEntity;
import hkeller.escolacaesguia.pessoa.repository.PessoaRepository;
import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.entity.SocializadorEntity;
import hkeller.escolacaesguia.socializador.repository.SocializadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocializadorService {

    private final SocializadorRepository socializadorRepository;

    @Autowired
    private GenericMapper<SocializadorEntity, SocializadorDto> socializadorMapper;
    @Autowired
    private GenericMapper<PessoaEntity, PessoaDto> pessoaMapper;
    @Autowired
    private GenericMapper<Endereco, EnderecoDto> enderecoMapper;

    public SocializadorService(SocializadorRepository socializadorRepository) {
        this.socializadorRepository = socializadorRepository;
    }


    @Transactional
    public void insert(SocializadorDto dto) {
        SocializadorEntity socializadorEntity = socializadorMapper.toEntity(dto, SocializadorEntity.class);
        socializadorEntity.setPessoaEntity(pessoaMapper.toEntity(dto.getPessoa(), PessoaEntity.class));
        socializadorEntity.setEndereco(enderecoMapper.toEntity(dto.getEndereco(), Endereco.class));
        socializadorRepository.save(socializadorEntity);
    }

    public void update(SocializadorEntity entity) {
        socializadorRepository.save(entity);
    }

    public SocializadorEntity find(long id) {
        Optional<SocializadorEntity> socializador = socializadorRepository.findById(id);
        return socializador.orElse(null);
    }

    public List<SocializadorDto> findAll() {
         return socializadorRepository.findAll()
                 .stream()
                 .map(socializadorEntity -> {
                     SocializadorDto socializadorDto = socializadorMapper.toDto(socializadorEntity, SocializadorDto.class);
                     socializadorDto.setPessoa(pessoaMapper.toDto(socializadorEntity.getPessoaEntity(), PessoaDto.class));
                        socializadorDto.setEndereco(enderecoMapper.toDto(socializadorEntity.getEndereco(), EnderecoDto.class));
                     return socializadorDto;
                 })
                 .toList();
    }

    public void delete(Long id) {
        socializadorRepository.deleteById(id);
    }
}
