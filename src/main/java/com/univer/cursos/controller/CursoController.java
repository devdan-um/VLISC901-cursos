package com.univer.cursos.controller;

import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.entity.MateriasEntity;
import com.univer.cursos.model.request.CursoRequest;
import com.univer.cursos.model.request.MateriasRequest;
import com.univer.cursos.repository.CursoRepository;
import com.univer.cursos.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private MateriasRepository materiasRepository;

    @GetMapping("/api/univer/materia/{id}")
    public CursoEntity cursoPorId(@PathVariable Integer id){

        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        } else {
            return new CursoEntity();
        }

    }

    @GetMapping("/api/univer/materias/{idCurso}")
    public List<MateriasEntity> cursoPorIdCurso(@PathVariable Integer idCurso){

        if(materiasRepository.materiasByCurso(idCurso).isPresent()){
            return materiasRepository.materiasByCurso(idCurso).get();
        } else {
            return Arrays.asList(new MateriasEntity());
        }

    }
    @CrossOrigin("http://127.0.0.1:5500")

    @PostMapping("/api/univer/materias/save")
    public ResponseEntity guardarCurso(@RequestBody CursoRequest request){
        return null;
    }


}
