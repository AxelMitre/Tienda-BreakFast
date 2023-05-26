package com.mycompany.poo_05;

//Mitre

import java.util.ArrayList;


public class Desayuno {
    private ArrayList<Ingredientes> ingredientes;
    private double precio;
    private String nombre;

    public Desayuno(ArrayList<Ingredientes> ingredientes, String nombre) {
        this.ingredientes = ingredientes;
        this.nombre = nombre;
    }

    public ArrayList<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }


    public void mostrarDatos(){
        System.out.println(" " +this.ingredientes+ " " +this.nombre);
    }

}

