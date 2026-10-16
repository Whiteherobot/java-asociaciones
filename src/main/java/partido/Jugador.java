package partido;

/**
 * Jugador de un equipo. La asociación con {@link Equipo} la establece el equipo
 * al agregarlo, para que ambos lados queden siempre consistentes.
 */
public class Jugador {

    private final String nombre;
    private final int numero;
    private boolean lesionado;
    private Equipo equipo;

    public Jugador(String nombre, int numero) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (numero < 1 || numero > 99) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 99");
        }
        this.nombre = nombre.strip();
        this.numero = numero;
    }

    public void lesionar() {
        lesionado = true;
    }

    public void recuperar() {
        lesionado = false;
    }

    /** Solo lo llama {@link Equipo#agregarJugador(Jugador)}. */
    void asignarEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isLesionado() {
        return lesionado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    @Override
    public String toString() {
        return numero + ". " + nombre + (lesionado ? " (lesionado)" : "");
    }
}
