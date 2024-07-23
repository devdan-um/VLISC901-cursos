package com.univer.cursos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CURSO")
public class CursoEntity {

    @Id
    @Column(name = "ID_CURSO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CUATRIMESTRE")
    private Integer cuatrimestre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,  mappedBy="curso")
    @JsonManagedReference
    private Set<MateriasEntity> materias;

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<MateriasEntity> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<MateriasEntity> materias) {
        this.materias = materias;
    }

    public Integer getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Integer cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
}
