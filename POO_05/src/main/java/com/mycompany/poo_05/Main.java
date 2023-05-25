package com.mycompany.poo_05;

import java.util.ArrayList;
import java.util.Scanner;

//Villanueva

public class Main {
    public static void main(String[] args) {
        DataTienda();
    }

    private static void DataTienda() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Cual es el nombre de la tienda: ");
        String nombre = lector.next();
        // Solicitar los datos de los empleados utilizando el método DataEmpleado()
        Empleado[] empleados = DataEmpleado();
        // Solicitar los datos de los clientes utilizando el método DataCliente()
        Cliente[] clientes = DataCliente(empleados);
        // Solicitar los datos de los pedidos utilizando el método CargarPedido()
        Pedido[] pedidos = CargarPedido(clientes, empleados);
    }

    private static Empleado[] DataEmpleado() {
        Scanner lector = new Scanner(System.in); // Inicializa un objeto Scanner para leer la entrada del usuario.
        System.out.println("Cuantos Empleados va a ingresar: "); // Solicita al usuario ingresar el número de empleados a ingresar.
        int numE = lector.nextInt(); // Lee el número de empleados ingresado por el usuario.
        Empleado[] empleados = new Empleado[numE]; // Crea una lista de Empleado con el tamaño especificado por el usuario.
        for (int i = 0; i < numE; i++) {
            empleados[i] = CargoEmpleado(i); // Llama al método CargoEmpleado() para ingresar los datos del empleado actual.
        }
        return empleados; // Devuelve los empleados ingresados.
    }

    private static Empleado CargoEmpleado(int indice) {
        Scanner lector = new Scanner(System.in); // Inicializa un objeto Scanner para leer la entrada del usuario.
        System.out.println("Cual es el nombre del empleado: "); // Solicita al usuario ingresar el nombre del empleado.
        String nombre = lector.next(); // Lee el nombre ingresado por el usuario.
        System.out.println("Cual es el cargo del empleado: "); // Solicita al usuario ingresar el cargo del empleado.
        String cargo = lector.next(); // Lee el cargo ingresado por el usuario.
        double sueldo = 5000.00; // Asigna un valor predefinido para el sueldo del empleado.
        System.out.println("Cual es el DNI del empleado: "); // Solicita al usuario ingresar el DNI del empleado.
        int dni = lector.nextInt(); // Lee el DNI ingresado por el usuario.
        return new Empleado(nombre, cargo, sueldo, dni); // Crea y devuelve un objeto Empleado con los datos ingresados.
    }

    private static Cliente[] DataCliente(Empleado[] empleados) {
        Scanner lector = new Scanner(System.in); // Inicializa un objeto Scanner para leer la entrada del usuario.
        System.out.println("Cuantos clientes va a agregar"); // Solicita al usuario ingresar la cantidad de clientes a agregar.
        int numC = lector.nextInt(); // Lee la cantidad de clientes ingresada por el usuario.
        Cliente[] clientes = new Cliente[numC]; // Crea una lista de Cliente con el tamaño especificado.
        for (int i = 0; i < numC; i++) { // Llama al método CargoCliente() para ingresar los datos de un cliente específico.
            clientes[i-1] = CargoCliente(i,empleados);
        }
        return clientes; // Devuelve clientes con los datos ingresados.
    }

    private static Cliente CargoCliente(int i, Empleado[] empleados) {
        Cliente[] clientes = new Cliente[i]; // Crea una lisra de Cliente con el tamaño especificado.
        Scanner lector = new Scanner(System.in); // Inicializa un objeto Scanner para leer la entrada del usuario.
        System.out.println("Cual es el nombre del cliente: "); // Solicita al usuario ingresar el nombre del cliente.
        String nom = lector.next(); // Lee el nombre ingresado por el usuario.
        System.out.println("Cual es el apellido del cliente: "); // Solicita al usuario ingresar el apellido del cliente.
        String ape = lector.next(); // Lee el apellido ingresado por el usuario.
        System.out.println("Cual es el DNI del cliente: "); // Solicita al usuario ingresar el DNI del cliente.
        int dni = lector.nextInt(); // Lee el DNI ingresado por el usuario.
        clientes[i-1] = new Cliente(nom, ape, dni); // Crea un objeto Cliente con los datos ingresados.
        return clientes[i-1]; // Devuelve el objeto Cliente creado.
    }


    private static Pedido[] CargarPedido(Cliente[] clientes, Empleado[] empleados) {
        Scanner lector = new Scanner(System.in); // Inicializa un objeto Scanner para leer la entrada del usuario.
        System.out.println("¿Cuántos pedidos desea ingresar? "); // Solicita al usuario ingresar la cantidad de pedidos a ingresar.
        int numPedidos = lector.nextInt(); // Lee la cantidad de pedidos ingresada por el usuario.
        Pedido[] pedidos = new Pedido[numPedidos]; // Crea uno lista de Pedido con el tamaño especificado.
        for (int i = 0; i < numPedidos; i++) {
            System.out.println("Pedido número " + (i + 1) + ":"); // Imprime el número de pedido actual.
            System.out.println("Ingrese el número de empleado asociado al pedido:"); // Solicita al usuario ingresar el número de empleado asociado al pedido.
            int numEmpleado = lector.nextInt(); // Lee el número de empleado ingresado por el usuario.
            Empleado empleado = empleados[numEmpleado - 1]; // Obtiene el objeto Empleado correspondiente al número ingresado.
            System.out.println("Ingrese el número de cliente asociado al pedido:"); // Solicita al usuario ingresar el número de cliente asociado al pedido.
            int numCliente = lector.nextInt(); // Lee el número de cliente ingresado por el usuario.
            Cliente cliente = clientes[numCliente-1]; // Obtiene el objeto Cliente correspondiente al número ingresado.
            ArrayList<Desayuno> listaDesayunos = CargarDesayunos(); // Llama al método CargarDesayunos() para obtener una lista de desayunos.
            double precio = CalcularPrecio(listaDesayunos,  i); // Calcula el precio del pedido según la lista de desayunos.
            pedidos[i-1] = new Pedido(i, empleado, cliente, listaDesayunos, precio); // Crea un objeto Pedido con los datos ingresados.
            crearFactura(pedidos[i-1]); // Crea una factura para el pedido.
        } 
        return pedidos; // Devuelve el array de pedidos creado.
    }

    private static ArrayList<Desayuno> CargarDesayunos() {
        Scanner lector = new Scanner(System.in); // Inicializa un objeto Scanner para leer la entrada del usuario.
        System.out.println("¿Cuántos desayunos desea agregar? "); // Solicita al usuario ingresar la cantidad de desayunos a agregar.
        int numDesayunos = lector.nextInt(); // Lee la cantidad de desayunos ingresada por el usuario.

        ArrayList<Desayuno> listaDesayunos = new ArrayList<>(); // Crea una lista de objetos Desayuno.
        
        for (int j = 0; j < numDesayunos; j++) { 
            System.out.println("Desayuno #" + (j + 1) + ":");  // Imprime el número de desayuno actual.
            System.out.print("Nombre del desayuno: "); // Solicita al usuario ingresar el nombre del desayuno.
            String nombreDesayuno = lector.next(); // Lee el nombre del desayuno ingresado por el usuario.
            
            System.out.print("¿Cuántos ingredientes tiene el desayuno? "); // Solicita al usuario ingresar la cantidad de ingredientes del desayuno.
            int numIngredientes = lector.nextInt(); // Lee la cantidad de ingredientes ingresada por el usuario.
            
            ArrayList<Ingredientes> listaIngredientes = new ArrayList<>(); // Crea una lista de objetos Ingredientes para los ingredientes del desayuno.
            
            for (int i = 0; i < numIngredientes; i++) {
                System.out.println("Ingrediente #" + (i + 1) + ":"); // Imprime el número de ingrediente actual.
                Ingredientes ingredientes = new Ingredientes(); // Crea un objeto Ingredientes para almacenar los ingredientes.
                ingredientes = cargarIngredientes(); // Llama al método cargarIngredientes() para obtener la lista de ingredientes disponibles.
                ingredientes.mostrarIngredientes(); // Muestra la lista de ingredientes disponibles.
                System.out.print("Ingrese el número del ingrediente que desea agregar: "); // Solicita al usuario ingresar el número del ingrediente a agregar.
                int indiceIngrediente = lector.nextInt(); // Lee el número del ingrediente ingresado por el usuario.
                String nombreIngrediente = ingredientes.getNombre(indiceIngrediente-1); // Obtiene el nombre del ingrediente seleccionado.
                double precioIngrediente = ingredientes.getPrecio(indiceIngrediente-1); // Obtiene el precio del ingrediente seleccionado.
                System.out.println(nombreIngrediente+" "+precioIngrediente); // Imprime el nombre y el precio del ingrediente seleccionado.
                
                Ingredientes ingrediente = new Ingredientes(); // Crea un objeto Ingredientes para el ingrediente seleccionado.
                ingrediente.agregarIngrediente(nombreIngrediente, precioIngrediente); // Agrega el ingrediente a la lista de ingredientes del desayuno.
                System.out.println(ingrediente); // Imprime el objeto Ingredientes creado.
                listaIngredientes.add(ingrediente);  // Agrega el objeto Ingredientes a la lista de ingredientes del desayuno.
            }
            Desayuno desayuno = new Desayuno(listaIngredientes, nombreDesayuno); // Crea un objeto Desayuno con los ingredientes y el nombre del desayuno.
            listaDesayunos.add(desayuno); // Agrega el objeto Desayuno a la lista de desayunos.
        }

        return listaDesayunos; // Devuelve la lista de desayunos creada.
    }

    private static Ingredientes cargarIngredientes() {
        Ingredientes ListaIngrediente = new Ingredientes(); // Crea un objeto Ingredientes para almacenar la lista de ingredientes.
        
        ListaIngrediente.agregarIngrediente("Medialunas", 50); // Agrega el ingrediente "Medialunas" con un precio de 50 a la lista.
        ListaIngrediente.agregarIngrediente("cafe", 150); // Agrega el ingrediente "cafe" con un precio de 150 a la lista.
        ListaIngrediente.agregarIngrediente("sandiwches", 50); // Agrega el ingrediente "sandiwches" con un precio de 50 a la lista.
        ListaIngrediente.agregarIngrediente("Creppe", 50); // Agrega el ingrediente "Creppe" con un precio de 50 a la lista.
        ListaIngrediente.agregarIngrediente("Latte descafeinado", 50); // Agrega el ingrediente "Latte descafeinado" con un precio de 50 a la lista.
        
        return ListaIngrediente; // Devuelve el objeto Ingredientes con la lista de ingredientes predefinida.
    }

    private static void crearFactura(Pedido pedidos) {
        Factura factura = new Factura(pedidos); // Crea un objeto Factura utilizando el pedido dado.
        factura.mostrarDatos(); // Muestra los datos de la factura.
    }

    private static double CalcularPrecio(ArrayList<Desayuno> listaDesayunos, int id) {
        double precio = 0; // Inicializa el precio en 0.
        if (id % 11 == 0) { // Verifica si el ID es múltiplo de 11.
            precio = 0; // Establece el precio en 0 si el ID es múltiplo de 11.
            return precio; // Retorna el precio.
        } else {
            // Recorre la lista de desayunos y sus ingredientes para calcular el precio.
            for (Desayuno desayuno : listaDesayunos) {
                ArrayList<Ingredientes> ingredientes = desayuno.getIngredientes(); // Obtiene la lista de ingredientes del desayuno.
                for (Ingredientes ingrediente : ingredientes) {
                    int cantidadIngredientes = ingrediente.getCantidadIngredientes(); // Obtiene la cantidad de ingredientes en el objeto Ingredientes.
                    for (int i = 0; i < cantidadIngredientes; i++) { 
                        double precioIngrediente = ingrediente.getPrecio(i); // Obtiene el precio del ingrediente en la posición i.
                        precio += precioIngrediente; // Suma el precio del ingrediente al precio total.
                    }
                }
            }
            return precio; // Retorna el precio total calculado.
        }
    }
}