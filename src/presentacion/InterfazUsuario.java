package presentacion;

import dominio.producto;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfazUsuario {
    private ArrayList<producto> productos = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public void leerProductos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/productos.dat"))) {
            productos = (ArrayList<producto>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo de productos. Se iniciará con una lista vacía.");
        }
    }

    public void escribirProductos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/productos.dat"))) {
            oos.writeObject(productos);
        } catch (Exception e) {
            System.out.println("No se pudo guardar el archivo de productos.");
        }
    }

    public void agregarProducto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine();

        productos.add(new producto(nombre, precio, stock));
    }

    public void mostrarProductos() {
        for (producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = sc.nextLine();
        productos.removeIf(producto -> producto.getNombre().equalsIgnoreCase(nombre));
    }

    public void modificarProducto() {
        System.out.print("Nombre del producto a modificar: ");
        String nombre = sc.nextLine();
        for (producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Nuevo precio: ");
                double precio = sc.nextDouble();
                System.out.print("Nuevo stock: ");
                int stock = sc.nextInt();
                sc.nextLine(); // Clear buffer
                producto.setPrecio(precio);
                producto.setStock(stock);
                break;
            }
        }
    }
}
