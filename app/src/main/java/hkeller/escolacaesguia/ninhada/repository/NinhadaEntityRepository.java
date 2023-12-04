package hkeller.escolacaesguia.ninhada.repository;

import hkeller.escolacaesguia.ninhada.entity.NinhadaEntity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface NinhadaEntityRepository extends JpaRepository<NinhadaEntity, Long> {


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ninhada (id_mae, id_pai, data, ids_filhotes) VALUES (:id_mae, :id_pai, :data, :ids_filhotes)", nativeQuery = true)
    void saveNinhada(Long id_mae, Long id_pai, Date data, @NotNull long[] ids_filhotes);
}