/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroNotas;

/**
 *
 * @author Morad
 */
public class Alumno {
    
    String id,nombre;
    int nota1,nota2,proyecto,practica;

    public Alumno(String id, String nombre, int nota1, int nota2, int proyecto, int practica) {
        this.id = id;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2; 
        this.proyecto = proyecto;
        this.practica = practica;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + ", proyecto=" + proyecto + ", practica=" + practica + '}';
    }
    
    
    
}
