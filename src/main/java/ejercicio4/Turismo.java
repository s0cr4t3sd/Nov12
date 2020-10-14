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
public final class Turismo extends Vehiculo{
    private boolean baca;

    public Turismo(boolean baca, String matricula, String marca, String modelo, String color, int nPlazas) {
        super(matricula, marca, modelo, color, nPlazas);
        this.baca = baca;
    }

    public Turismo(boolean baca) {
        super();
        this.baca = baca;
    }
    
    public Turismo(){
        super();
        this.baca = false;
    }
    
    //CONSTRUCTOR COPIA CON HERENCIA
    public Turismo(Turismo turismo){
        super(turismo.getMatricula(), turismo.getMarca(), turismo.getModelo(), turismo.getColor(), turismo.getnPlazas());
        this.baca = turismo.baca;
    }

    public boolean isBaca() {
        return baca;
    }

    public void setBaca(boolean baca) {
        this.baca = baca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.baca ? 1 : 0);
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
        final Turismo other = (Turismo) obj;
        if (this.baca != other.baca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String respuesta = (baca)? "Si":"No";
        return super.toString()+":" + respuesta;
    }
    
    
    
}
