package com.mycompany.poo_05;

//Pieroni


public class Factura {
    private Pedido pedido;

    public Factura(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void mostrarDatos(){
        System.out.println(" " +this.pedido);
    }
}
