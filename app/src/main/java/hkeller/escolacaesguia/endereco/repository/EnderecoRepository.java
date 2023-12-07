package hkeller.escolacaesguia.endereco.repository;

import hkeller.escolacaesguia.endereco.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

  Optional<Endereco> findByCep(int cep);
}
