package com.practica2.cargarRecursos;

public class Profesores {

    private String clv_usuario;
    private String pass_usuario;
    private String tipo_usuario;
    private int idcarrera;
    private String nombre_usuario;
    private String nivel_ads;
    private String contrato;

    public Profesores(String clv_usuario, String pass_usuario, String tipo_usuario, int idcarrera, String nombre_usuario, String nivel_ads, String contrato) {
        this.clv_usuario = clv_usuario;
        this.pass_usuario = pass_usuario;
        this.tipo_usuario = tipo_usuario;
        this.idcarrera = idcarrera;
        this.nombre_usuario = nombre_usuario;
        this.nivel_ads = nivel_ads;
        this.contrato = contrato;
    }

    public String getClv_usuario() {
        return clv_usuario;
    }

    public void setClv_usuario(String clv_usuario) {
        this.clv_usuario = clv_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNivel_ads() {
        return nivel_ads;
    }

    public void setNivel_ads(String nivel_ads) {
        this.nivel_ads = nivel_ads;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
}
