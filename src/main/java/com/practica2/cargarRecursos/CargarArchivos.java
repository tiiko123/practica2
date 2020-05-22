package com.practica2.cargarRecursos;




import java.io.*;
import java.util.ArrayList;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;
import java.util.Scanner;

public class CargarArchivos {

    Scanner captura = new Scanner(System.in);
    static boolean condicionParaCambiarTipoDeCarga = false;

    public ArrayList<Profesores> cargarArchivoProfesoresTxt(){

        String obtenerRuta;
        String correcta="a";
        //Generamos el array que contendra los datos de todos los profesores
        ArrayList<Profesores> listaProfesores = new ArrayList<>();

        //Creamos el objeto de tipo file dandole como parametro el nombre de nuestro archivo
        File f = new File("listaProfesores.txt");

        do{
            if(condicionParaCambiarTipoDeCarga == false){
                System.out.println("Cargar mediante txt");

                //Creamos el objeto de tipo file dandole como parametro el nombre de nuestro archivo
                obtenerRuta = String.valueOf(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src/main/resources/Archivos/listaProfesores.txt");
            }else{
                System.out.println("Cargar mediante ruta manual");

                System.out.println("Ingresar la ruta manualmente (C:desktop/archivo.xlsx)");
                obtenerRuta = captura.next();
            }


            //Capturamos el error por si al usuario se le ocurre poner qpowfqwiofnhhiof como ruta
            try {
                StringBuilder stringBuilder = new StringBuilder(obtenerRuta);
                // Y llamar al método reverse de StringBuilder (lo convertimos a cadena con toString)
                String invertida = stringBuilder.reverse().toString();
                System.out.println((invertida.substring(0,invertida.indexOf("\\"))).substring(0,invertida.indexOf(".")));

                stringBuilder = new StringBuilder((invertida.substring(0,invertida.indexOf("\\"))).substring(0,invertida.indexOf(".")));
                correcta = stringBuilder.toString();
            }catch (Exception e){
                System.out.println("Error en la ruta");
            }

            if(correcta.equals("txt")){
                //Creamos el try catch a partir de una ruta dinamica
                try(BufferedReader bf = new BufferedReader(new FileReader(obtenerRuta))){
                    String bfRead;
                    while((bfRead = bf.readLine())!= null){
                        System.out.println(bfRead);
                    }
                    System.out.println("Se cargo correctamente el archivo de lista de profesores txt");
                }catch(FileNotFoundException ex){
                    System.out.println("Error al abrir el archivo lista profesores txt\n");
                    condicionParaCambiarTipoDeCarga=true;

                    cargarArchivoProfesoresXlsx();
                }catch (Exception e){
                    System.out.println("Error al abrir el archivo lista profesores txt\n");
                    condicionParaCambiarTipoDeCarga=true;

                    cargarArchivoProfesoresXlsx();
                }
                return listaProfesores;

            }else{
                //Generamos el array que contendra los datos de todos los profesores
                boolean primeraVuelta = false;;

                try (FileInputStream file = new FileInputStream(new File(obtenerRuta))) {
                    // leer archivo excel
                    XSSFWorkbook worbook = new XSSFWorkbook(file);

                    //obtener la hoja que se va leer
                    XSSFSheet sheet = worbook.getSheetAt(0);
                    //obtener todas las filas de la hoja excel
                    Iterator<Row> rowIterator = sheet.iterator();

                    Row row;
                    // se recorre cada fila hasta el final

                    while (rowIterator.hasNext()) {

                        if(primeraVuelta == false ){
                            row = rowIterator.next();
                            primeraVuelta = true;
                        }else{
                            row = rowIterator.next();

                            Iterator<Cell> cellIterator = row.cellIterator();
                            Cell cell;
                            while (cellIterator.hasNext()) {
                                cell = cellIterator.next();

                                try{
                                    System.out.print("\t"+cell.getStringCellValue());
                                }catch(Exception e){
                                    System.out.print("\t"+cell.getNumericCellValue());
                                }
                            }
                            System.out.println("\n");
                        }
                    }


                }catch(FileNotFoundException e){//Error pro si no encuentra el archivo en la ruta
                    System.out.println("Error final jajasakskask q krazy");

                } catch (Exception e) {
                    System.out.println("Error final jajasakskask q krazy");


                }
            }

        }while(condicionParaCambiarTipoDeCarga == false);
        return listaProfesores;
    }

    public ArrayList<Profesores> cargarArchivoProfesoresXlsx(){
        System.out.println("Cargar mediante Xlsx");
        //Generamos el array que contendra los datos de todos los profesores
        ArrayList<Profesores> listaProfesores = new ArrayList<>();

        //Variable para que no lea la primera columna del excel que son los nombres de las columnas
        boolean primeraVuelta = false;

        //Creamos el objeto de tipo file dandole como parametro el nombre de nuestro archivo
        File f = new File("listaProfesores.xlsx");

        //Creamos el try catch a partir de una ruta dinamica para windows
        try (FileInputStream file = new FileInputStream(new File(String.valueOf(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src/main/resources/Archivos/listaProfesores.xlsx")))) {
            // leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);

            //obtener la hoja que se va leer
            XSSFSheet sheet = worbook.getSheetAt(0);
            //obtener todas las filas de la hoja excel
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;

            // se recorre cada fila hasta el final
            while (rowIterator.hasNext()) {

                if(primeraVuelta == false ){
                    row = rowIterator.next();
                    primeraVuelta = true;
                }else{
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;
                    while (cellIterator.hasNext()) {
                        cell = cellIterator.next();
                        try{
                            System.out.print("\t"+cell.getStringCellValue());
                        }catch(Exception e){
                            System.out.print("\t"+cell.getNumericCellValue());
                        }
                    }
                    System.out.println("\n");
                }
            }

        }catch(FileNotFoundException e){
            //Error pro si no encuentra el archivo en la ruta
            System.out.println("Error al encontrar el archivo");
            cargarArchivoProfesoresTxt();
        } catch (Exception e) {
            System.out.println("Error al encontrar el archivo");
            cargarArchivoProfesoresTxt();
        }

        return listaProfesores;
    }


}
