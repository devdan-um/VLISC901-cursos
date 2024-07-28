package com.univer.cursos.model.request;

public class MateriaRequest {

    private String name;
    private Integer curso;
    private Integer horaSemana;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getHoraSemana() {
        return horaSemana;
    }

    public void setHoraSemana(Integer horaSemana) {
        this.horaSemana = horaSemana;
    }
}
