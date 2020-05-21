package com.practica2.cargarRecursos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CargarArchivos cargarArchivos = new CargarArchivos();
        cargarArchivos.cargarArchivoProfesoresTxt();
        System.out.println( "Hello World!" );
    }
}
