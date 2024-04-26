package servicio;

import dominio.Pelicula;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicioPeliculasArchivo implements IServicioPelicula {

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            //si existe no se vuelve a crear
            if( archivo.exists() ) {
                System.out.println("El archivo ya existe");
            } else {
                //se crea vacio
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se creo el archivo");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
