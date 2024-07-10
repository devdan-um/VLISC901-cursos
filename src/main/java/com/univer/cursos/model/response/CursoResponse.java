package com.univer.cursos.model.response;

public class CursoResponse {
    public String getNombre() {
        return nombre ;
    }

    public void setNombre(String nombre )  {
        this.nombre =  nombre;
    }

    private String nombre;

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    private String descripcion;
}
