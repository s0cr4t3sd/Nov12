/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import ejercicio7.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author cronida
 */
public class Main {
    
    
    public static void escribirObjeto(String fichero, ArrayList<Vehiculo> lista){
         
        try (ObjectOutputStream flujo =new ObjectOutputStream(new FileOutputStream(fichero))) {
            for(Vehiculo i : lista){
                if(i instanceof Turismo && fichero.equals("turismo.dat")){
                    flujo.writeObject(i);
                }

                if(i instanceof Deportivo && fichero.equals("deportivo.dat")){
                    flujo.writeObject(i);
                }

                if(i instanceof Furgoneta && fichero.equals("furgoneta.dat")){
                    flujo.writeObject(i);
                }
                
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("El fichero" + fichero + "no existe.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String idFichero = "vehiculos.txt",linea;
        String [] tokens, campo;
        ArrayList<Vehiculo> lista = new ArrayList<>();
        ArrayList<Turismo> listaTurismo = new ArrayList();
        ArrayList<Furgoneta> listaFurgoneta = new ArrayList();
        ArrayList<Deportivo> listaDeportivo = new ArrayList();
        
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
           
           /* SIMPLIFICO UTILIZANDO UN METODO */
           escribirObjeto("turismo.dat", lista);
           escribirObjeto("deportivo.dat", lista);
           escribirObjeto("furgoneta.dat", lista);
           
           for(Vehiculo i : lista){
              if(i instanceof Turismo){
                  listaTurismo.add((Turismo) i);
              }
              
              if(i instanceof Deportivo){
                  listaDeportivo.add((Deportivo) i);
              }
              
              if(i instanceof Furgoneta){
                  listaFurgoneta.add((Furgoneta) i);
              }
            }          
            
            
            /*String ficheroTurismo = "turismo.dat";
            try (ObjectOutputStream flujoTurismo =new ObjectOutputStream(new FileOutputStream(ficheroTurismo))) {
                for(Turismo i : listaTurismo){
                    flujoTurismo.writeObject(i);
                }
                
            } catch (FileNotFoundException fnfe) {
                System.out.println("El fichero" + ficheroTurismo + "no existe.");
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            
            String ficheroDeportivo = "deportivo.dat";
            try (ObjectOutputStream flujoDeportivo =new ObjectOutputStream(new FileOutputStream(ficheroDeportivo))) {
                for(Deportivo i : listaDeportivo){
                    flujoDeportivo.writeObject(i);
                }
            
            } catch (FileNotFoundException fnfe) {
                System.out.println("El fichero" + ficheroTurismo + "no existe.");
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            
            String ficheroFurgoneta = "furgoneta.dat";
            try (ObjectOutputStream flujoFurgoneta =new ObjectOutputStream(new FileOutputStream(ficheroFurgoneta))) {
                for(Furgoneta i : listaFurgoneta){
                    flujoFurgoneta.writeObject(i);
                }
            
            } catch (FileNotFoundException fnfe) {
                System.out.println("El fichero" + ficheroFurgoneta + "no existe.");
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }*/

       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       } 
    }
}
