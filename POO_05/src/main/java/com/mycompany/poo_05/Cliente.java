package com.mycompany.poo_05;

//Paz


public class Cliente {
    private String nombre;
    private String ape;
    private int dni;

    public Cliente(String nombre, String ape, int dni) {
        this.nombre = nombre;
        this.ape = ape;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    public void mostrarDatos(){
        System.out.println("Nombre: " +this.nombre+ "\nApellido: " +this.ape+ "\nDNI: " +this.dni);
    }
}
