package com.practica2.cargarRecursos;

public class Materias {

    private String clv_materia;
    private String nombre_materia;
    private int creditos;
    private int cuatrimestre;
    private int posicion;
    private String clv_plan;
    private String tipo_materia;

    public Materias(String clv_materia, String nombre_materia, int creditos, int cuatrimestre, int posicion, String clv_plan, String tipo_materia) {
        this.clv_materia = clv_materia;
        this.nombre_materia = nombre_materia;
        this.creditos = creditos;
        this.cuatrimestre = cuatrimestre;
        this.posicion = posicion;
        this.clv_plan = clv_plan;
        this.tipo_materia = tipo_materia;
    }

    public String getClv_materia() {
        return clv_materia;
    }

    public void setClv_materia(String clv_materia) {
        this.clv_materia = clv_materia;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getClv_plan() {
        return clv_plan;
    }

    public void setClv_plan(String clv_plan) {
        this.clv_plan = clv_plan;
    }

    public String getTipo_materia() {
        return tipo_materia;
    }

    public void setTipo_materia(String tipo_materia) {
        this.tipo_materia = tipo_materia;
    }
}
