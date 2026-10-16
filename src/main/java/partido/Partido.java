package partido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

/**
 * Partido entre dos equipos. El partido conoce a los equipos, pero un equipo
 * no depende de un partido concreto (asociación unidireccional).
 */
public class Partido {

    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("EEEE d 'de' MMMM, HH:mm", Locale.forLanguageTag("es-EC"));

    private final String lugar;
    private final LocalDateTime fecha;
    private final Equipo local;
    private final Equipo visitante;

    public Partido(String lugar, LocalDateTime fecha, Equipo local, Equipo visitante) {
        this.lugar = Objects.requireNonNull(lugar, "El lugar es obligatorio");
        this.fecha = Objects.requireNonNull(fecha, "La fecha es obligatoria");
        this.local = Objects.requireNonNull(local, "Falta el equipo local");
        this.visitante = Objects.requireNonNull(visitante, "Falta el equipo visitante");
        if (local == visitante) {
            throw new IllegalArgumentException("Un equipo no puede jugar contra sí mismo");
        }
    }

    public int totalFaltas() {
        return local.getFaltas() + visitante.getFaltas();
    }

    public String getLugar() {
        return lugar;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getFechaTexto() {
        return fecha.format(FORMATO);
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    @Override
    public String toString() {
        return local.getNombre() + " vs " + visitante.getNombre() + " · " + lugar + " · " + getFechaTexto();
    }
}
