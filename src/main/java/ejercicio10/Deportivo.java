/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import ejercicio7.*;
import ejercicio4.*;

/**
 *
 * @author cronida
 */
public final class Deportivo extends Vehiculo{
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
    
    //CONSTRUCTOR COPIA CON HERENCIA
    public Deportivo(Deportivo deportivo){
        super(deportivo.getMatricula(), deportivo.getMarca(), deportivo.getModelo(), deportivo.getColor(), deportivo.getnPlazas());
        this.caballos = deportivo.caballos;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.caballos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deportivo other = (Deportivo) obj;
        if (this.caballos != other.caballos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+":" + caballos;
    }
    
    
}
