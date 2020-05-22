package com.practica2.cargarRecursos;




import java.io.*;
import java.util.ArrayList;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;

public class CargarArchivos {



    public ArrayList<Profesores> cargarArchivoProfesoresTxt(){

        System.out.println("Cargar mediante txt");
        //Generamos el array que contendra los datos de todos los profesores
        ArrayList<Profesores> listaProfesores = new ArrayList<>();

        //Creamos el objeto de tipo file dandole como parametro el nombre de nuestro archivo
        File f = new File("listaProfesores.txt");

        //Creamos el try catch a partir de una ruta dinamica para windows
        try(BufferedReader bf = new BufferedReader(new FileReader(String.valueOf(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src/main/resources/Archivos/listaProfesores1.txt")))){
            String bfRead;
            while((bfRead = bf.readLine())!= null){
                System.out.println(bfRead);
            }
            System.out.println("Se cargo correctamente el archivo de lista de profesores");
        }catch(FileNotFoundException ex){
            //Creamos el try catch a partir de una ruta dinamica para linux
            /*try(BufferedReader bf = new BufferedReader(new FileReader(String.valueOf(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src/main/resources/Archivos/listaProfesores.txt")))){
                String bfRead;
                while((bfRead = bf.readLine())!= null){
                    System.out.println(bfRead);
                }
                System.out.println("Se cargo correctamente el archivo de lista de profesores");
            }catch (Exception e){
                System.out.println("Error al abrir el archivo lista profesores txt");
            }*/
            cargarArchivoProfesoresXlsx();

        }catch (Exception e){
            System.out.println("Error al abrir el archivo lista profesores txt");
            cargarArchivoProfesoresXlsx();
        }
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


        }catch(FileNotFoundException e){//Error pro si no encuentra el archivo en la ruta
            System.out.println("Error al encontrar el archivo");
        } catch (Exception e) {
            System.out.println("Error al encontrar el archivo");


        }

        return listaProfesores;
    }


}
