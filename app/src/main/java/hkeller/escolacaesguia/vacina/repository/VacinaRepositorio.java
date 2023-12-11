package hkeller.escolacaesguia.vacina.repository;

import hkeller.escolacaesguia.vacina.model.Vacina;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface VacinaRepositorio extends JpaRepository<Vacina, Long> {
}







