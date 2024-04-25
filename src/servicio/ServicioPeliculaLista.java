package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculaLista implements IServicioPelicula {

    private final List<Pelicula> peliculas;

    public ServicioPeliculaLista() {
        peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        int indice = peliculas.indexOf(pelicula);

        if ( indice == -1 ){
            System.out.println("No se encontro la pelicula: " + pelicula.getNombre());
        } else {
            System.out.println("Pelicula encontrada en el indice: " + indice);
        }
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

        IServicioPelicula servicioPeliculas = new ServicioPeliculaLista();

        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        servicioPeliculas.listarPeliculas();

        // se debe implementar metodo equals y hashCode
        servicioPeliculas.buscarPelicula(new Pelicula("Deadpool"));

    }
}
