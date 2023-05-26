/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_05;


//Villanueva

public class Tienda {
  
    private String nombre;
    private Empleado[] empleado;
    private Cliente[] cliante;

    public Tienda(String n ,Empleado[] e,Cliente[] c){
        this.nombre = n;
        this.empleado = e;
        this.cliante = c;
    }
    public void mostrarDatos(){
        System.out.println("Nombre del tienda: "+this.nombre+
                            "Empleado: "+this.empleado+
                            "cliente: "+this.cliante);
    }
}

