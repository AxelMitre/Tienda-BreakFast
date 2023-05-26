package com.mycompany.poo_05;

//Paz

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private Empleado nombreE;
    private Cliente cli;
    private ArrayList<Desayuno> listaPedido;
    private double precio;

    
    public Pedido(int idPedido, Empleado nombreE, Cliente cli, ArrayList<Desayuno> listaPedido, double precio) {
        this.idPedido = idPedido;
        this.nombreE = nombreE;
        this.cli = cli;
        this.listaPedido = listaPedido;
        this.precio = precio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Empleado getNombreE() {
        return nombreE;
    }

    public void setNombreE(Empleado nombreE) {
        this.nombreE = nombreE;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public ArrayList<Desayuno> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(ArrayList<Desayuno> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public void mostrarDatos(){
        System.out.println("ID del Pedido: " +this.idPedido+
                "\nNombre del empleado: " +this.nombreE+
                "\nCliente: " +this.cli+
                "\nPedido: " +this.listaPedido);
    }
}
