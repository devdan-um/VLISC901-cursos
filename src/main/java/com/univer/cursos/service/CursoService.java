package com.univer.cursos.service;

import com.univer.cursos.entity.CursoEntity;
import com.univer.cursos.model.request.MateriaRequest;
import com.univer.cursos.model.response.CursoResponse;
import com.univer.cursos.model.response.MateriaResponse;
import com.univer.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MateriasRepository materiasRepository;

    public CursoResponse getCurso(Integer id){

        CursoResponse response = new CursoResponse();
        Optional<CursoEntity> entity = cursoRepository.findById(id);

        if(entity.isPresent()){
            response.setNombre(entity.get().getNombre());
            response.setDescripcion(entity.get().getDescripcion());
            return response;
        } else {
            return null;
        }

    }

    public List<CursoResponse> getAllCursos(){

        List<CursoResponse> response = new ArrayList<>();

        cursoRepository.findAll().forEach(entity -> {
            CursoResponse c = new CursoResponse();
            c.setNombre(entity.getNombre());
            c.setDescripcion(entity.getDescripcion());
            c.setCuatrimestre(entity.getCuatrimestre());
            response.add(c);
        });

        return response;

    }

    public MateriaResponse saveMateria(MateriaRequest request){

        MateriasEntity me = new MateriasEntity();
        me.setNombre(request.getName());
        me.setHorasSemana(request.getHoraSemana());

        MateriaResponse response = null;

        Optional<CursoEntity> entity = cursoRepository.materiaByCuatrimestre(request.getCurso());

        if(entity.isPresent()){
            me.setCurso(entity.get());
            this.materiasRepository.save(me);
            response = new MateriaResponse();
            response.setNombre(request.getName());
            response.setCuatrimestre(entity.get().getNombre());
            return response;
        } else {
            return response;
        }

    }

}