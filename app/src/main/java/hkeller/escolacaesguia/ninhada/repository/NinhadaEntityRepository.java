package hkeller.escolacaesguia.ninhada.repository;

import hkeller.escolacaesguia.ninhada.entity.NinhadaEntity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface NinhadaEntityRepository extends JpaRepository<NinhadaEntity, Long> {
    @Transactional
    @Modifying
    @Query("select n from NinhadaEntity n where n.id_mae = ?1")
    NinhadaEntity findById_mae(Long id_mae);

    @Transactional
    @Modifying
    @Query("select n from NinhadaEntity n where n.id_pai = ?1")
    NinhadaEntity findById_pai(Long id_pai);


}