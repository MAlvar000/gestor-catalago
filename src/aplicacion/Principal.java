package aplicacion;

import java.util.Scanner;
import presentacion.InterfazUsuario;

public class Principal {
    public static void main(String[] args) {
        InterfazUsuario interfazUsuario = new InterfazUsuario();
        interfazUsuario.leerProductos();

        String[] opciones = {
            "1. Agregar producto",
            "2. Eliminar producto",
            "3. Modificar producto",
            "4. Mostrar productos",
            "5. Salir"
        };

        try (Scanner sc = new Scanner(System.in)) {
            boolean continuar = true;
            
            while (continuar) {
                for (String opcion : opciones) {
                    System.out.println(opcion);
                }
                
                int eleccion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                
                switch (eleccion) {
                    case 1 -> interfazUsuario.agregarProducto();
                    case 2 -> interfazUsuario.eliminarProducto();
                    case 3 -> interfazUsuario.modificarProducto();
                    case 4 -> interfazUsuario.mostrarProductos();
                    case 5 -> {
                        interfazUsuario.escribirProductos();
                        continuar = false;
                    }
                    default -> System.out.println("Opción no válida");
                }
            }
        }
    }
}
