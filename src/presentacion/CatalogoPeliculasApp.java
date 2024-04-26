package presentacion;

import dominio.Pelicula;
import servicio.IServicioPelicula;
import servicio.ServicioPeliculaLista;
import servicio.ServicioPeliculasArchivo;

import java.util.Scanner;

public class CatalogoPeliculasApp {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        boolean salir = false;

        //IServicioPelicula servicioPeliculas = new ServicioPeliculaLista();
        IServicioPelicula servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            } catch ( Exception e ) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPelicula servicioPeliculas) {

        int opcion = Integer.parseInt(consola.nextLine());
        boolean salir = false;

        switch ( opcion ) {
            case 1 -> {
                System.out.print("Ingresa el nombre de la pelicula: ");
                String nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> {
                servicioPeliculas.listarPeliculas();
            }
            case 3 -> {
                System.out.print("Ingresa la pelicula a buscar: ");
                String busqueda = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(busqueda));
            }
            case 4 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: " + opcion);
        }

        return salir;

    }

    private static void mostrarMenu() {
        System.out.println("""
                ***** Catalogo de Peliculas ******
                1. Agregar pelicula
                2. Listar peliculas
                3. Buscar pelicula
                4. Salir
                """);

        System.out.print("Ingresa la opcion de tu eleccion: ");
    }
}
