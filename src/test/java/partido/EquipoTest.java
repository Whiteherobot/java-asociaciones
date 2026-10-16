package partido;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EquipoTest {

    @Test
    void agregarJugadorAsociaAmbosLados() {
        Equipo equipo = new Equipo("PapitasCrew", "MichiCorp");
        Jugador hugo = new Jugador("Hugo", 1);
        equipo.agregarJugador(hugo);
        assertSame(equipo, hugo.getEquipo());
        assertEquals(1, equipo.getJugadores().size());
    }

    @Test
    void unJugadorNoPuedeEstarEnDosEquipos() {
        Jugador hugo = new Jugador("Hugo", 1);
        new Equipo("A", null).agregarJugador(hugo);
        assertThrows(IllegalStateException.class, () -> new Equipo("B", null).agregarJugador(hugo));
    }

    @Test
    void noSeRepiteElNumero() {
        Equipo equipo = new Equipo("A", null);
        equipo.agregarJugador(new Jugador("Hugo", 10));
        assertThrows(IllegalArgumentException.class, () -> equipo.agregarJugador(new Jugador("Leo", 10)));
    }

    @Test
    void cuentaLesionadosYDisponibles() {
        Equipo equipo = new Equipo("A", null);
        Jugador leo = new Jugador("Leo", 5);
        equipo.agregarJugador(leo);
        equipo.agregarJugador(new Jugador("Hugo", 1));
        leo.lesionar();
        assertEquals(1, equipo.jugadoresLesionados());
        assertEquals(1, equipo.jugadoresDisponibles());
    }

    @Test
    void elPartidoNecesitaDosEquiposDistintos() {
        Equipo a = new Equipo("A", null);
        Equipo b = new Equipo("B", null);
        LocalDateTime fecha = LocalDateTime.of(2022, 4, 23, 21, 0);
        assertThrows(IllegalArgumentException.class, () -> new Partido("Cuenca", fecha, a, a));
        a.registrarFalta();
        b.registrarFalta();
        b.registrarFalta();
        assertEquals(3, new Partido("Cuenca", fecha, a, b).totalFaltas());
    }

    @Test
    void elPlantelNoSeModificaDesdeAfuera() {
        Equipo equipo = new Equipo("A", null);
        assertThrows(UnsupportedOperationException.class, () -> equipo.getJugadores().add(new Jugador("X", 2)));
    }
}
