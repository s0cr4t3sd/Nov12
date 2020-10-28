/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import ejercicio7.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


/**
 *
 * @author cronida
 */


public class Main {
    private static void crearDirectorio(String ruta){
        Path file = Paths.get(ruta);
        try{
            Files.createDirectory(file);
        }catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private static void mostrarContenidoDir(String ruta){
        File file = new File(ruta);
        if(file.exists()){
            File[] ficheros = file.listFiles();
            for(File i : ficheros){
                System.out.println(i.getName());
            }
        }else{
            System.out.println("El directorio no existe...");
        }
    }
    
   private static void mostrarContenidoDir(String ruta,ArrayList<String> lista){
        File file = new File(ruta);
        if(file.exists()){
            File[] ficheros = file.listFiles();
            for(File i : ficheros){
                //System.out.println(i.getName());
                lista.add(i.getName());
            }
        }else{
            System.out.println("El directorio no existe...");
        }
    }
    
    
    private static void crearArchivo(String ruta){
        Path file = Paths.get(ruta);
        try{
            Files.createFile(file);
        }catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private static void copiarArchivo(String origen, String destino){
        Path orig = Paths.get(origen);
        Path dest = Paths.get(destino);
        try{
            Files.copy(orig, dest, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private static void eliminarArchivo(String ruta){
        Path file = Paths.get(ruta);
        try{
            Files.delete(file);
        }catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    
    private static void moverArchivo(String origen, String destino){
        copiarArchivo(origen,destino);
        eliminarArchivo(origen);
    }
    
    private static void leerFichero(String idFichero, ArrayList<Vehiculo> lista){
        String [] tokens,campo;
        String linea;
        try (Scanner datosFichero = new Scanner(new File(idFichero))){

           System.out.println("Separando cada elemento del fichero: ");
           System.out.println("");

           while (datosFichero.hasNextLine()) {

               linea = datosFichero.nextLine();
               tokens = linea.split(" - ");
               campo = tokens[1].split(":");
               
               int nPlazas = Integer.parseInt(campo[4]);
               
               switch(tokens[0]){
                    case "0": //TURISMO
                        boolean baca = Boolean.parseBoolean(campo[5]);                       
                        lista.add(new Turismo(baca, campo[0], campo[1], campo[2], campo[3], nPlazas));
                        break;
                    case "1": //DEPORTIVO
                        int caballos = Integer.parseInt(campo[5]);
                        lista.add(new Deportivo(caballos, campo[0], campo[1], campo[2], campo[3], nPlazas));
                        break;
                    case "2": //FURGONETA
                        Tamanio tam = null;
                        switch(campo[5]){
                            case "Pequeña":
                                tam = Tamanio.PEQUENIA;
                                break;
                            case "Mediana":
                                tam = Tamanio.MEDIANA;
                                break;
                            case "Grande":
                                tam = Tamanio.GRANDE;
                                break;
                        }
                        lista.add(new Furgoneta(tam, campo[0], campo[1], campo[2], campo[3], nPlazas));
                        break;
               }
               
           }
           
           Collections.sort(lista, (Vehiculo a1, Vehiculo a2) -> a1.getMatricula().compareTo(a2.getMatricula()));
           
           for(Vehiculo i : lista){
               System.out.println(i);
           }

       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       } 
    }
    public static void main(String[] args) {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        ArrayList<String> listaContDir = new ArrayList<>();
        String[] token;
        
        leerFichero("vehiculos.txt",lista);
        
       /* leerFichero("deportivo.txt",lista);
        leerFichero("furgoneta.txt",lista);
        leerFichero("turismo.txt",lista);*/
        
        for(Vehiculo i : lista){
            System.out.println(i);
        }
        
        //CREAR DIRECTORIO
        crearDirectorio("./copias");
        
        //MOVER LOS TODOS LOS ARCHIVOS TXT        
        mostrarContenidoDir("./", listaContDir);
        for(String i : listaContDir){
            token = i.split("\\.");
            if(token.length > 1 && token[1].equals("txt")){
                copiarArchivo("./"+i,"./copias/"+i);
            }            
        }
        listaContDir.clear();
        
        //MOSTRAR EL CONTENIDO DEL DIRECTORIO copias
        mostrarContenidoDir("./copias");
        
        //Leer los ficheros de la carpeta “copias” e ir guardando los objetos en una lista de Vehículos.
        mostrarContenidoDir("./", listaContDir);
        for(String i : listaContDir){
            token = i.split("\\.");
            if(token.length > 1 && token[1].equals("txt") && !i.equals("vehiculos.txt")){
                leerFichero(i, lista);
            }            
        }
        listaContDir.clear();
        
        //Imprimir la lista por pantalla.
        for(Vehiculo i : lista){
            System.out.println(i);
        }
        System.out.println("");
        
        //Ordena la lista por bastidor. Como no tengo el atributo bastidor para vehiculo, utilizare nPlazas que es un entero tambien.
        Collections.sort(lista, (Vehiculo v1, Vehiculo v2) -> v1.getnPlazas() - v2.getnPlazas());
        
        //Imprimir la lista ordenada.
        for(Vehiculo i : lista){
            System.out.println(i+"  \t nPlaza = "+i.getnPlazas());
        }
        
        //Borrar los ficheros *.txt originales.
        mostrarContenidoDir("./", listaContDir);
        for(String i : listaContDir){
            token = i.split("\\.");
            if(token.length > 1 && token[1].equals("txt") && !i.equals("vehiculos.txt")){
                eliminarArchivo(i);
            }            
        }
        listaContDir.clear();
        
        //Mostrar el contenido de la carpeta donde estaban los *.txt originales.
        System.out.println("");
        mostrarContenidoDir("./");
        
        System.out.println("");
        System.out.println("");
        System.out.println("Streams:");
        
        //Predicate<String> blancos = 
        //Imprime por pantalla todos los coches blancos, distintos, ordenador por matrícula.
        lista.stream()
                .filter(v -> v.getColor().equals("Blanco"))
                .sorted((v1,v2)-> v1.getMatricula().compareTo(v2.getMatricula()))
                .forEach(System.out::println);
        
        //Imprime por pantalla todas las marcas de coches distintas de aquellos
        //coches que estén disponibles. Como no tenia un atributo disponible, lo he hecho con el string de modelo.
        //Con un boolean ser haria asi -> .filter(v -> v.getDisponible())
        System.out.println("");
        lista.stream()
                .filter(v -> v.getModelo().equals("Si"))
                .map(v1 -> v1.getMarca())
                .distinct()
                .forEach(System.out::println);
        
        //Saber la cantidad de vehículos Citroen.
        System.out.println("");
        System.out.println(
                lista.stream()
                .filter(v -> v.getMarca().equals("Citroen"))
                .count()
        );
        
        //Comprueba si hay algún Peugeot negro disponible en la lista.
        System.out.println("");
        System.out.println(
                lista.stream()
                .anyMatch(v -> v.getMarca().equals("Negro") && v.getColor().equals("Negro"))
        );
        
        
    }
}
