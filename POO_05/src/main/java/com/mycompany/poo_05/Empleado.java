/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_05;

//Mitre

public class Empleado {
    private String nombre;
    private String cargo;
    private double sueldo;
    private int dni;
    
    public Empleado(String n, String c, double s, int d){
        this.nombre = n;
        this.cargo = c;
        this.sueldo = s;
        this.dni = d;
    }
    public void mostrarDatos(){
        System.out.println("Su nombre es: "+this.nombre);
        System.out.println("trabaja como: "+this.cargo);
        System.out.println("Tiene un sueldo de: "+this.sueldo);
        System.out.println("DNI: "+this.dni);
    }
}
