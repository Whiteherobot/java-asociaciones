package pelicula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Película con su reparto. Cada papel es un {@link Personaje} interpretado por un {@link Actor}.
 */
public class Pelicula {

    private final String titulo;
    private final String categoria;
    private final int anio;
    private final List<Personaje> personajes = new ArrayList<>();

    public Pelicula(String titulo, String categoria, int anio) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (anio < 1888) {
            throw new IllegalArgumentException("Año de estreno no válido");
        }
        this.titulo = titulo.strip();
        this.categoria = categoria;
        this.anio = anio;
    }

    /**
     * Crea el papel y lo asocia en los tres sentidos: la película conoce al
     * personaje, el personaje a su actor y el actor a su papel.
     */
    public Personaje agregarPapel(String personaje, String tipo, String cualidad, Actor actor) {
        Personaje papel = new Personaje(personaje, tipo, cualidad, this, actor);
        personajes.add(papel);
        actor.agregarPapel(papel);
        return papel;
    }

    public List<Personaje> getPersonajes() {
        return Collections.unmodifiableList(personajes);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return titulo + " (" + anio + ", " + categoria + ")";
    }
}
