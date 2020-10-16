/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import ejercicio4.*;
import java.util.Objects;

/**
 *
 * @author cronida
 */
public final class Furgoneta extends Vehiculo{
    private Tamanio tam;

    public Furgoneta(Tamanio tam, String matricula, String marca, String modelo, String color, int nPlazas) {
        super(matricula, marca, modelo, color, nPlazas);
        this.tam = tam;
    }

    public Furgoneta(Tamanio tam) {
        super();
        this.tam = tam;
    }
    
    public Furgoneta(){
        super();
        this.tam = Tamanio.PEQUENIA;
    }
    
    //CONSTRUCTOR COPIA CON HERENCIA
    public Furgoneta(Furgoneta furgoneta){
        super(furgoneta.getMatricula(), furgoneta.getMarca(), furgoneta.getModelo(), furgoneta.getColor(), furgoneta.getnPlazas());
        this.tam = furgoneta.tam;
    }

    public Tamanio getTam() {
        return tam;
    }

    public void setTam(Tamanio tam) {
        this.tam = tam;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.tam);
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
        final Furgoneta other = (Furgoneta) obj;
        if (this.tam != other.tam) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+":" + tam.toString();
    }
    
    
    
}
