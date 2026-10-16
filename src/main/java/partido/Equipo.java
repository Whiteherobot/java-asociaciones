package partido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Equipo con su plantilla de jugadores (asociación uno a muchos, bidireccional).
 */
public class Equipo {

    private final String nombre;
    private final String patrocinador;
    private final List<Jugador> jugadores = new ArrayList<>();
    private int faltas;

    public Equipo(String nombre, String patrocinador) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del equipo no puede estar vacío");
        }
        this.nombre = nombre.strip();
        this.patrocinador = patrocinador;
    }

    /**
     * Agrega un jugador y lo asocia a este equipo. Un jugador solo puede estar en
     * un equipo y dos jugadores no pueden llevar el mismo número.
     */
    public void agregarJugador(Jugador jugador) {
        if (jugador.getEquipo() != null) {
            throw new IllegalStateException(jugador.getNombre() + " ya pertenece a " + jugador.getEquipo().getNombre());
        }
        boolean numeroOcupado = jugadores.stream().anyMatch(j -> j.getNumero() == jugador.getNumero());
        if (numeroOcupado) {
            throw new IllegalArgumentException("El número " + jugador.getNumero() + " ya está ocupado en " + nombre);
        }
        jugadores.add(jugador);
        jugador.asignarEquipo(this);
    }

    public void registrarFalta() {
        faltas++;
    }

    public long jugadoresLesionados() {
        return jugadores.stream().filter(Jugador::isLesionado).count();
    }

    public long jugadoresDisponibles() {
        return jugadores.size() - jugadoresLesionados();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public List<Jugador> getJugadores() {
        return Collections.unmodifiableList(jugadores);
    }

    public int getFaltas() {
        return faltas;
    }

    @Override
    public String toString() {
        return nombre + (patrocinador == null ? "" : " (patrocina " + patrocinador + ")");
    }
}
