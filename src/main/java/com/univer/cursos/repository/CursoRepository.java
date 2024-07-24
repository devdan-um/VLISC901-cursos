package com.univer.cursos.repository;


import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.entity.MateriasEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity, Integer> {

    @Query("SELECT c " +
            "FROM CursoEntity c " +
            "WHERE c.cuatrimestre = :idCurso")
    Optional<CursoEntity> materiaByCuatrimestre(Integer idCurso);

}