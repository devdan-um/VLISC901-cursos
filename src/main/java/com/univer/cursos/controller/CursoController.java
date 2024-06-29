package com.univer.cursos.controller;

import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.entity.MateriasEntity;
import com.univer.cursos.repository.CursoRepository;
import com.univer.cursos.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private MateriasRepository materiasRepository;

    @GetMapping("/api/univer/materia/{id}")
    public ResponseEntity<CursoEntity> cursoPorId(@PathVariable Integer id) {
        Optional<CursoEntity> cursoOptional = repository.findById(id);
        if (cursoOptional.isPresent()) {
            CursoEntity curso = cursoOptional.get();
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
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
    public ResponseEntity<CursoEntity> guardarCurso(@RequestBody CursoRequest request) {
        CursoEntity g = new CursoEntity();
        g.setNombre(request.getNombre());
        g.setDescripcion(request.getDescripcion());
        CursoEntity gc = repository.save(g);

        return new ResponseEntity<>(gc, HttpStatus.CREATED);
    }

}
