package com.univer.cursos.controller;

import com.univer.cursos.Service.CursoService;
import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.entity.MateriasEntity;
import com.univer.cursos.model.request.CursoRequest;
import com.univer.cursos.model.request.MateriasRequest;
import com.univer.cursos.model.response.CursoResponse;
import com.univer.cursos.repository.CursoRepository;
import com.univer.cursos.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private CursoService cursoService;

    @GetMapping("/api/univer/materia/{id}")
    public ResponseEntity cursoPorId(@PathVariable Integer id){

        CursoResponse response = this.cursoService.getCurso( 1);

        if(response != null){
            return new ResponseEntity(response, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
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

    @PostMapping("/api/univer/materias/save")
    public ResponseEntity guardarCurso(@RequestBody CursoRequest request){
        return null;
    }


}
