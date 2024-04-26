package servicio;

import dominio.Pelicula;

import java.io.*;

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
        //volver abrir el archivo
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            //abrir para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //leer linea a linea
            String linea;
            linea = entrada.readLine();

            System.out.println("######## Listado de peliculas ##############");
            // leer todas las lineas
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                linea = entrada.readLine();
            }

            System.out.println("#########################################");
            // cerrar el archivo
            entrada.close();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        File archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));

            //agregar pelicula
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archivo el nombre de la pelicula: " + pelicula);

        } catch (Exception e) {
            System.out.println("Ocurrio un error al agregar en el archivo: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            // abrimos para leer linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = entrada.readLine();
            int indice = 1;
            boolean coincidencia = false;
            String peliculaBuscar = pelicula.getNombre();

            while (linea != null ) {
                // buscar
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(linea)){
                    coincidencia = true;
                    break;
                }

                // leer la siguiente linea
                linea = entrada.readLine();
                indice++;
            }

            if ( coincidencia ) {
                System.out.println(pelicula.getNombre() + " encontrada en la linea: " + indice);
            } else {
                System.out.println("No se encontro la pelicula: " + pelicula.getNombre());
            }

            // cerrar archivo
            entrada.close();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al buscar en el archivo: " + e.getMessage());
        }
    }
}
