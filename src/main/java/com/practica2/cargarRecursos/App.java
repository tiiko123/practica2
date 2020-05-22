package com.practica2.cargarRecursos;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CargarArchivos cargarArchivos = new CargarArchivos();
        Scanner captura = new Scanner(System.in);
        int opcionElegida;

        //cargarArchivos.cargarArchivoProfesoresTxt();


        System.out.println("Menu:");
        System.out.println("1.-Cargar Lista de profesores");
        opcionElegida = captura.nextInt();

        switch (opcionElegida){
            case 1:
                cargarArchivos.cargarArchivoProfesoresTxt();
                break;
            case 2:

                break;
        }

    }
}
