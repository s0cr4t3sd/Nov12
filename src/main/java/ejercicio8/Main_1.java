/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import ejercicio7.*;
import ejercicio4.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cronida
 */
public class Main_1 {
    public static void main(String[] args) {
        ArrayList<Vehiculo> lista = new ArrayList<>();
        
        for(int i = 0; i < 10; i++){
            lista.add(new Turismo());
            lista.add(new Deportivo());
            lista.add(new Furgoneta());
        }  
        String idfichero = "vehiculos.txt";
		
        // Array a escribir
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))){
            
            for(Vehiculo i : lista){
                if(i instanceof Turismo){                   
                    flujo.write("0 - "+i.toString());
                }
                
                if(i instanceof Deportivo){
                    flujo.write("1 - "+i.toString());
                }
                
                if(i instanceof Furgoneta){
                    flujo.write("2 - "+i.toString());
                }
                flujo.newLine();
            }
            flujo.flush();
            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }
}
