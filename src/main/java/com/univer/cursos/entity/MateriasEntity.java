package com.univer.cursos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "MATERIA")
public class MateriasEntity {

    @Id
    @Column(name = "ID_MATERIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateria;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "HORAS_SEMANA")
    private Integer horasSemana;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="idCurso", nullable=false)
    @JsonBackReference
    private CursoEntity curso;

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(Integer horasSemana) {
        this.horasSemana = horasSemana;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }
}
