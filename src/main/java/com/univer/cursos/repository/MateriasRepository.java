package com.univer.cursos.repository;

import com.univer.cursos.entity.MateriasEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriasRepository extends CrudRepository<MateriasEntity, Integer> {

    @Query("SELECT m " +
            "FROM CursoEntity c, MateriasEntity m " +
            "WHERE c.idCurso = m.curso.idCurso " +
            "AND c.idCurso = :idCurso")
    Optional<List<MateriasEntity>> materiasByCurso(Integer idCurso);

}
