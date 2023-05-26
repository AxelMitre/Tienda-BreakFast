/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_05;


//Mitre

import java.util.ArrayList;

public class Ingredientes {
    private ArrayList<String> nombres;
    private ArrayList<Double> precios;

    public Ingredientes() {
        nombres = new ArrayList<>();
        precios = new ArrayList<>();
    }

    public void agregarIngrediente(String nombre, double precio) {
        nombres.add(nombre);
        precios.add(precio);
    }

    public String getNombre(int indice) {
        return nombres.get(indice);
    }

    public double getPrecio(int indice) {
        return precios.get(indice);
    }

    public int getCantidadIngredientes() {
        return nombres.size();
    }
    
    public void mostrarIngredientes() {        
        System.out.println("Lista de ingredientes:");
        for (int i = 0; i < nombres.size(); i++) {
            String nombre = nombres.get(i);
            double precio = precios.get(i);
            System.out.println("Nombre: " + nombre + ", Precio: " + precio);
        }
    }
}
