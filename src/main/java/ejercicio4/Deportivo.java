/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author cronida
 */
public class Deportivo extends Vehiculo{
    private int caballos;

    public Deportivo(int caballos, String matricula, String marca, String modelo, String color, int nPlazas) {
        super(matricula, marca, modelo, color, nPlazas);
        this.caballos = caballos;
    }

    public Deportivo(int caballos) {
        super();
        this.caballos = caballos;
    }
    
    public Deportivo(){
        super();
        this.caballos = 200;
    }
}
