/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author cronida
 */
public class Main {
    public static void main(String[] args) {
        String idFichero = "vehiculos.txt",linea;
        String [] tokens, campo;
        ArrayList<Vehiculo> lista = new ArrayList<>();
        
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
}
