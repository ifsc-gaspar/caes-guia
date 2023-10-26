package hkeller.escolacaesguia.voluntario.repository;

import hkeller.escolacaesguia.voluntario.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface VoluntarioRepositorio extends JpaRepository<Voluntario, Long> {

}

