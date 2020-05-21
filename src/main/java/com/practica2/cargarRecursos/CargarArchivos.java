package com.practica2.cargarRecursos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CargarArchivos {



    public ArrayList<Profesores> cargarArchivoProfesores(){

        //Generamos el array que contendra los datos de todos los profesores
        ArrayList<Profesores> listaProfesores = new ArrayList<>();

        //Creamos el objeto de tipo file dandole como parametro el nombre de nuestro archivo
        File f = new File("listaProfesores.txt");
        System.out.println(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src\\main\\resources\\Archivos\\listaProfesores.txt");
        //Creamos el try catch a partir de una ruta dinamica
        try(BufferedReader bf = new BufferedReader(new FileReader(String.valueOf(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src\\main\\resources\\Archivos\\listaProfesores.txt")))){
            String bfRead;
            while((bfRead = bf.readLine())!= null){
                System.out.println(bfRead);
            }
        }catch (Exception e){
            System.out.println("Error al abrir el archivo");
        }

        System.out.println(f.getAbsoluteFile());



        return listaProfesores;
    }


}
