package pelicula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Actor con los papeles que ha interpretado. Un actor puede salir en varias películas.
 */
public class Actor {

    private final String nombre;
    private final int anioNacimiento;
    private final String paisOrigen;
    private final List<Personaje> papeles = new ArrayList<>();

    public Actor(String nombre, int anioNacimiento, String paisOrigen) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.strip();
        this.anioNacimiento = anioNacimiento;
        this.paisOrigen = paisOrigen;
    }

    /** Solo lo llama {@link Pelicula#agregarPapel}. */
    void agregarPapel(Personaje papel) {
        papeles.add(papel);
    }

    public List<Personaje> getPapeles() {
        return Collections.unmodifiableList(papeles);
    }

    public List<Pelicula> getPeliculas() {
        return papeles.stream().map(Personaje::getPelicula).distinct().toList();
    }

    /** Edad aproximada del actor en el año de estreno (solo compara años, no fechas). */
    public int edadEnEstreno(Pelicula pelicula) {
        return pelicula.getAnio() - anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    @Override
    public String toString() {
        return nombre + " (" + paisOrigen + ", " + anioNacimiento + ")";
    }
}
