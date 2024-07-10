package com.univer.cursos.service;


import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.model.response.CursoResponse;
import com.univer.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public  CursoResponse getCurso (Integer id){

        CursoResponse response = new CursoResponse();
        Optional<CursoEntity> entity = cursoRepository.findById(id);

        if (entity.isPresent()) {
            response.setNombre(entity.get().getNombre());
            response.setDescripcion(entity.get().getDescripcion());
            return response;
        } else {
            return null;
        }
    }
}