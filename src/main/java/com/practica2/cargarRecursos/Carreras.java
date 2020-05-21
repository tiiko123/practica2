package com.practica2.cargarRecursos;

public class Carreras {

    private int idcarrera;
    private String nombre_carrera;

    public Carreras(int idcarrera, String nombre_carrera) {
        this.idcarrera = idcarrera;
        this.nombre_carrera = nombre_carrera;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }
}
