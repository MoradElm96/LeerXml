/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroConcesionario;

/**
 *
 * @author Morad
 */
public class Coche {
    
   private String id,marca,modelo;
   private  double cilindrada;

    public Coche(String id, String marca, String modelo, double cilindrada) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Coche{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + '}';
    }
    
    
}
