package pelicula;

import java.util.Objects;

/**
 * Papel dentro de una película. Une a la {@link Pelicula} con el {@link Actor} que lo interpreta.
 * Se crea desde {@link Pelicula#agregarPapel}.
 */
public class Personaje {

    private final String nombre;
    private final String tipo;
    private final String cualidad;
    private final Pelicula pelicula;
    private final Actor interprete;

    Personaje(String nombre, String tipo, String cualidad, Pelicula pelicula, Actor interprete) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del personaje no puede estar vacío");
        }
        this.nombre = nombre.strip();
        this.tipo = tipo;
        this.cualidad = cualidad;
        this.pelicula = Objects.requireNonNull(pelicula);
        this.interprete = Objects.requireNonNull(interprete, "El personaje necesita un actor");
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCualidad() {
        return cualidad;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Actor getInterprete() {
        return interprete;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", " + cualidad + ") · " + interprete.getNombre();
    }
}
