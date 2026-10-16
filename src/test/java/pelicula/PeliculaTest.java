package pelicula;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class PeliculaTest {

    @Test
    void elPapelUnePeliculaYActorEnAmbosSentidos() {
        Actor daniel = new Actor("Daniel Radcliffe", 1989, "Reino Unido");
        Pelicula piedra = new Pelicula("La piedra filosofal", "Fantasía", 2001);
        Personaje harry = piedra.agregarPapel("Harry Potter", "Mago", "Perseverante", daniel);

        assertSame(piedra, harry.getPelicula());
        assertSame(daniel, harry.getInterprete());
        assertEquals(List.of(harry), piedra.getPersonajes());
        assertEquals(List.of(harry), daniel.getPapeles());
    }

    @Test
    void unActorPuedeSalirEnVariasPeliculas() {
        Actor daniel = new Actor("Daniel Radcliffe", 1989, "Reino Unido");
        Pelicula piedra = new Pelicula("La piedra filosofal", "Fantasía", 2001);
        Pelicula camara = new Pelicula("La cámara secreta", "Fantasía", 2002);
        piedra.agregarPapel("Harry Potter", "Mago", "Perseverante", daniel);
        camara.agregarPapel("Harry Potter", "Mago", "Valiente", daniel);

        assertEquals(List.of(piedra, camara), daniel.getPeliculas());
        assertEquals(12, daniel.edadEnEstreno(piedra));
    }
}
