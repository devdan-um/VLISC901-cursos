package com.univer.cursos.controller;

import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.entity.MateriasEntity;
import com.univer.cursos.model.response.CursoResponse;
import com.univer.cursos.repository.CursoRepository;
import com.univer.cursos.repository.MateriasRepository;
import com.univer.cursos.service.CursoService;
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

    @Autowired
    private CursoService cursoService;

    @GetMapping("/api/univer/materia/{id}")
    public ResponseEntity cursoPorId(@PathVariable Integer id) {

        CursoResponse response = this.cursoService.getCurso(id);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.noContent().build();
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
    public ResponseEntity<CursoEntity> guardarCurso(@RequestBody CursoRequest request) {
        CursoEntity g = new CursoEntity();
        g.setNombre(request.getNombre());
        g.setDescripcion(request.getDescripcion());
        CursoEntity gc = repository.save(g);

        return new ResponseEntity<>(gc, HttpStatus.CREATED);
    }
}