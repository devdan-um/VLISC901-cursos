package com.univer.cursos.controller;

import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.entity.MateriasEntity;
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

    @GetMapping("/api/univer/materia/{id}")
    public ResponseEntity<CursoEntity> cursoPorId(@PathVariable Integer id) {

        if (repository.findById(id).isPresent()) {
            return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/api/univer/materias/{idCurso}")
    public List<MateriasEntity> cursoPorIdCurso(@PathVariable Integer idCurso) {

        if (materiasRepository.materiasByCurso(idCurso).isPresent()) {
            return materiasRepository.materiasByCurso(idCurso).get();
        } else {
            return Arrays.asList(new MateriasEntity());
        }

    }
    @PostMapping("/api/univer/materias/save")
    public ResponseEntity<CursoEntity> guardarCurso(@RequestBody CursoRequest cursorequest) {
        CursoEntity curso = new CursoEntity();
        curso.setNombre(cursorequest.getNombre());
        curso.setDescripcion(cursorequest.getDescripcion());
        CursoEntity savedCurso = repository.save(curso);
        return new ResponseEntity<>(savedCurso, HttpStatus.CREATED);
    }
}
