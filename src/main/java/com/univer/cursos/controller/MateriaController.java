package com.univer.cursos.controller;

import com.univer.cursos.model.request.MateriaRequest;
import com.univer.cursos.model.response.MateriaResponse;
import com.univer.cursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriaController {

    @Autowired
    private CursoService cursoService;
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/api/univer/materia")
    public ResponseEntity salvarMateria(@RequestBody MateriaRequest request){

        MateriaResponse response = this.cursoService.saveMateria(request);

        if (response != null){
            return new ResponseEntity(response, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

}
