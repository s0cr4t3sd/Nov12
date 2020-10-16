/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author cronida
 */
public abstract class Vehiculo {
    private String matricula, marca, modelo, color;
    private int nPlazas;

    public Vehiculo(String matricula, String marca, String modelo, String color, int nPlazas) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.nPlazas = nPlazas;
    }
    
    public Vehiculo (){
        this.matricula = this.genMatricula();
        this.marca = "Hacendado";
        this.modelo = "No";
        this.color = "Rojo";
        this.nPlazas = 5;
    }
    
    //CONSTRUCTOR PARA COPIAR UN OBJETO VEHICULO
    public Vehiculo (Vehiculo vehiculo){
        this.matricula = vehiculo.matricula;
        this.marca = vehiculo.marca;
        this.modelo = vehiculo.modelo;
        this.color = vehiculo.color;
        this.nPlazas = vehiculo.nPlazas;
    }

    public String getMatricula() {
        return matricula;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getColor() {
        return color;
    }
    public int getnPlazas() {
        return nPlazas;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setnPlazas(int nPlazas) {
        this.nPlazas = nPlazas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.matricula);
        hash = 41 * hash + Objects.hashCode(this.marca);
        hash = 41 * hash + Objects.hashCode(this.modelo);
        hash = 41 * hash + Objects.hashCode(this.color);
        hash = 41 * hash + this.nPlazas;
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
        final Vehiculo other = (Vehiculo) obj;
        if (this.nPlazas != other.nPlazas) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return matricula + ":" + marca + ":" + modelo + ":" + color + ":" + nPlazas;
    }
    
    private String genMatricula(){
        Random rdn = new Random();
        String matricula = "";
        char car;
        
        for(int i = 0; i < 4; i++){
            matricula += rdn.nextInt(10);
        }
        
        for (int i = 0; i < 3; i++) {
            car = (char) (rdn.nextInt(25)+65);
            matricula += String.valueOf(car);
        }
        
        return matricula;
    }
    
}
