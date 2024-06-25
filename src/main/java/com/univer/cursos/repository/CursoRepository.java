package com.univer.cursos.repository;

import com.univer.cursos.entity.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity, Integer> {
}
