package hkeller.escolacaesguia.cao.repository;

import hkeller.escolacaesguia.cao.model.Cao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaoRepositorio extends JpaRepository<Cao, Long> {
    List<Cao> findBySexoAndNomeContainsIgnoreCase(String sexo,String nome);
}
