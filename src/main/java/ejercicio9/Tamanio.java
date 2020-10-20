/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import ejercicio7.*;
import ejercicio4.*;

/**
 *
 * @author cronida
 */
public enum Tamanio {
    PEQUENIA("Pequeña"),
    MEDIANA("Mediana"),
    GRANDE("Grande");
    
    private final String tamanio;

    private Tamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return tamanio;
    }
    
}
