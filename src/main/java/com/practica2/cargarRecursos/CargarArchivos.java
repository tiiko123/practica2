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

        //Generamos el array que contendra los datos de todos los profesores
        ArrayList<Profesores> listaProfesores = new ArrayList<>();

        //Creamos el objeto de tipo file dandole como parametro el nombre de nuestro archivo
        File f = new File("listaProfesores.txt");
        //Creamos el try catch a partir de una ruta dinamica
        try(BufferedReader bf = new BufferedReader(new FileReader(String.valueOf(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src\\main\\resources\\Archivos\\listaProfesores.txt")))){
            String bfRead;
            while((bfRead = bf.readLine())!= null){
                System.out.println(bfRead);
            }
        }catch(FileNotFoundException ex){
            System.out.println("El archivo no a sido encontrado");

            //Creamos el try catch a partir de una ruta dinamica
            try(BufferedReader bf = new BufferedReader(new FileReader(String.valueOf(f.getAbsolutePath().substring(0,f.getAbsolutePath().indexOf("listaProfesores"))+"src/main/resources/Archivos/listaProfesores.txt")))){
                String bfRead;
                while((bfRead = bf.readLine())!= null){
                    System.out.println(bfRead);
                }
            }catch(Exception e){

            }
        }catch (Exception e){
            System.out.println("Error al abrir el archivo");
        }




        return listaProfesores;
    }

    /*public ArrayList<Profesores> cargarArchivoProfesoresXlsx(){
        boolean primeraVuelta = false;;
        File f = new File("listaProfesores.xlsx");

        System.out.println(f.getAbsolutePath());

        try (FileInputStream file = new FileInputStream(new File(String.valueOf(f.getAbsolutePath())))) {
            // leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            //throw new NotFoundPathException("Sólo se pueden almacenar números pares");

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
    }*/


}
