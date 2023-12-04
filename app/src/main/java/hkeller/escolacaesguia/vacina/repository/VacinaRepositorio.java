package hkeller.escolacaesguia.vacina.repository;

import hkeller.escolacaesguia.vacina.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepositorio extends JpaRepository<Vacina, Long> {
}







