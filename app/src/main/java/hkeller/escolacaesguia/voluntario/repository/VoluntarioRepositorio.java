package hkeller.escolacaesguia.voluntario.repository;

import hkeller.escolacaesguia.voluntario.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepositorio extends JpaRepository<Voluntario, Long> {

}

